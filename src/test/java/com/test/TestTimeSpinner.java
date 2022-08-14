package com.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class TestTimeSpinner {

	
	private AndroidDriver driver;

	 @BeforeTest
	  public void setUp() throws MalformedURLException {
	    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "android");
	    desiredCapabilities.setCapability("appium:platformVersion", "8.1.0");
	    desiredCapabilities.setCapability("appium:deviceName", "Android SDK built for x86");
	    desiredCapabilities.setCapability("appium:app", "D:\\ApiDemos-debug.apk");
	    desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
	    desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
	    desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
	    desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

	    URL remoteUrl = new URL("http://localhost:4723/wd/hub");

	    driver = new AndroidDriver(remoteUrl, desiredCapabilities);
	  }


	  
	 
	 @Test
	  public void sampleTest() throws Throwable {
		  
		 MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Views");
		    el1.click();
		    MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("Date Widgets");
		    el2.click();
		    MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("1. Dialog");
		    el3.click();
		    MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("change the time (spinner)");
		    el4.click();

//		  
//		  	
			MobileElement CenterButton= (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[1]/android.widget.EditText");
			System.out.println("CenterButton text ="+CenterButton.getAttribute("text"));
			System.out.println("CenterButton position X ="+CenterButton.getCenter().getX());
			System.out.println("CenterButton position Y ="+CenterButton.getCenter().getY());
			
			
			MobileElement DownButton = (MobileElement) driver.findElementByXPath("//android.widget.NumberPicker[1]/android.widget.Button[2]");
			System.out.println("DownButton text ="+DownButton.getAttribute("text"));
			System.out.println("DownButton position X ="+DownButton.getCenter().getX());
			System.out.println("DownButton position Y ="+DownButton.getCenter().getY());
			
			int startX=DownButton.getCenter().getX();
			int startY=DownButton.getCenter().getY();
			

			int endX=CenterButton.getCenter().getX();
			int endY=CenterButton.getCenter().getY();
//			endY= startY-100;

			System.out.println("StartY ="+startY);
			System.out.println("endY ="+endY);
			
			TouchAction touchAction = new TouchAction(driver);
			
			touchAction
	        .longPress(PointOption.point(startX,startY))
//	        .moveTo(PointOption.point(startX,endY))
	        .release()
	        .perform();

		}

	  @AfterClass
	  public void tearDown() throws Throwable {
		  Thread.sleep(20000);
	    driver.quit();
	  }
	}
