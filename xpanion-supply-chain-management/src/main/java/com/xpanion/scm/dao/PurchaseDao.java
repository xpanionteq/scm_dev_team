package com.xpanion.scm.dao;

 /* @author:Aswathy raj.D
 * @purpose:Purchase Order  details
 * @date:24-07-2019
 */

import java.util.List;

import com.xpanion.scm.model.PurchaseModel;
import com.xpanion.scm.model.PurchaseProductsModel;


public interface PurchaseDao {
	 public int saveUpdatePurchaseOrder(int purchaseId,int contactId,int warehouseId,int statusId,String expectedDeliveryDate, 
				int createUserId,char activeStatus,List<PurchaseProductsModel> PurchaseProductsmodel);
			
	    
		    	    
		    public List<PurchaseModel> getContactNames();
		    
		    public List<PurchaseModel>  getPurchaseId();
		    
		    public List<PurchaseModel> getProductNames();
		    
		    public List<PurchaseModel> getPurchaseProductDetails( int purchaseId);
		    
		    public List<PurchaseModel> getProductDetails(int purchaseProductDetId);
		
}
