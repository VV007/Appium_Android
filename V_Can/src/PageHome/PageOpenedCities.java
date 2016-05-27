package PageHome;

import V_Can.V_Can;

public class PageOpenedCities {

	V_Can vcan;
	
	public PageOpenedCities(V_Can vcan){
		this.vcan = vcan;
	}
	
	public void SelectCityByName(String cityName){
		vcan.clickByText(cityName);
//		vcan.back();
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
//		vcan.tapThePoint(vcan.Screen_Width()/6, 200);
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
	
	//社区服务
	public void gotoCommunityService(){
		vcan.clickByText("社区服务");
		vcan.back();
	}
	
	//生活缴费
	public void gotoLivingPayment(){
		vcan.clickByText("生活缴费");		
	}
	
	//生活周边
	
	
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
