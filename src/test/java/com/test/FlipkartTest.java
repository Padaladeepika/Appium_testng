package com.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.testng.Assert;
public class FlipkartTest {
	
	private AndroidDriver<MobileElement> driver;
	    public WebDriverWait                wait;
		TouchAction touchAction;
	
	@BeforeTest
	public void setUp() throws MalformedURLException {
	    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "android");
	    desiredCapabilities.setCapability("appium:platformVersion", "11");
	    desiredCapabilities.setCapability("appium:deviceName", "Android SDK built for x86");
	    desiredCapabilities.setCapability("appium:app", "D:\\Flipkart-7.18.apk");
	    desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
	    desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
	    desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
	    desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

	    URL remoteUrl = new URL("http://localhost:4723/wd/hub");

	    driver = new AndroidDriver(remoteUrl, desiredCapabilities);
	    touchAction = new TouchAction(driver); 
	    wait = new WebDriverWait(driver, 10);
	    
	 	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  }
	
      @Test
	  public void Homepage () throws Throwable  {
		  Thread.sleep(20000);
		  
		  Thread.sleep(20000);
  		  MobileElement EnglishLang = driver.findElement(By.xpath("//android.widget.RelativeLayout[4]"));
	EnglishLang.click();
	MobileElement ContBtn = driver.findElement(By.id("com.flipkart.android:id/select_btn"));
	ContBtn.click();
	MobileElement XIcon = driver.findElement(By.id("com.flipkart.android:id/custom_back_icon"));
	XIcon.click();
	
	  wait.until(ExpectedConditions.elementToBeClickable(By.id("com.flipkart.android:id/search_widget_textbox")));
	   MobileElement SearchBox = driver.findElement(By.id("com.flipkart.android:id/search_widget_textbox"));
	   SearchBox.click();
	    
	   wait.until(ExpectedConditions.elementToBeClickable(By.id("com.flipkart.android:id/search_autoCompleteTextView")));
	     MobileElement SearchBox1 = driver.findElement(By.id("com.flipkart.android:id/search_autoCompleteTextView"));
		SearchBox1.sendKeys("Laptop Bags");
	   
	MobileElement  roottitiles=	driver.findElement(By.id("com.flipkart.android:id/root_titles"));
			roottitiles.click();
		Thread.sleep(3000);
		
		MobileElement  notnowbtn = driver.findElement(By.id("com.flipkart.android:id/not_now_button"));
		notnowbtn.click();
		  
			Thread.sleep(3000);
		 
	touchAction.tap(PointOption.point(30, 2055)).perform();
	Thread.sleep(2000);
	
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='ADD TO CART']")));
	MobileElement AddToCartBtn = driver.findElement(By.xpath("//android.widget.TextView[@text='ADD TO CART']"));
	AddToCartBtn.click();
	Thread.sleep(2000);
	
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='GO TO CART']")));
	MobileElement GoToCartBtn = driver.findElement(By.xpath("//android.widget.TextView[@text='GO TO CART']"));
	GoToCartBtn.click();
	
	MobileElement CartScreen =  driver.findElement(By.xpath("//android.widget.TextView[@text='My Cart']"));
	CartScreen.click();
	
	
	System.out.println("My Cart screen is displayed");
	
	  }
		 
  public void sampleTest() throws Throwable  {
		  Homepage ();
	  }

	  @AfterTest
	  public void tearDown() {
		 
		  driver.quit();
	  }
	}