package com.xpanion.scm.service;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.xpanion.scm.exception.FileStorageException;
import com.xpanion.scm.exception.MyFileNotFoundException;
import com.xpanion.scm.property.FileStorageProperties;

/*
 * @author : ASHLIN ABRAHAM
 * @date : 29.04.2019
 * 
 */
@Service
public class FileStorageService {
	private final Path fileStorageLocation;

	@Autowired
	public FileStorageService(FileStorageProperties fileStorageProperties) {
		this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();

		try {
			File baseFile = new File("" + this.fileStorageLocation + "");
			if (!baseFile.exists()) {
				baseFile.mkdirs();

			}
		} catch (Exception ex) {
			throw new FileStorageException("Could not create the directory where the uploaded files will be stored.",
					ex);
		}
	}

	public String storeFile(MultipartFile file, String ret) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		try {
			if (fileName.contains("..")) {
				throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
			}
			Path targetLocation = this.fileStorageLocation;
			Path filePath = Paths.get(targetLocation.toString(), ret);
			System.out.println(filePath.toString());
			File productDir = new File("" + filePath + "");

			if (!productDir.exists()) {
				productDir.mkdirs();
				System.out.println("productDir created " + ret);
			}
			String newPath = productDir.getAbsolutePath();
			Path finalLoc = Paths.get(newPath).resolve(fileName);
			Files.copy(file.getInputStream(), finalLoc, StandardCopyOption.REPLACE_EXISTING);
			return fileName;
		} catch (IOException ex) {
			throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
		}
	}

	public Resource loadFileAsResource(String fileName) {
		try {
			Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
			Resource resource = new UrlResource(filePath.toUri());
			if (resource.exists()) {
				return resource;
			} else {
				throw new MyFileNotFoundException("File not found " + fileName);
			}
		} catch (MalformedURLException ex) {
			throw new MyFileNotFoundException("File not found " + fileName, ex);
		}
	}


}
