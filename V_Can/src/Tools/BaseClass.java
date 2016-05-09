package Tools;

import java.io.File;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.remote.DesiredCapabilities;

import V_Can.V_Can;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class BaseClass {
	
	private AppiumDriver driver;
	private V_Can vcan;
	protected static PageManager pageManager;
	
	private String deviceName = "VCan";
	private String platformVersion = "4.4.2";
	private String apkName = "SmartCommunity_Signed_v1.2.287.apk";
	private String appActivity = "com.sht.smartcommunity.ui.activity.StartActivity";
	private String AppiumServerIP = "http://127.0.0.1:4723/wd/hub";
	
	public void setUp() throws Exception{
		File apk = new File(System.getProperty("user.dir")+File.separator+"apps"+File.separator+apkName);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", deviceName);
		capabilities.setCapability("platformVersion", platformVersion);
		capabilities.setCapability("app", apk);
		capabilities.setCapability("appActivity", appActivity);
		capabilities.setCapability("noSign", true);
		capabilities.setCapability("noReset", true);
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		
		vcan = new V_Can(driver);
		pageManager = new PageManager(vcan);
	}
	
	//webView的交互     切换上下文  -> 根据xpath获取控件，getText().toString
	public void switchContext(){
		Set<String> contextNames = vcan.getDriver().getContextHandles();
		for(String contextName : contextNames){
			System.out.println(contextName);
		}
		String lastestContextView = contextNames.toArray()[contextNames.size()-1].toString();
		if(lastestContextView.contains("WEBVIEW")){
			vcan.getDriver().context(lastestContextView);
		}
	}
	
	public void switchToNative(){
		vcan.getDriver().context("NATIVE");
	}
	
	public void tearDown(){
		driver.quit();
	}
}
