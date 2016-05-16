package AccountInfomation;

import V_Can.V_Can;

public class PageDealPassword {

	V_Can vcan;
	public PageDealPassword(V_Can vcan){
		this.vcan = vcan;
	}
	
	//首次设置交易密码
	public void setPwd() throws InterruptedException{
		vcan.clickById("com.sht.smartcommunity:id/initialize_getvalitity_tv");//获取验证码
		vcan.clickById("com.sht.smartcommunity:id/initialize_name_et"); //证件名
		Thread.sleep(6000);
		vcan.clickByIdAndInput("com.sht.smartcommunity:id/initialize_card_et", "131122198710010247");
		vcan.InputPayPassWord("com.sht.smartcommunity:id/edtTxt_pwd");//首次密码
		vcan.InputPayPassWord("com.sht.smartcommunity:id/edtTxt_pwd_sure");//确认首次密码
		vcan.clickById("com.sht.smartcommunity:id/initialize_valitity_et");//输入验证码
		Thread.sleep(9000);
		vcan.clickById("com.sht.smartcommunity:id/initialize_sure");//确认
		
		if(vcan.IdIsExist("com.sht.smartcommunity:id/initialize_sure")){
			vcan.back();
		}
	}
	
	//重置交易密码
	public void resetPwd() throws InterruptedException{
		vcan.clickById("com.sht.smartcommunity:id/updatepasswordgetvalitity_tv");//获取验证码
		
//		vcan.InputPayPassWord("com.sht.smartcommunity:id/edtTxt_pwd_old");
		vcan.InputNewPayPassWord("com.sht.smartcommunity:id/edtTxt_pwd_old");//故意把新码当旧密码输入
		vcan.clickById("com.sht.smartcommunity:id/edtTxt_pwd");
		vcan.InputNewPayPassWord("com.sht.smartcommunity:id/edtTxt_pwd");
		vcan.InputNewPayPassWord("com.sht.smartcommunity:id/edtTxt_pwd_sure");
		vcan.clickById("com.sht.smartcommunity:id/updatepasswordvalitity_et");//输入验证码
		Thread.sleep(9000);
		vcan.clickById("com.sht.smartcommunity:id/updatepassword_sure_btn");//确认  
		//客户端出错，请下载最新版客户端
		//修改交易密码成功！
		
		//密码错误，进入忘记密码流程
		vcan.clickById("com.sht.smartcommunity:id/finddealpassword_txt");//忘记密码
		forgetPwd();
		
	}
	
	//忘记密码
	public void forgetPwd() throws InterruptedException{
		vcan.clickById("com.sht.smartcommunity:id/forget_getvalitity_tv");//获取验证码
		
		//不能输入中文
		vcan.clickByIdAndInput("com.sht.smartcommunity:id/forget_bankcard_name_et", "身份证");
		Thread.sleep(9000);
		vcan.clickByIdAndInput("com.sht.smartcommunity:id/forget_bankcard_et", "131122198710010247");
		vcan.InputNewPayPassWord("com.sht.smartcommunity:id/edtTxt_pwd");//新交易密码
		vcan.clickById("com.sht.smartcommunity:id/edtTxt_pwd_sure");
		vcan.InputNewPayPassWord("com.sht.smartcommunity:id/edtTxt_pwd_sure");//确认新密码
		
		vcan.clickById("com.sht.smartcommunity:id/forget_valitity_et");//输入验证码
		Thread.sleep(9000);
		vcan.clickById("com.sht.smartcommunity:id/updatepassword_sure_btn");//确认   设置交易密码成功
		vcan.back();
		vcan.back();
	}
}
