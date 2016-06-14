package Tools;

import V_Can.V_Can;

public class PageNavigation {

	private V_Can vcan;
	
	public PageNavigation(V_Can vcan){
		this.vcan = vcan;
	}
	
	public void goToHomeTab(){
		vcan.clickById("com.sht.smartcommunity:id/llayout_homepage");
		vcan.waitForLoading();
//		vcan.clickByText("新城势");
	}
	
	public void goToHappyTab(){
		vcan.clickById("com.sht.smartcommunity:id/rlayout_message");
		vcan.waitForLoading();
//		vcan.clickByText("乐生活");
	}
	
	public void goToExploreTab(){
		vcan.clickById("com.sht.smartcommunity:id/llayout_neighbor");
		vcan.waitForLoading();
//		vcan.clickByText("发现");
	}
}
