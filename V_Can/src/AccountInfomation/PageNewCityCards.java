package AccountInfomation;

import V_Can.V_Can;

public class PageNewCityCards {

	V_Can vcan;
	public PageNewCityCards(V_Can vcan) {
		this.vcan = vcan;
	}
	
	public void firstBindingCard(){
		/*
		 * 如果没卡，则绑定；有卡直接略过
		 * */
		if(vcan.IdIsExist("com.sht.smartcommunity:id/et_shtCardNumber")){
			vcan.clickByIdAndInput("com.sht.smartcommunity:id/et_shtCardNumber", "3358880100000001379");
			vcan.clickById("com.sht.smartcommunity:id/btn_nextStep");  //下一步
			//获取验证码
			vcan.clickById("com.sht.smartcommunity:id/txt_count");
			//点击激活输入框
			vcan.clickById("com.sht.smartcommunity:id/et_shtCardNumber");
			//绑定
			vcan.clickById("com.sht.smartcommunity:id/btn_bindCard");
			//弹窗 需要设置交易密码  取消 确定
			vcan.cancel();
//			vcan.clickById("com.sht.smartcommunity:id/btn_dialog_ok");
				
			//非我方卡，不支持此交易
			//您绑定的新城势卡未开通
			vcan.back();
		}	
	}
	
	//卡积分
	public void cardPoints(){
		vcan.clickById("com.sht.smartcommunity:id/llayout_SHTCard_credit");
		vcan.clickById("com.sht.smartcommunity:id/credit_rules_tv");
		vcan.back();
		vcan.clickById("com.sht.smartcommunity:id/credit_look_btn");
		vcan.clickById("com.sht.smartcommunity:id/credit_rules_tv");
		vcan.back();
		vcan.back();
	}
	
	//交易管理
	public void dealControl(){
		vcan.clickById("com.sht.smartcommunity:id/llayout_pay");
		vcan.clickById("com.sht.smartcommunity:id/select_result");
		vcan.back();
	}

	//手机号码
	public void phoneNum(){
		vcan.clickById("com.sht.smartcommunity:id/llayout_account");
		vcan.back();
	}
	
	//账户充值
	public void accountCharge() throws InterruptedException{
		//跳转到充值界面
		vcan.clickById("com.sht.smartcommunity:id/tv_accountcharge");
		//点击立即充值
		vcan.clickByIdAndInput("com.sht.smartcommunity:id/accountprice_edt", "0.01");
		vcan.clickById("com.sht.smartcommunity:id/promptly_recharge_btn");
		
		//添加银行卡
		vcan.clickById("com.sht.smartcommunity:id/business_choose_bank_card_sure");
		vcan.clickByIdAndInput("com.sht.smartcommunity:id/business_add_bank_card_bankcard_et", "6226620203905401");
		vcan.clickById("com.sht.smartcommunity:id/business_add_bank_card_bankcard_step");
		
		//输入银行信息，点击跳转下一步
		vcan.clickById("com.sht.smartcommunity:id/business_bankcard_info_username_et");
		Thread.sleep(5000);
		vcan.NSLog("等待输入姓名");
		Thread.sleep(5000);
		vcan.clickByIdAndInput("com.sht.smartcommunity:id/business_bankcard_info_usercard_et", "42058119920325003X");
		vcan.clickByIdAndInput("com.sht.smartcommunity:id/business_bankcard_info_tel_et", "18911192276");			
		vcan.clickById("com.sht.smartcommunity:id/business_bankcard_info_ture_bt");
		
		//输入验证码
		if(vcan.IdIsExist("com.sht.smartcommunity:id/business_order_payment_valitity_et")){
			vcan.clickById("com.sht.smartcommunity:id/business_order_payment_valitity_et");
			Thread.sleep(5000);
			vcan.NSLog("等待输入验证码");
			//跳转到下一步
			vcan.clickById("com.sht.smartcommunity:id/business_order_payment_step_bt");
			//回到城市卡主界面
			if(vcan.IdIsExist("com.sht.smartcommunity:id/order_success_jump_bt")){
				vcan.clickById("com.sht.smartcommunity:id/order_success_jump_bt");
			}else{
				vcan.back();
			}
		}
		while(!vcan.IdIsExist("com.sht.smartcommunity:id/title_imgbtn_right")){
			vcan.back();
			if(vcan.IdIsExist("com.sht.smartcommunity:id/llayout_mySHTCard")){
				break;
			}
		}
	}

	//解绑或取消
	public void unbindingCard(){
		vcan.clickById("com.sht.smartcommunity:id/title_imgbtn_right");
		//vcan.clickById("com.sht.smartcommunity:id/shtCard_more_unbind");
		vcan.clickById("com.sht.smartcommunity:id/shtCard_more_cancel");
	}
	
	public void viewAllInfo() throws InterruptedException{
		firstBindingCard();
		cardPoints();
		dealControl();
//		phoneNum(); 下周再做
		accountCharge();
		unbindingCard();
	}
}
