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
	
}
