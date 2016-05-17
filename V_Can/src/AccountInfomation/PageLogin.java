package AccountInfomation;

import org.openqa.selenium.By;

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
	
	public void forgetPassWord() throws InterruptedException{
		vcan.clickById("com.sht.smartcommunity:id/txt_forgetpwd");
		vcan.clickById("com.sht.smartcommunity:id/btn_getcode");
		vcan.InputPassWord("com.sht.smartcommunity:id/edtTxt_pwd");
		vcan.clickById("");
		Thread.sleep(8000);
		vcan.NSLog("短信验证码输好了吗");
		Thread.sleep(8000);
		vcan.NSLog("赶紧输入短信验证码");	
		vcan.clickById("com.sht.smartcommunity:id/btn_sure");
		vcan.NSLog("点击了提交按钮~");
	}
	
	//登录操作
	public void LoginAction() throws InterruptedException{
		//登录失败->找回密码
		InputName();
		vcan.InputNewPayPassWord("edtTxt_pwd");
		Thread.sleep(800);
		PressConfirm();
		
		forgetPassWord();
		
		InputName();
		InputPassWord();
		Thread.sleep(800);
		PressConfirm();
		
	}
}
