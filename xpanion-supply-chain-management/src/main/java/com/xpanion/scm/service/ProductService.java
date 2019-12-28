package com.xpanion.scm.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xpanion.scm.dao.ProductDao;

/*
 * @author : ASHLIN ABRAHAM
 * @date : 29.04.2019
 * 
 */
@Service
public class ProductService {
	@Autowired
	ProductDao productDao;
	
	
	public static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);
// -------------------------------------------START------------------------------------------------------------

}
