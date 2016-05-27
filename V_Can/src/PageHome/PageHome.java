package PageHome;

import java.util.List;

import org.openqa.selenium.By;

import V_Can.VBase;
import V_Can.V_Can;

public class PageHome extends PageOpenedCities{

	V_Can vcan;
	public PageHome(V_Can vcan){
		super(vcan);
		this.vcan = vcan;
	}
	
	//扫描二维码
	public void gotoScanQRCode(){
		vcan.clickById("com.sht.smartcommunity:id/title_btn_right");
	}
	
	//选择城市
	public void gotoSelectCity(String cityName){
//		vcan.clickByText("—选择城市—")
		vcan.clickById("btn_dialog_cancel");
		vcan.clickById("com.sht.smartcommunity:id/title_text");
		SelectCityByName(cityName);
		differentCityAction(cityName);
	}
	
	public void differentCityAction(String cityName){
		if(cityName == "北京市"){
			cityBeijing();
		}else if(cityName == "包头市"){
			cityBeijing();
		}else if(cityName == "吕梁市"){
			cityBeijing();
		}else if(cityName == "xx市"){
			cityBeijing();
		}else if(cityName == "xx市"){
			cityBeijing();
		}else if(cityName == "xx市"){
			cityBeijing();
		}
	}
	
	public void cityBeijing(){
		gotoGovernmentInfo();
		gotoServiceGuide();
		gotoCommunityService();
		/*
		 * 健康互联
		 * 人人保险
		 * 展恒基金测试
		 * 生活周边
		 * 电影票
		 * */
		gotoMovieTicket();
	}
	
	public void cityBaotou(){
		
	}
	
	public void cityLvliang(){
		
	}
	
	public void upDateSoftware(){
		
	}
	
	public void waitForPageLoad(){
		VBase.waitForElementById(vcan.getDriver(), "id");
	}
	
	
	
	
}
