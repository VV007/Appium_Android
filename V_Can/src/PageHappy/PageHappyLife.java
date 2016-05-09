package PageHappy;

import V_Can.V_Can;

public class PageHappyLife {

	V_Can vcan;
	public PageHappyLife(V_Can vcan){
		this.vcan = vcan;
	}
	
	public void clickShopItem(int index){
		vcan.clickByIdAndIndx("id", index);
	}
}
