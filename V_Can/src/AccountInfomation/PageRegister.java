/*
 * 注册类
 * */
package AccountInfomation;

import java.sql.Date;
import java.text.SimpleDateFormat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import V_Can.V_Can;

public class PageRegister {

	V_Can vcan;
	public PageRegister(V_Can vcan){
		this.vcan = vcan;
	}
	
	public void gotoRegister(){
		vcan.clickById("com.sht.smartcommunity:id/title_btn_right");
	}
	
	public void InputPhoneNum(){
		vcan.clickByIdAndInput("com.sht.smartcommunity:id/edtTxt_phone", "18911192276");
	}
	
	public void InputPassword(){
		vcan.InputPassWord("com.sht.smartcommunity:id/edtTxt_pwd");
//		vcan.clickByIdAndInput("com.sht.smartcommunity:id/edtTxt_pwd", "qq123456");
	}
	
	public void clickSendMessageBtn() throws InterruptedException{
		vcan.clickById("com.sht.smartcommunity:id/btn_getcode");
		Thread.sleep(3000);
	}
	
	public void InputVerificationCode() throws InterruptedException{
		Thread.sleep(3000);
		System.out.println("我在等验证码");
		Thread.sleep(5000);
		System.out.println("我在等验证码");
		Thread.sleep(5000);
		System.out.println("我在等验证码");
		Thread.sleep(5000);
		System.out.println("我在等验证码");
		Thread.sleep(5000);
		System.out.println("我在等验证码");
		Thread.sleep(5000);
		System.out.println("我在等验证码");
		/*
		 * 获取短信验证码
		 * */
		vcan.clickById("com.sht.smartcommunity:id/edtTxt_code");
//		vcan.clickByIdAndInput("com.sht.smartcommunity:id/edtTxt_code", "4723");
		Thread.sleep(5000);
	}
	
	public void onReceive(Intent intent) {  
        Bundle bundle = intent.getExtras();  
        SmsMessage msg = null;  
        if (null != bundle) {  
            Object[] smsObj = (Object[]) bundle.get("pdus");  
            for (Object object : smsObj) {  
                msg = SmsMessage.createFromPdu((byte[]) object);  
            Date date = new Date(msg.getTimestampMillis());  
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
                @SuppressWarnings("unused")
				String receiveTime = format.format(date);  
                System.out.println("number:" + msg.getOriginatingAddress()  
                + "   body:" + msg.getDisplayMessageBody() + "  time:"  
                        + msg.getTimestampMillis());  
                if (msg.getOriginatingAddress().equals("10086")) {          
                }   
            }
        }
    }
	
	public void VisitAgreement() throws InterruptedException{
		vcan.clickById("com.sht.smartcommunity:id/txt_protocol");
		Thread.sleep(5000);
		vcan.clickById("com.sht.smartcommunity:id/title_btn_left");
		Thread.sleep(5000);
	}
	
	public void clickConfirmBtn(){
		vcan.clickById("com.sht.smartcommunity:id/btn_sure");
	}
	
	//注册操作
	public void DoRegister() throws InterruptedException{
		gotoRegister();
		InputPhoneNum();
		InputPassword();
		clickSendMessageBtn();
		InputVerificationCode();
		VisitAgreement();
		clickConfirmBtn();
	}
}
