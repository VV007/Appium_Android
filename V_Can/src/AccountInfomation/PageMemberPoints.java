package AccountInfomation;

import V_Can.V_Can;

public class PageMemberPoints {

	V_Can vcan;
	public PageMemberPoints(V_Can vcan) {
		this.vcan = vcan;
	}
	
	public void pointsRule(){
		vcan.clickById("com.sht.smartcommunity:id/credit_rules_tv");
		vcan.back();
	}
	
	public void viewNewCityCards(){
		
		if(vcan.IdIsExist("com.sht.smartcommunity:id/credit_look_btn")){
			vcan.clickById("com.sht.smartcommunity:id/credit_look_btn");
			vcan.cancel();
		}else{
			//进去看卡详情
		}
		vcan.back();
	}
	
	public void viewMyPoints(){
		pointsRule();
		viewNewCityCards();
	}
}
