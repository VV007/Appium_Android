package PageHome;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import V_Can.V_Can;

public class PageOpenedCities {

	V_Can vcan;
	
	public PageOpenedCities(V_Can vcan){
		this.vcan = vcan;
	}
	
	public void SelectCityByName(String cityName){
		vcan.clickByText(cityName);
	}
	
	/*
	 * ******所有开通城市的所有功能入口******
	 * */
	
	public void gotoGovernmentInfo(){
		vcan.clickByText("政务信息");
		vcan.back();
	}
	
	public void gotoServiceGuide(){		
		vcan.clickByText("办事指南");
		
//		vcan.tapThePoint(160, 214);
//		vcan.back();
//		vcan.tapThePoint(vcan.Screen_Width()/2, 200);
//		vcan.back();
//		vcan.tapThePoint(vcan.Screen_Width()*5/6, 200);
//		vcan.back();
//		vcan.tapThePoint(vcan.Screen_Width()/6, 400);
//		vcan.back();
//		vcan.tapThePoint(vcan.Screen_Width()/2, 400);
//		vcan.back();
//		vcan.tapThePoint(vcan.Screen_Width()*5/6, 400);
//		vcan.back();
//		vcan.tapThePoint(vcan.Screen_Width()/6, 600);
//		vcan.back();
//		vcan.tapThePoint(vcan.Screen_Width()/2, 600);
//		vcan.back();
//		vcan.tapThePoint(vcan.Screen_Width()*5/6, 600);
//		vcan.back();
		vcan.back();
	}
	
	//小马金融
	public void gotoPonyFinance(){
		vcan.clickByText("小马金融");
		vcan.back();
	}
	
	//电影票 
	public void gotoMovieTicket() throws InterruptedException{
		//取消更新
		vcan.clickById("btn_dialog_cancel");
		vcan.clickByText("电影票");
		
		//选择城市弹窗
		if(vcan.IdIsExist("com.sht.smartcommunity:id/btn_dialog_ok")){
			vcan.clickById("com.sht.smartcommunity:id/btn_dialog_ok");
			vcan.clickByText("北京");
		}
		
		//***热映影片***
		vcan.clickById("com.sht.smartcommunity:id/tv_is_hit");
		vcan.waitForLoading();
		
		if(vcan.IdIsExist("com.sht.smartcommunity:id/ll_all")){
			vcan.clickByIdAndIndx("com.sht.smartcommunity:id/ll_all", 0);
			
			//购买
			vcan.clickById("com.sht.smartcommunity:id/tv_buy");
			vcan.waitForLoading();
			
			//地区、排行、选择买票
			chooseAddressAndSort();
			
			backToSecondPage();
		}
		
		//***即将上映***
		vcan.clickById("com.sht.smartcommunity:id/tv_on_next");
		vcan.waitForLoading();
		
		if(vcan.IdIsExist("com.sht.smartcommunity:id/ll_all")){
			vcan.clickByIdAndIndx("com.sht.smartcommunity:id/ll_all", 0);
			vcan.back();
		}
		
		//***影院***
		vcan.clickById("com.sht.smartcommunity:id/btn_cinema");
		vcan.waitForLoading();
		
		//地区、排序，选择买票
		chooseAddressAndSort();
		
		backToSecondPage();
		vcan.back();
	}
	
	//地区选择，选择进入
	public void chooseAddressAndSort() throws InterruptedException{
		//选择地区
		vcan.clickById("com.sht.smartcommunity:id/tv_address");
		vcan.tapThePoint(123, 234);
		vcan.waitForLoading();
		//选择排序
		vcan.clickById("com.sht.smartcommunity:id/tv_sort");
		vcan.tapThePoint(vcan.Screen_Width()-123, 234);
		vcan.waitForLoading();
		
		if(vcan.ClassIsExist("android.widget.LinearLayout")){
			vcan.clickByClassAndIndx("android.widget.LinearLayout", 0);
			vcan.waitForLoading();
			
			//顶级进入最近将播放电影票务详情页
			if(vcan.ClassIsExist("android.widget.RelativeLayout")){
				vcan.clickByClassAndIndx("android.widget.RelativeLayout", 0);
				
				//随机选个一个座位
				findPlace(60,468);
				
				//已绑定的卡
				if(vcan.IdIsExist("com.sht.smartcommunity:id/layout")){
					vcan.clickById("com.sht.smartcommunity:id/layout");
					vcan.waitForLoading();
					
					//取消
//					vcan.clickById("com.sht.smartcommunity:id/dialog_order_preferential_cancle");
					
					clickPayButton();
					
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
				}
			}
			
			vcan.back();
		}
	}
	
	//递归找个空座位
	public void findPlace(int w,int h){
		if(!vcan.IdIsExist("com.sht.smartcommunity:id/business_choose_bank_card_sure")){
			vcan.tapThePoint(w,h);
			vcan.clickById("com.sht.smartcommunity:id/tv_order");
			vcan.waitForLoading();
			if(w < vcan.Screen_Width()){
				findPlace(w+50,h);
			}else{
				vcan.NSLog("第一排没有空位了");
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
	
	//递归->返回至电影二级界面
	public void backToSecondPage(){
		if(!vcan.IdIsExist("com.sht.smartcommunity:id/tv_is_hit")){
			vcan.back();
			backToSecondPage();
		}
	}
	
	//健康互联
	public void gotoHealthyInternet(){
		vcan.clickByText("健康互联");	
		vcan.back();
	}
	
	//人人保险
	public void gotoPersonInsurance(){
		vcan.clickByText("人人保险");	
		vcan.waitForLoading();
		vcan.back();
	}
	
	//教育
	public void gotoEducation(){
		vcan.clickByText("教育");	
		vcan.back();
	}
		
	//话费充值
	public void gotoRecharge(){
		vcan.clickByText("话费充值");
		vcan.back();
	}
	
	//社区服务
	public void gotoCommunityService(){
		vcan.clickByText("社区服务");
		
		vcan.clickById("com.sht.smartcommunity:id/llayout_trading_query");
		vcan.back();
		
		vcan.clickById("com.sht.smartcommunity:id/llayout_query_pay");
		//可能会有刷新等待
		vcan.waitForLoading();
		vcan.back();
		
		vcan.clickByText("“低价”意味着什么？");
		vcan.waitForLoading();
		vcan.back();
		
		vcan.clickByText("北京雍和宫社区信息测试");
		vcan.waitForLoading();
		vcan.back();
		
		vcan.back();
	}
	
	//生活缴费
	public void gotoLivingPayment(){
		vcan.clickByText("生活缴费");	
		vcan.back();
	}
	
	//生活周边
	public void gotoLifeSurrounding(){
		vcan.clickByText("生活周边");
		vcan.back();
	}
	
	//展恒基金测试
	public void ZhanhengFundTest(){
		vcan.clickByText("展恒基金测试");	
		vcan.back();
	}
	
	//乐生活
	public void gotoHappyLife(){
		vcan.clickByText("乐生活");	
		vcan.back();
	}
		
	//银行服务
	public void gotoBankingServices(){
		vcan.clickByText("银行服务");	
		vcan.back();
	}
	
	//更多
	public void gotoMore(){
		vcan.back();	
	}
}
