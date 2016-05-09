/*
 * 登录与进入个人中心
 * */
package AccountInfomation;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import V_Can.VBase;
import V_Can.V_Can;

public class PageMyInfo {

	V_Can vcan;
	VBase vbase;
	
	public PageMyInfo(V_Can vcan){
		this.vcan = vcan; 
	}
	
	public void getLoginImageView(){
		vcan.findById("title_btn_left").click();
	}
	
	public void clickLoginImageView(){
		vcan.findById("txt_name").click();
	}
	
	//进入登录页面/个人中心
	public void LoginPage(){
		vcan.clickById("btn_dialog_cancel");
		getLoginImageView();
		clickLoginImageView();
	}
	
	//注销
	public void LogOutAction() throws IOException{
		vcan.clickById("com.sht.smartcommunity:id/btn_exit");
		BackHomeView();
	}
	
	//回到主界面
	public void BackHomeView() throws IOException{ 
		vbase = new VBase();
		vbase.waitForElementById(vcan.driver, "com.sht.smartcommunity:id/txt_name");
		vcan.tapThePoint(750,500);
	}
	
	/*
	 * 
	 * 侧边栏一级入口
	 * 
	 * */
	//我的新城势卡
	public void gotoNewCityCard(){
		vcan.clickByText("我的新城势卡");
		vcan.clickByIdAndInput("com.sht.smartcommunity:id/et_shtCardNumber", "新城势卡卡号");
		vcan.clickById("com.sht.smartcommunity:id/btn_nextStep");  //下一步
		//非我方卡，不支持此交易
		//您绑定的新城势卡未开通
		vcan.back();
	}
	
	//我的银行卡
	public void gotoMyCard(){
		vcan.clickByText("我的银行卡");
		vcan.back();
	}
	
	//交易密码
	public void gotoPayPassword() throws InterruptedException{
		vcan.clickByText("交易密码");
		
		PageDealPassword dealpwd = new PageDealPassword(vcan);
		if(vcan.IdIsExist("com.sht.smartcommunity:id/initialize_name_et")){
			// 首次设置交易密码，输入各证件信息   设置交易密码成功
			dealpwd.setPwd();
		}else if(vcan.IdIsExist("com.sht.smartcommunity:id/finddealpassword_txt")){
			// 第二次及之后，为修改交易密码 先重置，再忘记，
			dealpwd.resetPwd();
		}else{
			//什么都没显示时，直接退出，也有可能是未登录
			vcan.back();
		}
	}
	
	//我的订单
	public void gotoMyOrder(){
		vcan.clickByText("我的订单");
		PageMyOrder myOrder = new PageMyOrder(vcan);
		myOrder.viewAllOrderAction();
		vcan.back();
	}
	
	//客服热线
	public void gotoCall(){
		vcan.clickByText("客服热线");
		vcan.clickById("android:id/button1");
	}
	
	//版本更新
	public void gotoUpdate(){
		vcan.clickByText("版本更新");
		vcan.clickById("com.sht.smartcommunity:id/btn_dialog_cancel");
	}
	
	//关于
	public void gotoAbout(){
		vcan.clickByText("关于");
		vcan.back();
	}
}
