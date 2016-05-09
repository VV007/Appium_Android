package PageHome;

import V_Can.VBase;
import V_Can.V_Can;

public class PageMovies {

	V_Can vcan;
	VBase vbase;
	
	public PageMovies(V_Can vcan) {
		this.vcan = vcan;
	}
	
	public void ConfirmSelectCity(){
		vcan.clickById("com.sht.smartcommunity:id/btn_dialog_ok");
	}
	
	public void SelectCity(){
		vcan.clickByText("北京");
	}
	
	public void SelectMovie() throws InterruptedException{
		ConfirmSelectCity();
		SelectCity();
		
		
//		vcan.swipe(440, 330, 250, 330);

		
//		vcan.tapThePoint(855, 333);
//		vcan.clickById("com.sht.smartcommunity:id/movid_detail_layout");
//		Thread.sleep(800);
//		vcan.clickById("com.sht.smartcommunity:id/title_btn_left");
//		vcan.clickByText("佳合时光影城");
//		Thread.sleep(800);
//		vcan.clickByText("选座购票");
//		vcan.tapThePoint(311, 475);
//		vcan.clickById("com.sht.smartcommunity:id/tv_order");
		
		vcan.clickById("com.sht.smartcommunity:id/title_btn_left");
		
		
		/*
		 * 接下来选择影片信息与座位
		 * */
	}
	
	
}
