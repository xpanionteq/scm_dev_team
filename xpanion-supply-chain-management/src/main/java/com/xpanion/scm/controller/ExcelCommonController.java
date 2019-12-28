package com.xpanion.scm.controller;

import java.io.ByteArrayInputStream;


import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xpanion.scm.dao.ReportDao;
import com.xpanion.scm.excellistview.ItemTypeReport;
import com.xpanion.scm.model.ReportModel;

@RestController
@RequestMapping("/api/item")

public class ExcelCommonController {
	@Autowired
	ReportDao Reportdao;
	
	
	public static final Logger LOGGER = LoggerFactory.getLogger(ExcelCommonController.class);

	@GetMapping(value = "/downloads/items.xlsx")
	public ResponseEntity<InputStreamResource> excelItemReport(
			
			@RequestParam(value = "itemId", required = false) int itemId) throws IOException {

		List<ReportModel> apachepoiModel = (List<ReportModel>) Reportdao.getitemtype(itemId);
	
		ByteArrayInputStream in = ItemTypeReport.buildExcelDocument(apachepoiModel);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=item_report.xlsx");

		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));

	}

}
