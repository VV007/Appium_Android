package PageHappy;

import V_Can.V_Can;

public class PageHappyLife {

	V_Can vcan;
	public PageHappyLife(V_Can vcan){
		this.vcan = vcan;
	}
	
	public void visitHappyLife() throws InterruptedException{
		viewMap();
		allKinds();
		selectDistance();
		selectPrice();
		clickCommodity();
		clickPreferential();
		clickPFCommodity();
	}
	
	public void viewMap() throws InterruptedException{
		vcan.clickById("com.sht.smartcommunity:id/title_btn_left");
		Thread.sleep(800);
		vcan.back();
	}
	
	//横向菜单栏
	public void allKinds(){
		vcan.clickById("com.sht.smartcommunity:id/business_circle_homepage_allclass_tv");
		vcan.clickById("com.sht.smartcommunity:id/business_circle_homepage_allclass_tv");
	}
	
	public void selectDistance(){
		vcan.clickById("com.sht.smartcommunity:id/business_circle_homepage_distance_tv");
		vcan.clickById("com.sht.smartcommunity:id/business_circle_homepage_distance_tv");
	}
	
	public void selectPrice(){
		vcan.clickById("com.sht.smartcommunity:id/business_circle_homepage_near_tv");
		vcan.clickById("com.sht.smartcommunity:id/business_circle_homepage_near_tv");
	}
	
	//点击商品
	public void clickCommodity(){
		if(vcan.ClassIsExist("android.widget.RelativeLayout")){
			vcan.clickByClassAndIndx("android.widget.RelativeLayout", 0);
			vcan.back();
		}
	}
	
	//点击特惠
	public void clickPreferential(){
		vcan.clickById("com.sht.smartcommunity:id/title_text_right");
	}
	
	public void clickPFCommodity() throws InterruptedException{
		
		if(vcan.ClassIsExist("android.widget.RelativeLayout")){
			vcan.clickByClassAndIndx("android.widget.RelativeLayout", 0);
			//打电话
			vcan.clickById("com.sht.smartcommunity:id/commertial_tel");
			vcan.clickById("com.sht.smartcommunity:id/btn_dialog_cancel");
			
			//加二减一
			vcan.clickById("com.sht.smartcommunity:id/online_list_item_add_tv");
			vcan.clickById("com.sht.smartcommunity:id/online_list_item_add_tv");
			vcan.clickById("com.sht.smartcommunity:id/online_list_item_remove");
			//确定
			vcan.clickById("com.sht.smartcommunity:id/business_details_list_sure");
			
			vcan.clickById("com.sht.smartcommunity:id/item_preferential_order_makesure_expandable_child_remove");
			vcan.clickById("com.sht.smartcommunity:id/item_preferential_order_makesure_expandable_child_add_tv");
			
			//确定
			vcan.clickById("com.sht.smartcommunity:id/preferential_order_makesure_sure_button");
			vcan.waitForLoading();
			
			//已绑定的卡
			if(vcan.IdIsExist("com.sht.smartcommunity:id/layout")){
				vcan.clickById("com.sht.smartcommunity:id/layout");
				vcan.waitForLoading();
				
				//取消
//				vcan.clickById("com.sht.smartcommunity:id/dialog_order_preferential_cancle");
				
				clickPayButton();
				vcan.back();
				vcan.back();
				
				backToHome();
			}else if(vcan.IdIsExist("com.sht.smartcommunity:id/business_choose_bank_card_sure")){
				//新绑卡
				vcan.clickById("com.sht.smartcommunity:id/business_choose_bank_card_sure");
				
				vcan.clickByIdAndInput("com.sht.smartcommunity:id/business_add_bank_card_bankcard_et", "6226620203905401");
				vcan.clickById("com.sht.smartcommunity:id/txt_protocol");
				vcan.back();
				
				vcan.clickById("com.sht.smartcommunity:id/business_add_bank_card_bankcard_step");
				vcan.waitForLoading();
				
				//输入姓名
				vcan.clickById("com.sht.smartcommunity:id/business_bankcard_info_username_et");
				Thread.sleep(1000);
				vcan.NSLog("等待输入姓名呐");
				Thread.sleep(3000);
				vcan.NSLog("嗯呐，赶紧输入");
				Thread.sleep(4000);
				vcan.clickByIdAndInput("com.sht.smartcommunity:id/business_bankcard_info_usercard_et", "42058119920325003X");
				vcan.clickByIdAndInput("com.sht.smartcommunity:id/business_bankcard_info_tel_et", "18911192276");
				vcan.clickById("com.sht.smartcommunity:id/business_bankcard_info_ture_bt");
				vcan.waitForLoading();
				
				clickPayButton();
				backToHome();
				
			}else{
				backToHome();
			}
		}
	}
	
	//确定支付
	public void clickPayButton(){
		vcan.clickById("com.sht.smartcommunity:id/dialog_order_preferential_payment");
		//输入验证码
		vcan.clickById("com.sht.smartcommunity:id/business_order_payment_valitity_et");
		vcan.SuccessInputVerification("com.sht.smartcommunity:id/business_order_payment_valitity_et", 6, 120);
		vcan.clickById("com.sht.smartcommunity:id/business_order_payment_step_bt");
		vcan.waitForLoading();
		
		//支付成功,查看我的订单
		vcan.clickById("com.sht.smartcommunity:id/order_success_jump_bt");
		vcan.back();
	}
	
	//递归调用返回至主页
	public void backToHome(){
		if(!vcan.IdIsExist("com.sht.smartcommunity:id/title_btn_left")){
			vcan.back();
			backToHome();
		}
	}
}
