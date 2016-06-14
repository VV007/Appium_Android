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
	public void gotoSelectCity(String cityName) throws InterruptedException{
//		vcan.clickByText("—选择城市—")
		vcan.clickById("btn_dialog_cancel");
		vcan.clickById("com.sht.smartcommunity:id/title_text");
		SelectCityByName(cityName);
		differentCityAction(cityName);
	}
	
	public void differentCityAction(String cityName) throws InterruptedException{
		if(cityName == "北京市"){
			cityBeijing();
		}else if(cityName == "包头市"){
			cityBaotou();
		}else if(cityName == "吕梁市"){
			cityLvliang();
		}else if(cityName == "xx市"){
			;
		}else if(cityName == "xx市"){
			;
		}else if(cityName == "xx市"){
			;
		}
	}
	
	public void cityBeijing() throws InterruptedException{
		gotoGovernmentInfo();
		gotoServiceGuide();
		gotoCommunityService();
		gotoHealthyInternet();
		gotoPersonInsurance();
		ZhanhengFundTest();
		gotoLifeSurrounding();
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
