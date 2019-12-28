package com.xpanion.scm.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.xpanion.scm.util.CommonConstants.FAILED;
import static com.xpanion.scm.util.CommonConstants.SUCCESS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.xpanion.scm.dao.SalesOrderDao;
import com.xpanion.scm.model.OrderModel;
import com.xpanion.scm.util.ScmWebResponse;

@RestController
public class OrderController {
	@Autowired
	ScmWebResponse response;

	@Autowired
	SalesOrderDao SalesOrderDao;

	public static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);


//-------------------------------------------------------------------------------------------//
	
	@RequestMapping(value = "/order")
	public @ResponseBody ScmWebResponse getContactDetails() {
		try {
			List<OrderModel> contactTypes = SalesOrderDao.getContactDetails();
			response.setStatus(SUCCESS);
			response.setData(contactTypes);

		} catch (Exception e) {
			LOGGER.error("Issue in getContactDetails()  ", e);
			response.setData(null);
			response.setStatus(FAILED);
		}

		return response;
	}
	
//----------------------------------------------------------------------------------------------//	
	@RequestMapping(value = "/items")
	public @ResponseBody ScmWebResponse getItemDetails() {
		try {
			List<OrderModel> contactTypes = SalesOrderDao.getItemDetails();
			response.setStatus(SUCCESS);
			response.setData(contactTypes);

		} catch (Exception e) {
			LOGGER.error("Issue in getItemDetails()  ", e);
			response.setData(null);
			response.setStatus(FAILED);
		}

		return response;
	}
	
	
	

}
