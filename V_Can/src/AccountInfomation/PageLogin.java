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
		vcan.clickById("com.sht.smartcommunity:id/edtTxt_code");
		Thread.sleep(8000);
		vcan.NSLog("短信验证码输好了吗");
		Thread.sleep(8000);
		vcan.NSLog("赶紧输入短信验证码");	
		vcan.clickById("com.sht.smartcommunity:id/btn_sure");
		vcan.NSLog("点击了提交按钮~");
	}
	
	//登录操作
	public void LoginAction() throws InterruptedException{
		/**
		 * 判断是否登录，如果未登录，则进入登录流程，如果已经登录，则返回
		 * */
		if(vcan.iSLogin.equals("No") && (!vcan.IdIsExist("com.sht.smartcommunity:id/btn_exit"))){
			//登录操作
			//登录失败->找回密码
			/*
			InputName();
			vcan.InputNewPayPassWord("edtTxt_pwd");
			Thread.sleep(800);
			PressConfirm();
			
			forgetPassWord();
			*/
			
			InputName();
			InputPassWord();
			Thread.sleep(800);
			PressConfirm();
		}else{
			//进入个人中心
			vcan.back();
		}
		vcan.iSLogin = "Yes";
	}
	
	public void editMyInfo() throws InterruptedException{
		vcan.clickById("com.sht.smartcommunity:id/llayout_photo");//点击选择头像
		vcan.clickById("com.sht.smartcommunity:id/btn_women");//从手机相册选取
		
		vcan.tapThePoint(vcan.Screen_Width()/2, vcan.Screen_Height()/2);//点击正中选相册
		vcan.NSLog("选择完相册");
		
		vcan.NSLog("选择完相册");
		
		Thread.sleep(2000);
		vcan.tapThePoint(vcan.Screen_Width()/2, vcan.Screen_Height()/2);//正中的照片
		vcan.NSLog("选择完相片");
		vcan.clickById("com.android.gallery3d:id/filtershow_done");//确认保存
		vcan.clickById("com.sht.smartcommunity:id/imageView_photo");//点击预览头像
		vcan.tapThePoint(10, vcan.Screen_Height()/10);//收起背景
		
		vcan.clickById("com.sht.smartcommunity:id/llayout_neckname");//修改昵称
		vcan.clickByIdAndInput("com.sht.smartcommunity:id/edt_name", "VV");
		vcan.clickById("com.sht.smartcommunity:id/title_btn_right");
		
		vcan.clickById("com.sht.smartcommunity:id/llayout_sex");//选择性别
		vcan.clickById("com.sht.smartcommunity:id/btn_man");
		
		vcan.clickById("com.sht.smartcommunity:id/llayout_sign");//签名
		vcan.clickByIdAndInput("com.sht.smartcommunity:id/edtText_sign", "I'm just here waiting for you ~");
		vcan.clickById("com.sht.smartcommunity:id/title_btn_right");
		
		vcan.clickById("com.sht.smartcommunity:id/llayout_address");//我的收获地址
		vcan.clickById("com.sht.smartcommunity:id/btn_add_new_address");
		vcan.clickByIdAndInput("com.sht.smartcommunity:id/et_name", "VCan");//收货人
		vcan.clickByIdAndInput("com.sht.smartcommunity:id/et_phone", "18948572849");
		vcan.clickByIdAndInput("com.sht.smartcommunity:id/et_postcode", "443300");
		vcan.clickById("com.sht.smartcommunity:id/tv_province_city");
		vcan.clickById("com.sht.smartcommunity:id/btn_confirm");
		vcan.clickByIdAndInput("com.sht.smartcommunity:id/et_detail_address", "Beijing province Sunshine street Happy building 520 room");
		vcan.clickById("com.sht.smartcommunity:id/saveaddress_btn");
		vcan.back();
		reSetPassword();
		
	}
	
	public void reSetPassword() throws InterruptedException{
		vcan.clickById("com.sht.smartcommunity:id/llayout_resetpwd");
		vcan.clickById("com.sht.smartcommunity:id/btn_getcode");
		vcan.clickById("com.sht.smartcommunity:id/btn_getcode");
		vcan.InputPassWord("com.sht.smartcommunity:id/edtTxt_pwd");
		vcan.clickById("com.sht.smartcommunity:id/edtTxt_code");
		Thread.sleep(8000);
		vcan.NSLog("短信验证码输好了吗");
		Thread.sleep(8000);
		vcan.NSLog("赶紧输入短信验证码");	
		vcan.clickById("com.sht.smartcommunity:id/btn_sure");
		vcan.NSLog("点击了提交按钮~");
		
		vcan.back();
		vcan.back();
	}
}
