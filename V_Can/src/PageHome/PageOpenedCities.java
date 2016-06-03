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
	public void gotoMovieTicket(){
		//取消更新
		vcan.clickById("btn_dialog_cancel");
		vcan.clickByText("电影票");
		
		//选择城市弹窗
		if(vcan.IdIsExist("com.sht.smartcommunity:id/btn_dialog_ok")){
			vcan.clickById("com.sht.smartcommunity:id/btn_dialog_ok");
			vcan.clickByText("北京");
		}
		
		vcan.clickById("com.sht.smartcommunity:id/tv_is_hit");
		vcan.clickById("com.sht.smartcommunity:id/tv_on_next");
		vcan.clickById("com.sht.smartcommunity:id/btn_cinema");
		vcan.waitForLoading();
		
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
		}
		
		vcan.back();
	}
	
	//健康互联
	public void gotoHealthyInternet(){
		vcan.clickByText("健康互联");	
		vcan.back();
	}
	
	//人人保险
	public void gotoPersonInsurance(){
		vcan.clickByText("人人保险");	
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
