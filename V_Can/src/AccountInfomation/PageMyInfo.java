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
	
	//title_btn_left
	public void getLoginImageView(){
		vcan.clickById("com.sht.smartcommunity:id/profile_image");
	}
	
	//txt_name
	public void clickLoginImageView(){
		vcan.clickById("com.sht.smartcommunity:id/imageView_photo");
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
	public void gotoNewCityCard() throws InterruptedException{
		vcan.clickByText("我的新城势卡");
		PageNewCityCards newCityCards = new PageNewCityCards(vcan);
		newCityCards.viewAllInfo();
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
	
	//我的优惠券
	public void gotoMyCoupons(){
		vcan.clickByText("我的优惠券");
//		PageMyCoupons myCoupons = new PageMyCoupons(vcan);
//		myCoupons.viewAllOrderAction();
		vcan.back();
	}
	
	//会员积分
	public void gotoMemberPoints(){
		vcan.clickByText("会员积分");
		PageMemberPoints memberpoints = new PageMemberPoints(vcan);
		memberpoints.viewMyPoints();
		vcan.back();
	}
	
	//客服热线
	public void gotoCall(){
		vcan.clickByText("客服热线");
		//com.sht.smartcommunity:id/btn_dialog_cancel
		vcan.clickById("com.sht.smartcommunity:id/btn_dialog_cancel");
	}
	
	//版本更新
	public void gotoUpdate(){
		vcan.clickByText("版本更新");
		//com.sht.smartcommunity:id/btn_dialog_cancel
		vcan.clickById("android:id/button1");
	}
	
	//关于
	public void gotoAbout(){
		vcan.clickByText("关于我们");
		vcan.back();
	}
}
