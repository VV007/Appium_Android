package AccountInfomation;

import org.openqa.selenium.WebElement;

import V_Can.V_Can;

public class PageMyOrder {

	V_Can vcan;
	public PageMyOrder(V_Can vcan){
		this.vcan = vcan;
	}
	
	public void viewAllOrderAction(){
		viewAllFoodsOrder();
		viewAllMoviesOrder();
		viewCouponsOrder();
		viewAssuranceOrder();
		
		vcan.back();
	}
	
	/*
	 * 商品订单
	 * */
	public void goodsOrder(){
		vcan.clickById("com.sht.smartcommunity:id/goods_name");
	}
	
	public void allOrders(){
		vcan.clickById("com.sht.smartcommunity:id/myorder_home_tv_all");
	}
	
	public void waitForPay(){
		vcan.clickById("com.sht.smartcommunity:id/myorder_home_tv_forpayment");
	}
	
	public void waitForSend(){
		vcan.clickById("com.sht.smartcommunity:id/myorder_home_tv_sendgoods");
	}
	
	public void alreadySended(){
		vcan.clickById("com.sht.smartcommunity:id/myorder_home_tv_hasshipped");
	}
	
	public void refundOrder(){
		vcan.clickById("com.sht.smartcommunity:id/myorder_home_tv_refund");
	}
	
	public void chooseOneGoodsOrder(){
		if(vcan.IdIsExist("com.sht.smartcommunity:id/item_myorder_home_list_order_id")){
			vcan.NSLog("有订单呢");
			vcan.clickById("com.sht.smartcommunity:id/item_myorder_home_list_order_id");
			double a=0;
			while(vcan.IdIsExist("com.sht.smartcommunity:id/iv_loading")){
				//等待刷新出数据
				a++;
				if(a > 10000){
					vcan.back();
					break;
				}
			}
			vcan.back();
		}else{
			vcan.NSLog("没订单呢");
		}
	}
	
	public void viewAllFoodsOrder(){
    	goodsOrder();   //点击商品订单
    	
    	refundOrder();  //由后至前全走一遍
    	alreadySended();
    	waitForSend();
    	waitForPay();
    	allOrders();
    	
    	chooseOneGoodsOrder();
    	vcan.back();
	}

	/*
	 * 电影票订单
	 * */
	public void movieOrder(){
		vcan.clickById("com.sht.smartcommunity:id/movies_name");
	}
	
	public void allMoivesOrder(){
		vcan.clickById("com.sht.smartcommunity:id/tv_all");
	}
	
	public void noPayment(){
		vcan.clickById("com.sht.smartcommunity:id/tv_non_payment");
	}
	
	public void boughtSuccess(){
		vcan.clickById("com.sht.smartcommunity:id/tv_they_will");
	}
	
	public void boughtFailure(){
		vcan.clickById("com.sht.smartcommunity:id/tv_for_failure");
	}
	
	public void chooseOneMovieOrder(){
		if(vcan.IdIsExist("com.sht.smartcommunity:id/tv_name")){
			vcan.NSLog("有订单呢");
			vcan.clickById("com.sht.smartcommunity:id/tv_name");
			double a=0;
			while(vcan.IdIsExist("com.sht.smartcommunity:id/iv_loading")){
				//等待刷新出数据
				a++;
				if(a > 10000){
					vcan.back();
					break;
				}
			}
			vcan.clickById("com.sht.smartcommunity:id/title_btn_right");
			vcan.back();
		}else{
			vcan.NSLog("没订单呢");
		}
	}
	
	public void viewAllMoviesOrder(){
		movieOrder();
		
		boughtFailure();
		boughtSuccess();
		noPayment();
		allMoivesOrder();
		
		chooseOneMovieOrder();
		
		vcan.back();
	}
	
	/*
	 * 优惠券订单
	 * */
	public void couponsOrder(){
		vcan.clickById("com.sht.smartcommunity:id/conpons_name");
	}
	
	public void unconsumedOrder(){
		vcan.clickById("com.sht.smartcommunity:id/tv_all");
	}
	
	public void noPaymentCoupons(){
		vcan.clickById("com.sht.smartcommunity:id/tv_non_payment");
	}
	
	public void refundCouponsOrder(){
		vcan.clickById("com.sht.smartcommunity:id/tv_they_will");
	}
	
	public void allCouponsOrder(){
		vcan.clickById("com.sht.smartcommunity:id/tv_for_failure");
	}
	
	public void chooseOneCouponsOrder(){
		
	}
	
	public void viewCouponsOrder(){
		couponsOrder();
		
		unconsumedOrder();
		noPaymentCoupons();
		refundCouponsOrder();
		allCouponsOrder();
		
		chooseOneCouponsOrder();
		vcan.back();
	}
	
	/*
	 * 保险
	 * */
	public void assuranceOrder(){
		vcan.clickById("com.sht.smartcommunity:id/insures_name");
//		vcan.clickById("com.sht.smartcommunity:id/finish_view");//直接关闭web
	}
	
	public void firstTimeConfirm(){
		//第一次进入会绑定
		clickSendMessageButton();
	}
	
	public void chooseOneAssuranceOrder(){
		
	}
	
	public void clickSendMessageButton(){
		try{
    		WebElement element = (WebElement) vcan.getDriver().findElementsByClassName("android.view.View").get(1);
    		if(element.isDisplayed()){
    			element.click();  //发送验证码
    			vcan.clickByClassAndIndx("android.widget.Button", 0); //确认验证
    			vcan.clickByIdAndIndx("android.view.View", 0); //未输入验证码确认
    			Thread.sleep(6000);
    			vcan.NSLog("我在等待你输入验证码");
    			Thread.sleep(6000);
    			vcan.NSLog("我在等待你输入验证码");
    			Thread.sleep(6000);
    			vcan.NSLog("我在等待你输入验证码");
    			vcan.clickByClassAndIndx("android.widget.EditText", 0); //激活验证码输入框
    			vcan.clickByClassAndIndx("android.widget.Button", 0); //确认验证
    		}
    	}catch(Exception e){
    		
    	}
	}
	
	public void viewAssuranceOrder(){
		assuranceOrder();
		firstTimeConfirm();
		
		chooseOneAssuranceOrder();
	}
}