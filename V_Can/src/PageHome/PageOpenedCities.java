package PageHome;

import V_Can.V_Can;

public class PageOpenedCities {

	V_Can vcan;
	
	public PageOpenedCities(V_Can vcan){
		this.vcan = vcan;
	}
	
	public void SelectCityByName(){
		vcan.clickByText("北京市");
	}
}
