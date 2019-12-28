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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xpanion.scm.dao.CompanyDao;
import com.xpanion.scm.model.CompanyModel;
import com.xpanion.scm.util.ScmWebResponse;

/*
 * @author : ASHLIN ABRAHAM	
 * @date : 22.04.2019
 * @purpose : save and update company details
 */
@RestController
public class CompanyController {

	@Autowired
	CompanyDao companyDao;
	
	@Autowired
	ScmWebResponse response;

	public static final Logger LOGGER = LoggerFactory.getLogger(CompanyController.class);
	ObjectMapper mapper = new ObjectMapper();

// ---------------------------------------------------START---------------------------------------------------------
/*
 * @author : ASHLIN ABRAHAM
 * @date :17.07.2019
 * @purpose : get industry types
 */
	@RequestMapping(value = "/industryTypes")
	public @ResponseBody ScmWebResponse getIndustryTypes() {
		try {
			List<CompanyModel> industryList = companyDao.getIndustryTypes();
			response.setData(industryList);
			response.setStatus(SUCCESS);

		} catch (Exception e) {
			LOGGER.error("Issue in getIndustryTypes() ", e);
			response.setData(null);
			response.setStatus(FAILED);
		}

		return response;
	}

// ----------------------------------------------------STOP---------------------------------------------------------

}
