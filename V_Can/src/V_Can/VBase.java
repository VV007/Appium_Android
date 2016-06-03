package V_Can;

import java.io.File;
import java.io.IOException;
//import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.apache.commons.io.FileUtils;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class VBase {
	
	//特定时间等待某个控件出现
	public static void waitForElementById(AppiumDriver driver, String id){
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
	}
	
	//特定时间等待某个控件出现
	public static void waitForElementByName(AppiumDriver driver, String text){
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name(text)));
	}
	
	//截图
	public static void ScreenShot(AppiumDriver driver,String ScreenName) throws IOException{
		//设置时间格式
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		//生成时间戳
		Date date = new Date();
		String dateString = formatter.format(date);
		String dir_name = System.getProperty("user.dir")+"\\异常图片";
		
		System.out.println("我要截屏啦~");
		
		//取路径
		if(!(new File(dir_name).isDirectory())){
			new File(dir_name).mkdir();
		}
		
		//调方法捕捉画面
		File screen = driver.getScreenshotAs(OutputType.FILE);
		System.out.println("异常图片名称"+dir_name+"\\"+dateString+ScreenName+".jpg");
		FileUtils.copyFile(screen, new File(dir_name+"\\"+dateString+ScreenName+".jpg"));
	}
	
	
	
	
	
	
	
	
	
	//等待某个控件出现
	public static WebElement waitForId(AppiumDriver driver, final String id){
	
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	try{
    		WebElement element = driver.findElement(By.id(id));
    		if(element.isDisplayed()){
    			return element;
    		}
    	}catch(Exception e){
    		System.out.println("页面上的元素未被找到！");
			e.printStackTrace();
    		return null;
    }
		return null;
	}
	
	public static WebElement waitForText(AppiumDriver driver, final String text){
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	try{
    		WebElement element = driver.findElement(By.name(text));
    		if(element.isDisplayed()){
    			return element;
    		}
    	}catch(Exception e){
    		System.out.println("页面上的元素未被找到！");
			e.printStackTrace();
    		return null;
    	}
		return null;
	}
	
	public static WebElement waitForClass(AppiumDriver driver, final String cls){
		
    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        try{
        	WebElement element = driver.findElement(By.className(cls));
        	if(element.isDisplayed()){
        		return element;
        	}
        }catch(Exception e){
        	System.out.println("页面上的元素未被找到！");
    		e.printStackTrace();
        	return null;
        }
		return null;
	}
	
	public static void sleep(int seconds){
		try{
			Thread.sleep(seconds * 1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
