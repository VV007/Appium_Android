package Tools;

import android.graphics.pdf.PdfDocument.PageInfo;
import AccountInfomation.PageLogin;
import AccountInfomation.PageMyInfo;
import AccountInfomation.PageRegister;
import AccountInfomation.PageResetPassword;
import PageExplore.PageExplore;
import PageHappy.PageHappyLife;
import PageHome.PageHome;
import PageHome.PageMovies;
import PageHome.PageOpenedCities;
import V_Can.V_Can;

public class PageManager {

	private V_Can vcan;
	PageNavigation pageNavigation;
	PageMyInfo pageMyInfo;
	PageLogin pageLogin;
	PageRegister pageRegister;
	PageResetPassword pageResetPassword;
	PageHappyLife pageHappyLife;
	PageExplore pageExplore;
	PageHome pageHome;
	PageOpenedCities pageOpenedCities;
	PageMovies pageMovies;
	
	public PageManager(V_Can vcan){
		this.vcan = vcan;
	}
	
	public PageNavigation getPageNavigation(){
		if(pageNavigation == null){
			pageNavigation = new PageNavigation(vcan);
		}
		return pageNavigation;
	}	
	
	public PageMyInfo getPageMyInfo(){
		if(pageMyInfo == null){
			pageMyInfo = new PageMyInfo(vcan);
		}
		return pageMyInfo;
	}
	
	public PageLogin getPageLogin(){
		if(pageLogin == null){
			pageLogin = new PageLogin(vcan);
		}
		return pageLogin;
	}
	
	public PageRegister getPageRegister(){
		if(pageRegister == null){
			pageRegister = new PageRegister(vcan);
		}
		return pageRegister;
	}
	
	public PageResetPassword getPageResetPassword(){
		if(pageResetPassword == null){
			pageResetPassword = new PageResetPassword(vcan);
		}
		return pageResetPassword;
	}
	
	public PageHappyLife getPageHappyLife(){
		if(pageHappyLife == null){
			pageHappyLife = new PageHappyLife(vcan);
		}
		return pageHappyLife;
	}
	
	public PageExplore getPageExplore(){
		if(pageExplore == null){
			pageExplore = new PageExplore(vcan);
		}
		return pageExplore;
	}
	
	public PageHome getPageHome(){
		if(pageHome == null){
			pageHome = new PageHome(vcan);
		}
		return pageHome;
	}
	
	public PageOpenedCities getPageOpenedCities(){
		if(pageOpenedCities == null){
			pageOpenedCities = new PageOpenedCities(vcan);
		}
		return pageOpenedCities;
	}
	
	public PageMovies getPageMovies(){
		if(pageMovies == null){
			pageMovies = new PageMovies(vcan);
		}
		return pageMovies;
	}
	
}