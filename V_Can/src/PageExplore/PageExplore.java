package PageExplore;

import V_Can.V_Can;

public class PageExplore {

	V_Can vcan;
	
	public PageExplore(V_Can vcan){
		this.vcan = vcan;
	}
	
	public void clickFoodItem(int index){
		vcan.clickByIdAndIndx("com.sht.smartcommunity:id/online_list_item_iv", index);
	}
	
	public void phoneCall(){
		vcan.clickById("com.sht.smartcommunity:id/commertial_tel");
		vcan.clickById("com.sht.smartcommunity:id/btn_dialog_cancel");
	}
	
	public void addOrDelete(){
		vcan.clickById("com.sht.smartcommunity:id/online_list_item_add_tv");
		vcan.clickById("com.sht.smartcommunity:id/online_list_item_remove");
	}
	
	public void addOrDeleteConfirm(){
		vcan.clickById("com.sht.smartcommunity:id/item_preferential_order_makesure_expandable_child_add_tv");
		vcan.clickById("com.sht.smartcommunity:id/item_preferential_order_makesure_expandable_child_remove");
	}
	
	public void confirm(){
		vcan.clickById("com.sht.smartcommunity:id/business_details_list_sure");
	}
	
	public void confirmOrder(){
		vcan.clickById("com.sht.smartcommunity:id/preferential_order_makesure_sure_button");
	}
}
