package com.xpanion.scm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.xpanion.scm.dao.LoginDao;
import com.xpanion.scm.model.UserModel;
import com.xpanion.scm.service.LoginService;

/*
 * @author : Ashlin Abraham
 * @date : 25.03.2019
 * @purpose : view web pages
 * 
 */
@Controller
@Scope("session")
public class WebPageController {
	public static final Logger LOGGER = LoggerFactory.getLogger(WebPageController.class);
	@Autowired
	LoginDao loginDao;
	@Autowired
	LoginService loginService;
	@Autowired
	UserModel userSession;
	String empName;
	String userType;
	String designation;
	int userId;

	// -----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/contactsList", method = RequestMethod.GET)
	public String showAllContacts(Model model) {

		return "contactsList";
	}

	// -----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/phone", method = RequestMethod.GET)
	public String showAllPhoneNumbers(Model model) {

		return "phoneBook";
	}

	// -----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String showProducts(Model model) {
		LOGGER.info("products");
		return "products";
	}

	// -----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/accountant", method = RequestMethod.GET)
	public String showAccountantHome(Model model) {
		return "accountant";
	}

	// -----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/print-inv", method = RequestMethod.GET)
	public String printSalesOrderInvoice(Model model) {
		return "invoicePrint";
	}

	// -----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/mail-inv", method = RequestMethod.GET)
	public String mailSalesOrderInvoice(Model model) {
		return "invoiceMail";
	}

	// -----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/sales", method = RequestMethod.GET)
	public String showSalesMaster(Model model) {
		LOGGER.info("sales");
		return "salesMaster";
	}

	// -----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/salesOrders", method = RequestMethod.GET)
	public String showNewSalesOrder(Model model) {

		return "salesOrders";
	}

	// -----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/purchases", method = RequestMethod.GET)
	public String showPurchaseMaster(Model model) {
		return "purchasesMaster";
	}

	// -----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/purchaseOrders", method = RequestMethod.GET)
	public String showNewPurchaseOrder(Model model) {

		return "purchaseOrders";
	}

	// -----------------------------------------------------------------------------------------------------------------
	
	// -------------------------------------------------------------------------------------------------------------------------------
		@RequestMapping(value = "/pendingPurchase", method = RequestMethod.GET)
		public String showPendingPurchase(Model model) {
			
			return "pendingPurchase";
		}

// -----------------------------------------------------------------------------------------------------------------------------------

	@RequestMapping(value = "/warehouse", method = RequestMethod.GET)
	public String showWarehouseMaster(Model model) {
		LOGGER.info("warehouse");
		return "warehouseDetails";
	}

	// -----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/configureWH", method = RequestMethod.GET)
	public String configureWarehouseMaster(Model model) {
		LOGGER.info("configureWH");
		return "configureWH";
	}

	// -----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/stock", method = RequestMethod.GET)
	public String showStockDetails(Model model) {
		LOGGER.info("stock");
		return "itemStock";
	}

	// -----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerYourCompany(Model model) {
		LOGGER.info("reg");
		return "registerCompany";
	}

	// -----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/employeeList", method = RequestMethod.GET)
	public String showEmployeeList(Model model) {
		return "employeeList";
	}

	// -------------------------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/contacts", method = RequestMethod.GET)
	public String home(Model model) {
		LOGGER.info("dashBoard");
		return "contacts";
	}

	/*
	 * public String showContactsPage(ModelMap model){ userId =
	 * userSession.getUserId(); if(userId > 0) {
	 * 
	 * empName = userSession.getFirstName(); empName =
	 * empName.concat(" "+userSession.getLastName()); userType =
	 * userSession.getUserType(); designation = userSession.getDesignation();
	 * model.put("name", empName); model.put("userType", userType);
	 * model.put("designation", designation);
	 * 
	 * return "contacts"; } model.put("errorMessage",
	 * "Session expired. Login Now!!"); return "login"; }
	 * 
	 * 
	 */ // -----------------------------------------------------------------------------------------------------------------------------------
		// -------------------------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/newContact", method = RequestMethod.GET)
	/*
	 * public String newContact(Model model) { LOGGER.info("newContact"); return
	 * "newContact"; }
	 */
	public String showNewContactsPage(ModelMap model) {
		userId = userSession.getUserId();
		if (userId > 0) {

			empName = userSession.getFirstName();
			empName = empName.concat(" " + userSession.getLastName());
			userType = userSession.getUserType();
			designation = userSession.getDesignation();
			model.put("name", empName);
			model.put("userType", userType);
			model.put("designation", designation);

			return "newContact";
		}
		model.put("errorMessage", "Session expired. Login Now!!");
		return "login";
	}

	// -----------------------------------------------------------------------------------------------------------------------------------
	// -------------------------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/adminHome", method = RequestMethod.GET)
	public String administratorHome(Model model) {
		LOGGER.info("administratorHome");
		return "adminHome";
	}

	// -----------------------------------------------------------------------------------------------------------------------------------
	// -------------------------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/reports", method = RequestMethod.GET)
	public String showReports(Model model) {

		return "reports";
	}
	// -------------------------------------------------------------------------------------------------------------------------------
		@RequestMapping(value = "/routeMaster", method = RequestMethod.GET)
		public String showAllRoutes(Model model) {

			return "routeMaster";
		}

	// -------------------------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/accountMaster", method = RequestMethod.GET)
	public String showBankAccounts(Model model) {

		return "accountMaster";
	}

	// -----------------------------------------------------------------------------------------------------------------------------------
	// -------------------------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/contactProfile", method = RequestMethod.GET)
	public String contactProfile(Model model) {
		LOGGER.info("contactProfile");
		return "contactProfile";
	}

	// -----------------------------------------------------------------------------------------------------------------------------------
	// -------------------------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String employeeProfile(Model model) {
		LOGGER.info("test");
		return "test";
	}

	// -----------------------------------------------------------------------------------------------------------------------------------
	// -------------------------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/dashBoard", method = RequestMethod.GET)
	public String employeeNew(Model model) {
		LOGGER.info("employeeNew");
		return "dashBoard";
	}

	/*
	 * @RequestMapping(value="/employeeNew", method = RequestMethod.GET)
	 * 
	 * public String showNewEmployeePage(ModelMap model){ userId =
	 * userSession.getUserId(); if(userId > 0) { empName =
	 * userSession.getFirstName(); empName =
	 * empName.concat(" "+userSession.getLastName()); userType =
	 * userSession.getUserType(); designation = userSession.getDesignation();
	 * model.put("name", empName); model.put("userType", userType);
	 * model.put("designation", designation); return "employeeNew";
	 * 
	 * } model.put("errorMessage", "Session expired. Login Now!!"); return "login";
	 * 
	 * }
	 * 
	 */ // -----------------------------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password) {

		boolean isValidUser = loginService.loginUserService(name, password);
		if (isValidUser == false) {
			model.put("errorMessage", "Invalid Credentials!!");
			return "login";
		}
		empName = userSession.getFirstName();
		empName = empName.concat(" " + userSession.getLastName());
		userType = userSession.getUserType();
		designation = userSession.getDesignation();
		model.put("name", empName);
		model.put("userType", userType);
		model.put("designation", designation);

		return "adminHome";
	}

//------------------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/login", method = RequestMethod.GET)

	public String showLoginPage(ModelMap model) {

		return "login";

	}
//--------------------------------------------------------------------------------------------------------------------------

	@RequestMapping(value = "/NewEmployee", method = RequestMethod.GET)
	public String NewEmployee(Model model) {
		LOGGER.info("NewEmployee");
		return "NewEmployee";
	}

//---------------------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/vendorPurchase", method = RequestMethod.GET)
	public String vendorPurchase(Model model) {
		LOGGER.info("vendorPurchase");
		return "vendorPurchase";
	}
//----------------------------------------------------------------------------------------------------------------------------			

}
