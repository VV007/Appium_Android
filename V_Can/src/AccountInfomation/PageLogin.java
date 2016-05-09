package AccountInfomation;

import V_Can.V_Can;

public class PageLogin {
	
	V_Can vcan;
	
	public PageLogin(V_Can vcan){
		this.vcan = vcan;
	}
	
	public void InputName(){
		vcan.clickByIdAndInput("edtTxt_username", "18911192276");
	}
	
	public void InputPassWord(){
		vcan.InputPassWord("edtTxt_pwd");
	}
	
	public void PressConfirm(){
		vcan.clickById("btn_sure");
	}
	
	//登录操作
	public void LoginAction() throws InterruptedException{
		InputName();
		InputPassWord();
		Thread.sleep(800);
		PressConfirm();
	}
}
