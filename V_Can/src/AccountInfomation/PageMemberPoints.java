package AccountInfomation;

import V_Can.V_Can;

public class PageMemberPoints {

	V_Can vcan;
	public PageMemberPoints(V_Can vcan) {
		this.vcan = vcan;
	}
	
	public void pointsRule(){
		vcan.clickById("com.sht.smartcommunity:id/ll_credit_rule");
		vcan.back();
	}
	
	public void viewNewCityCards(){
		vcan.clickById("com.sht.smartcommunity:id/rl_credit_animateLayout");
		
//		if(vcan.IdIsExist("com.sht.smartcommunity:id/credit_look_btn")){
//			vcan.clickById("com.sht.smartcommunity:id/credit_look_btn");
//			vcan.cancel();
//		}else{
			//进去看卡详情
//		}
		
	}
	
	public void viewMyPoints(){
		pointsRule();
		viewNewCityCards();
		pointsRule();
		vcan.back();
	}
}
