package com.xpanion.scm.controller;

import static com.xpanion.scm.util.CommonConstants.FAILED;
import static com.xpanion.scm.util.CommonConstants.SUCCESS;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xpanion.scm.dao.ReportDao;


import com.xpanion.scm.model.ReportModel;
import com.xpanion.scm.util.ScmWebResponse;
@RestController
public class ReportController {
	
	@Autowired
	ScmWebResponse response;
	
	@Autowired
     ReportDao reportDao;

	public static final Logger LOGGER = LoggerFactory.getLogger(ReportController.class);
//--------------------------------------------------------------------------------------------//
	@RequestMapping(value = "/getitems")
	public @ResponseBody ScmWebResponse getitems() {
		try {
			List<ReportModel> itemTypes = reportDao.getitems();
			response.setStatus(SUCCESS);
			response.setData(itemTypes);

		} catch (Exception e) {
			LOGGER.error("Issue in getitems()  ", e);
			response.setData(null);
			response.setStatus(FAILED);
		}

		return response;
	}
	
	

}
