package com.xpanion.scm.controller;

import static com.xpanion.scm.util.CommonConstants.FAILED;
import static com.xpanion.scm.util.CommonConstants.SUCCESS;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xpanion.scm.dao.CommonDao;
import com.xpanion.scm.util.ScmWebResponse;

/*
 * @author : ASHLIN ABRAHAM
 * @date : 02.04.2019
 * 
 */
@RestController
public class CommonController {
	@Autowired
	ScmWebResponse response;
	@Autowired
	CommonDao commonDao;

	public static final Logger LOGGER = LoggerFactory.getLogger(CommonController.class);
//------------------------------------------------START--------------------------------------------------------------
/*
 * @author : ASHLIN ABRAHAM
 * @date :26.07.2019
 * 
 * 		
 */
		@RequestMapping(value = "/saveUpdateCats", method = RequestMethod.GET)
		public @ResponseBody ScmWebResponse saveUpdateCategoryDetails(
				@RequestParam(value = "catSubCatDetailsId", required = false) int catSubCatDetailsId,
				@RequestParam(value = "categoryId", required = false) int categoryId,
				@RequestParam(value = "subCategoryId", required = false) int subCategoryId,
				@RequestParam(value = "categoryName", required = false) String categoryName,
				@RequestParam(value = "subCategoryName", required = false) String subCategoryName,
				@RequestParam(value = "activeStatus", required = false) Character activeStatus) {
			try {
				int createUserId = 1;// userSession.getUserId();
				int catReturn = commonDao.saveUpdateCategory(catSubCatDetailsId, categoryId, subCategoryId, categoryName, subCategoryName, createUserId, activeStatus);
				if (catReturn >= 1) {
					response.setStatus(SUCCESS);
				} else {
					response.setStatus(FAILED);
				}

			} catch (Exception e) {
				LOGGER.error("Issue in saveUpdateCategoryDetails() ", e);
				response.setStatus(FAILED);
			}
			return response;
			
		}
//--------------------------------------------------END----------------------------------------------------------------
//--------------------------------------------START------------------------------------------------------------------
		/*
		 * @author : ASHLIN ABRAHAM
		 * @date : 02.08.2019
		 * @purpose : check for category-sub category combo exists or not? if yes return its primary key.
		 * 
		 */
		@RequestMapping(value = "/checkCatDet")
		public @ResponseBody ScmWebResponse checkCatSubCatDetails(
				@RequestParam(value="categoryId",required=true) int categoryId,
				@RequestParam(value="subCategoryId",required=true)int  subCategoryId) {
			try {
				int detId = commonDao.getCatSubCatDetailsId(categoryId, subCategoryId);
				if(detId > 0) {
					response.setMessage(""+detId+"");
					response.setStatus(SUCCESS);	
					response.setData(null);
				}
				else {
					response.setMessage("0");
					response.setStatus(SUCCESS);
					response.setData(null);
				}

			} catch (Exception e) {
				LOGGER.error("Issue in getAllSubCategories() ", e);
				response.setData(null);
				response.setStatus(FAILED);
			}

			return response;
		}
		
}
