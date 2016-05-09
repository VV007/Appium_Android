package AccountInfomation;

import V_Can.V_Can;

public class PageMyOrder {

	V_Can vcan;
	public PageMyOrder(V_Can vcan){
		this.vcan = vcan;
	}
	
	public void viewAllOrderAction(){
		viewAllFoodsOrder();
		viewAllMoviesOrder();
	}
	
	/*
	 * 商品订单
	 * */
	public void goodsOrder(){
		vcan.clickById("com.sht.smartcommunity:id/tv_myorder");
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
	}

	/*
	 * 电影票订单
	 * */
	public void movieOrder(){
		vcan.clickById("com.sht.smartcommunity:id/tv_movieorder");
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
	}
}
