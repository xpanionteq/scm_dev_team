package com.xpanion.scm.controller;

import static com.xpanion.scm.util.CommonConstants.FAILED;
import static com.xpanion.scm.util.CommonConstants.SUCCESS;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xpanion.scm.dao.ProductDao;
import com.xpanion.scm.model.ProductModel;
import com.xpanion.scm.service.ProductService;
import com.xpanion.scm.util.ScmWebResponse;

/*
 * @author : ASHLIN ABRAHAM
 * @date : 29.04.2019
 * 
 */
@RestController
public class ProductController {

	@Autowired
	ScmWebResponse response;

	@Autowired
	ProductService productService;

	@Autowired
	ProductDao productDao;

	ObjectMapper mapper = new ObjectMapper();

	public static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

// -----------------------------------------------START-----------------------------------------------------------
	/*
	 * @author : ASHLIN ABRAHAM
	 * 
	 * @date :18.07.2019
	 * 
	 * @purpose : get category names
	 */
	@RequestMapping(value = "/categoryNames")
	public @ResponseBody ScmWebResponse getCategoryNames() {
		try {
			List<ProductModel> catList = productDao.getAllCategories();
			response.setData(catList);
			response.setStatus(SUCCESS);

		} catch (Exception e) {
			LOGGER.error("Issue in getCategoryNames() ", e);
			response.setData(null);
			response.setStatus(FAILED);
		}

		return response;
	}

//-------------------------------------------------END-----------------------------------------------------------
	// -----------------------------------------------START-----------------------------------------------------------
	/*
	 * @author : ASHLIN ABRAHAM
	 * 
	 * @date :18.07.2019
	 * 
	 * @purpose : get manufacturer names
	 */
	@RequestMapping(value = "/manNames")
	public @ResponseBody ScmWebResponse getManufacturesNames() {
		try {
			Thread.sleep(500);
			List<ProductModel> manList = productDao.getAllManufactures();
			response.setData(manList);
			response.setStatus(SUCCESS);

		} catch (Exception e) {
			LOGGER.error("Issue in getManufacturesNames() ", e);
			response.setData(null);
			response.setStatus(FAILED);
		}

		return response;
	}

	// -------------------------------------------------END-----------------------------------------------------------
	// -----------------------------------------------START-----------------------------------------------------------
	/*
	 * @author : ASHLIN ABRAHAM
	 * 
	 * @date :18.07.2019
	 * 
	 * @purpose : get category names
	 */
	@RequestMapping(value = "/subCategoryNames")
	public @ResponseBody ScmWebResponse getSubCategoryNames(
			@RequestParam(value = "categoryId", required = true) Integer categoryId) {

		try {
			List<ProductModel> subCatList = productDao.getSubCategories(categoryId);
			response.setData(subCatList);
			response.setStatus(SUCCESS);

		} catch (Exception e) {
			LOGGER.error("Issue in getSubCategoryNames() ", e);
			response.setData(null);
			response.setStatus(FAILED);
		}

		return response;
	}

	// -------------------------------------------------END-----------------------------------------------------------

	// -----------------------------------------------START-----------------------------------------------------------
	/*
	 * @author : ASHLIN ABRAHAM
	 * 
	 * @date :18.07.2019
	 * 
	 * @purpose : get units
	 */
	@RequestMapping(value = "/units")
	public @ResponseBody ScmWebResponse getUnitTypes() {
		try {
			Thread.sleep(1000);
			List<ProductModel> unitList = productDao.getAllUnits();
			response.setData(unitList);
			response.setStatus(SUCCESS);

		} catch (Exception e) {
			LOGGER.error("Issue in getUnitTypes() ", e);
			response.setData(null);
			response.setStatus(FAILED);
		}

		return response;
	}

// -------------------------------------------------END-----------------------------------------------------------
//----------------------------------------------START--------------------------------------------------------------
	/*
	 * @purpose: get all sub categories
	 */
	@RequestMapping(value = "/allSubCategories")
	public @ResponseBody ScmWebResponse getAllSubCategories() {
		try {
			List<ProductModel> subList = productDao.getAllSubCategories();
			response.setData(subList);
			response.setStatus(SUCCESS);

		} catch (Exception e) {
			LOGGER.error("Issue in getAllSubCategories() ", e);
			response.setData(null);
			response.setStatus(FAILED);
		}

		return response;
	}

//-----------------------------------------------END---------------------------------------------------------------

//--------------------------------------------START------------------------------------------------------------------
	/*
	 * @purpose : get GST values
	 */
	@RequestMapping(value = "/gstCodes")
	public @ResponseBody ScmWebResponse getGstPercentage() {
		try {

			List<ProductModel> list = productDao.getAllGstValues();
			response.setData(list);
			response.setStatus(SUCCESS);

		} catch (Exception e) {
			LOGGER.error("Issue in getGstPercentage() ", e);
			response.setData(null);
			response.setStatus(FAILED);
		}

		return response;
	}

// -------------------------------------------------END-----------------------------------------------------------
	/*
	 * @purpose : save/update/delete products
	 */
	@RequestMapping(value = "/saveProducts", method = RequestMethod.GET)
	public @ResponseBody ScmWebResponse saveUpdateProductDetails(
			@RequestParam(value = "productId", required = false) int productId,
			@RequestParam(value = "manufacturerId", required = false) int manfacturerId,
			@RequestParam(value = "unitId", required = false) int unitId,
			@RequestParam(value = "itemName", required = false) String itemName,
			@RequestParam(value = "itemDescription", required = false) String itemDescription,
			@RequestParam(value = "productGstId", required = false) int productGstId,
			@RequestParam(value = "catSubCatId", required = false) int catSubCatId,
			@RequestParam(value = "hsnCode", required = false) int hsnCode,
			@RequestParam(value = "mrp", required = false) double mrp,
			@RequestParam(value = "stockThreshold", required = false) double stockthreshold,
			@RequestParam(value = "openingStock", required = false) double openingStock,
			@RequestParam(value = "additionalAttributes", required = false) String additionalAttribute,
			@RequestParam(value = "activeStatus", required = false) Character activeStatus,
			@RequestParam(value = "color", required = false) String color,
			@RequestParam(value = "size", required = false) String size,
			@RequestParam(value = "shape", required = false) String shape,
			@RequestParam(value = "length", required = false) String length,
			@RequestParam(value = "weight", required = false) String weight,
			@RequestParam(value = "volume", required = false) String volume,
			@RequestParam(value = "height", required = false) String height)
			throws JsonParseException, JsonMappingException, IOException {

		try {
			int createUserId = 1;// userSession.getUserId();
			int warehouseId = 1;

			int productReturn = productDao.saveUpdateProducts(productId, productGstId, catSubCatId, itemName,
					itemDescription, stockthreshold, openingStock, mrp, hsnCode, color, size, shape, volume, height,
					weight, length, additionalAttribute, unitId, manfacturerId, createUserId, warehouseId,
					activeStatus);
			if (productReturn >= 1) {
				response.setStatus(SUCCESS);
			} else {
				response.setStatus(FAILED);
			}

		} catch (Exception e) {
			LOGGER.error("Issue in saveUpdateCustomerDetails() ", e);
			response.setStatus(FAILED);
		}
		return response;
	}

//-----------------------------------------------------------------END---------------------------------------------------------
//----------------------------------------------------------------START----------------------------------------------------------
	/*
	 * @author : ASHLIN ABRAHAM
	 * 
	 * @date : 20.07.2019
	 * 
	 * @purpose : get product details with ID
	 * 
	 */
	@RequestMapping(value = "/getProducts")
	public @ResponseBody ScmWebResponse getProductDetails(
			@RequestParam(value = "productId", required = false) int productId) {
		try {
			List<ProductModel> products = productDao.getProductDetails(productId);
			response.setData(products);
			response.setStatus(SUCCESS);

		} catch (Exception e) {
			LOGGER.error("Issue in getProductDetails() ", e);
			response.setData(null);
			response.setStatus(FAILED);
		}

		return response;
	}

//---------------------------------------------END----------------------------------------------------------------------
//----------------------------------------------START-----------------------------------------------------------------
	/*
	 * @author : ASHLIN ABRAHAM
	 * 
	 * @date : 31.07.2019
	 * 
	 * @purpose : get pk_category_subcategory_details_id using categoryId and subCategoryId
	 */
	@RequestMapping(value = "/catSubCatDetailsId")
	public @ResponseBody ScmWebResponse getCatSubCatDetailsId(
			@RequestParam(value = "categoryId", required = false) int categoryId,
			@RequestParam(value = "subcategoryId", required = false) int subcategoryId) {
		try {
			List<ProductModel> products = productDao.getCatSubCatDetails(categoryId, subcategoryId);
			response.setData(products);
			response.setStatus(SUCCESS);

		} catch (Exception e) {
			LOGGER.error("Issue in getCatSubCatDetailsId() ", e);
			response.setData(null);
			response.setStatus(FAILED);
		}

		return response;
	}
//--------------------------------------------------END--------------------------------------------------------------
	@RequestMapping(value = "/itemedit")
	public @ResponseBody ScmWebResponse getitemedit(int productId) {
		try {
			List<ProductModel> Itemlist = productDao.getitemedit(productId);
			response.setStatus(SUCCESS);
			response.setData(Itemlist);

		} catch (Exception e) {
			LOGGER.error("Issue in getitemlists() ", e);
			response.setData(null);
			response.setStatus(FAILED);
		}

		return response;
	}
}


