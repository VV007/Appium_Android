package PageHome;

import java.util.List;

import org.openqa.selenium.By;

import V_Can.VBase;
import V_Can.V_Can;

public class PageHome {

	V_Can vcan;
	public PageHome(V_Can vcan){
		this.vcan = vcan;
	}
	
	public void upDateSoftware(){
		
	}
	
	public void waitForPageLoad(){
		VBase.waitForElementById(vcan.getDriver(), "id");
	}
	
	
	/*
	 * ******首页个功能入口******
	 * */
	
	//扫描二维码
	public void gotoScanQRCode(){
		vcan.clickById("com.sht.smartcommunity:id/title_btn_right");
	}
	
	//小马金融
	public void gotoPonyFinance(){
		vcan.clickByText("小马金融");
	}
	
	//电影票
	public void gotoMovieTicket(){
		//取消更新
		vcan.clickById("btn_dialog_cancel");
		vcan.clickByText("电影票");
	}
	
	//健康互联
	public void gotoHealthyInternet(){
		vcan.clickByText("健康互联");		
	}
	
	//教育
	public void gotoEducation(){
		vcan.clickByText("教育");		
	}
		
	//话费充值
	public void gotoRecharge(){
		vcan.clickByText("话费充值");		
	}
		
	//选择城市
	public void gotoSelectCity(){
		vcan.clickById("btn_dialog_cancel");
		vcan.clickById("com.sht.smartcommunity:id/title_text");
		//vcan.clickByText("—选择城市—");		
	}
		
	//社区服务
	public void gotocommunityService(){
		vcan.clickByText("社区服务");		
	}
		
	//生活缴费
	public void gotoLivingPayment(){
		vcan.clickByText("生活缴费");		
	}
		
	//乐生活
	public void gotoHappyLife(){
		vcan.clickByText("乐生活");		
	}
		
	//银行服务
	public void gotoBankingServices(){
		vcan.clickByText("银行服务");		
	}
	
	//更多
	public void gotoMore(){
					
	}
	
}
