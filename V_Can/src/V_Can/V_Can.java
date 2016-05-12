package V_Can;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import android.app.Notification.Action;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;

public class V_Can {

	public static AppiumDriver driver;
	private VBase vbase;
	public static String iSLogin = "No";
	
	public V_Can(AppiumDriver driver){
		this.driver = driver;
	}
	
	//
	public AppiumDriver getDriver(){
		return driver;
	}
	
	//屏幕宽、高
	public int Screen_Width(){
		return driver.manage().window().getSize().width;
	}
	
	public int Screen_Height(){
		return driver.manage().window().getSize().height;
	}
	
	//控制台输出
	public void NSLog(String string){
		System.out.println(string);
	}
	
	//ID查找控件
	public WebElement findById(String id){
		vbase = new VBase();
		vbase.waitForElementById(driver, id);
		if(IdIsExist(id)){
			return driver.findElementById(id);
		}
		return null;
	}
	
	//名字查找控件
	public WebElement findByName(String name){
		return driver.findElementByName(name);
	}
    
	//类字查找控件
	public WebElement findByClass(String ClassName){
		return driver.findElementByClassName(ClassName);
	}
	
	//ID和Index查找控件
	public WebElement findByIdAndIndex(String id, int index){
		return (WebElement)driver.findElements(By.id(id)).get(index);		
	}
	
	//Class和Index查找控件
	public WebElement findByClassAndIndex(String cls, int index){
		return (WebElement)driver.findElements(By.className(cls)).get(index);		
	}
	
	//根据ID点击
	public void clickById(String id){
		vbase = new VBase();
		WebElement btn = vbase.waitForId(driver, id);
		try{
			if(btn.isDisplayed()){
				btn.click();
			}
		}catch(Exception e){
			NSLog("没找到");
		}
	}
	
	//返回
	public void back(){
		clickById("com.sht.smartcommunity:id/title_btn_left");
	}
	
	//取消
	public void cancel(){
		clickById("com.sht.smartcommunity:id/btn_dialog_cancel");
	}
	
	//Id是否存在
	public boolean IdIsExist(String id){
		try{
			WebElement element = (WebElement) driver.findElementsById(id).get(0);
    		if(element.isDisplayed()){
    			return true;
    		}
    	}catch(Exception e){
    		return false;
    	}
		return false;
	}
	
	//class是否存在
	public boolean ClassIsExist(String cls){
		try{
    		WebElement element = (WebElement) driver.findElementsByClassName(cls).get(0);
    		if(element.isDisplayed()){
    			return true;
    		}
    	}catch(Exception e){
    		return false;
    	}
		return false;
	}
	
	//根据class名称点击
	public void clickByClass(String cls){
		vbase = new VBase();
		WebElement btn = vbase.waitForClass(driver, cls);
		try{
			if(!(btn == null)){
				btn.click();
			}
		}catch(Exception e){
			NSLog("没找到");
		}
	}
	
	//点击输入
	public void clickByIdAndInput(String id,String text){
		findById(id).click();
		findById(id).sendKeys(text);
	}
	
	//根据ID和Index点击Item
	public void clickByIdAndIndx(String id,int index){
		if(!(findByIdAndIndex(id,index) == null)){
			findByIdAndIndex(id,index).click();
		}
	}
	
	//根据Class和Index点击Item
	public void clickByClassAndIndx(String cls,int index){
		if(!(findByClassAndIndex(cls,index) == null)){
			findByIdAndIndex(cls,index).click();
		}
	}
	
	//根据内容点击控件
	public void clickByText(String text){
		vbase = new VBase();
		WebElement btn = vbase.waitForText(driver, text);
		try{
			if(!(btn == null)){
				btn.click();
			}
		}catch(Exception e){
			NSLog("没找到");
		}
	}
	
	//长按手势
	public void longClick(WebElement element){
		if(!(element == null)){
			TouchAction action = new TouchAction(driver);
			action.longPress(element).release().perform();
		}
	}
	
	//根据内容长按操作
	public void longClickByText(String text){
		longClick(findByName(text));
	}
	
	//根据ID长按操作
	public void longClickById(String id){
		longClick(findById(id));
	}
	
	//清除内容
	public void clearById(String id){
		findById(id).clear();
	}
	
	//点击指定坐标位置
	public void tapThePoint(int x, int y){
		driver.tap(1, x, y, 1);
	}
	
	//滑动操作
	public void swipe(int startx,int starty,int endx,int endy){
		driver.swipe(startx, starty, endx, endy, 150);
	}
	
	//横竖屏操作
	public static void rotateScreen() throws InterruptedException{
		driver.rotate(ScreenOrientation.LANDSCAPE);//横向
		driver.rotate(ScreenOrientation.PORTRAIT); //纵向
		
		driver.getOrientation();
	}
	
	public void gotoOtherApp(){
//		((Object) driver).startActivity("包名","主Activity");
	}
//	public void swapAction(){
//		TouchAction action = new TouchAction(driver);
//		Action.press(20,20).waitAction(1000).moveTo(40,40).release().perform();
//	}
	
	//登录密码
	public void InputPassWord(String id){
		clickById(id);
		tapThePoint(115, 1368);
		clickById(id);
		tapThePoint(44, 980);
		tapThePoint(134, 980);
		tapThePoint(225, 980);
		tapThePoint(44, 1108);
		tapThePoint(134, 1108);
		tapThePoint(225, 1108);
	}
	
	//支付密码   !@#123
	public void InputPayPassWord(String id){
		clickById(id);
		tapThePoint(115, 1368);
		clickById(id);
		tapThePoint(44, 1108);
		tapThePoint(134, 1108);
		tapThePoint(225, 1108);
		tapThePoint(44, 980);
		tapThePoint(134, 980);
		tapThePoint(225, 980);
	}
	
	//新支付密码      123456
	public void InputNewPayPassWord(String id){
		clickById(id);
		tapThePoint(115, 1368);
		clickById(id);
		tapThePoint(44, 980);
		tapThePoint(134, 980);
		tapThePoint(225, 980);
		tapThePoint(315, 980);
		tapThePoint(405, 980);
		tapThePoint(495, 980);
	}
}
