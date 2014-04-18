import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.selendroid.SelendroidCapabilities;
import io.selendroid.SelendroidDriver;





import org.apache.commons.io.FileUtils;
import org.bouncycastle.util.encoders.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;


public class Touch {

	public static void main(String[] args) {
		//SelendroidDriver driver=null;
		WebDriver driver=null;
		System.out.println("From main method");
		try {
			DesiredCapabilities cap=null;
			cap=new DesiredCapabilities().android();
			cap.setCapability(SelendroidCapabilities.EMULATOR, true);
			cap.setCapability(CapabilityType.HAS_NATIVE_EVENTS, true);
			cap.setCapability(CapabilityType.SUPPORTS_APPLICATION_CACHE, true);
			
			driver =new SelendroidDriver(new URL("http://172.20.104.100:4445/wd/hub"), cap);
			System.out.println("Driver intiated");
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			System.out.println("Intiated driver");
			
		    driver.get("https://us.sf-stg.com/photo-gift/ldap-login");	
			Thread.sleep(5000);
			driver.findElement(By.id("EmailAddress")).sendKeys("sqat");
			driver.findElement(By.id("Password")).sendKeys("Sfq1Test1");
			driver.findElement(By.id("loginsubmit")).click();
			Thread.sleep(10000);
			
			TouchActions touch = new TouchActions(driver);
			//screenshot
			/* WebDriver augmentedDriver = new Augmenter().augment(driver);
	         String screenshot = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.BASE64);
	         byte[] decodedScreenshot = Base64.decode(screenshot.getBytes());
	         FileOutputStream fos = new FileOutputStream(new File("D:\\selendroid\\mobilescreen1.jpg"));
	         fos.write(decodedScreenshot);
	         fos.close();*/
	         
	         File scrFile3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	         System.out.println("captured screenshot");
	         FileUtils.copyFile(scrFile3,new File("D:\\selendroid\\mobilescreen3.jpg"));
	         System.out.println("Stored the screenshot");
			/*
			driver.get("https://us.sf-stg.com/snapfish/login");
			System.out.println("opend page");
			Thread.sleep(5000);
			TouchActions touch = new TouchActions(driver);
			WebElement email=driver.findElement(By.xpath("//input[@name='emailaddress']"));
			
            System.out.println("scroll action performed....");
			email.clear();
			System.out.println("Identified email text field");
			driver.findElement(By.xpath("//input[@name='emailaddress']")).sendKeys("testfeb1@in.com"); //testmar7@in.com
			driver.findElement(By.cssSelector("input[name='password']")).sendKeys("sfqatest12");
			driver.findElement(By.xpath("//input[@name='log in']")).click();
			Thread.sleep(5000);
			System.out.println("Page title is: " + driver.getTitle());
			driver.findElement(By.id("homeProjectsDivLink"));
			
			driver.get("https://us.sf-stg.com/snapfish/photo-gifts");
			Thread.sleep(5000);
			System.out.println("opened photo-gifts page");
			driver.findElement(By.xpath("//div[@class='universalapps']//a[text()='Snapfish.com']")).click();
			System.out.println("clicked on snapfish link");
			Thread.sleep(10000);
		    
			WebElement homedecor = driver.findElement(By.xpath("//a[text()='Home Decor']"));
			System.out.println("home decore ----> found");
			int homedecorx=homedecor.getLocation().getX();
			System.out.println("x cordinated ...."+homedecorx);
			int homedecory=homedecor.getLocation().getY();
			System.out.println("y cordinated ...."+homedecory);
			touch.scroll(homedecorx, homedecory);
			//touch.scroll(homedecor,0,100);
			//touch.flick(homedecor, 0,100,0).build().perform();
			System.out.println("scroll action performed....");
			Thread.sleep(5000);
			
			homedecor.click();
			System.out.println("clicked on shop home decor link in shop");
			Thread.sleep(10000);*/
			
			driver.get("https://us.sf-stg.com/photo-gift/loginto");	
			Thread.sleep(5000);
			driver.findElement(By.id("EmailAddress")).sendKeys("testfeb1@in.com");
			driver.findElement(By.id("Password")).sendKeys("sfqatest12");
			driver.findElement(By.id("loginsubmit")).click();
			System.out.println("login into site....");
			Thread.sleep(20000);
			File scrFile4 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	         System.out.println("captured screenshot");
	         FileUtils.copyFile(scrFile4,new File("D:\\selendroid\\mobilescreen4.jpg"));
	         System.out.println("Stored the screenshot");
	         
			WebElement canvas=driver.findElement(By.xpath("//img[contains(@src,'canvas_print_welcome_1')]"));
			System.out.println("canvas visibility ---"+canvas.isDisplayed());                                                            
			touch.flick(canvas,0,100,0);
			canvas.click();
			Thread.sleep(5000);
			File scrFile5 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	         System.out.println("captured screenshot");
	         FileUtils.copyFile(scrFile5,new File("D:\\selendroid\\mobilescreen5.jpg"));
	         System.out.println("Stored the screenshot");
			/*WebElement store=driver.findElement(By.linkText("Shop All Categories"));
			System.out.println("store locator visibility +++"+store.isDisplayed());
			System.out.println("Page title is: " + driver.getTitle());
			int storex=store.getLocation().getX();
			System.out.println("x cordinated ...."+storex);
			int storey=store.getLocation().getY();
			System.out.println("y cordinated ...."+storey);
			touch.scroll(storex, storey);
			store.click();
			Thread.sleep(5000);
			WebElement homedecor = driver.findElement(By.xpath("//a[text()='Home Decor']"));
			System.out.println("home decore ----> found");
			int homedecorx=homedecor.getLocation().getX();
			System.out.println("x cordinated ...."+homedecorx);
			int homedecory=homedecor.getLocation().getY();
			System.out.println("y cordinated ...."+homedecory);
			touch.scroll(homedecorx, homedecory);
			//touch.scroll(homedecor,0,100);
			//touch.flick(homedecor, 0,100,0).build().perform();
			System.out.println("scroll action performed....");
			homedecor.click();
			Thread.sleep(5000);
			
			WebElement poster=driver.findElement(By.xpath("//img[contains(@src,'allproducts/Tile_03_Cards_GreetingCards.jpg')]"));
			//WebElement poster=driver.findElement(By.linkText("Poster Prints"));
			System.out.println("home decore ----> found");
			
			int posterx=poster.getLocation().getX();
			System.out.println("x cordinated ...."+posterx);
			int postery=poster.getLocation().getY();
			System.out.println("y cordinated ...."+postery);
			touch.scroll(posterx, postery);
            //element not exist in cache exception getting	    
			//touch.flick(poster,0, 100,0).build().perform();
			//touch.scroll(poster, 0, 100);
			System.out.println("scroll action performed....");
			poster.click();
			System.out.println("clicked on poster tile");
			System.out.println("sleep time enabled");*/
			Thread.sleep(20000);
			
			System.out.println("element visible :"+driver.findElement(By.xpath("//select[@id='sizeEl']")).isDisplayed());
			System.out.println("Page title is: " + driver.getTitle());
			Select dropdown = new Select(driver.findElement(By.id("sizeEl")));
			System.out.println("Selection action");
			dropdown.selectByValue("2");
			System.out.println("selected from size drop down");

		    
			WebElement e=driver.findElement(By.id("buttonId"));
			System.out.println("element visible ..."+e.isDisplayed());
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("$(arguments[0]).click();", e);
			Thread.sleep(30000);
			
			System.out.println("Page title is: " + driver.getTitle());
			System.out.println("builder page");
			/*driver.findElement(By.xpath("//a/span[text()='Add photos & videos']"));
			
			WebElement myElement =driver.findElement(By.xpath("//img[contains(@id,'img_')]"));
    		Actions builder = new Actions(driver);
        	builder.moveToElement(myElement).build().perform();
			driver.findElement(By.xpath("//div[contains(@id,'select_')]")).click();
			driver.findElement(By.id("closePickers")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@id='photosPanel']//div[@class='sizeIcon']//img[contains(@id,'img_')]"));	
			Actions builder1 = new Actions(driver);
			WebElement element = driver.findElement(By.xpath("//img[contains(@class,'img-thumbnail')]")); 
			WebElement target = driver.findElement(By.id("edit_canvas_layer"));
		    builder1.clickAndHold(element).moveToElement(target).release(target).build().perform();
		    System.out.println("performed drag and drop");  
			Thread.sleep(5000);*/
			File scrFile6 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	         System.out.println("captured screenshot");
	         FileUtils.copyFile(scrFile6,new File("D:\\selendroid\\mobilescreen6.jpg"));
	         System.out.println("Stored the screenshot");
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[contains(@id,'select_')]")).click();
			System.out.println("selected image");
			WebElement close=driver.findElement(By.xpath("//span[text()='Close']"));
			executor.executeScript("$(arguments[0]).click();", close);
			Thread.sleep(5000);
			/*Actions builder1 = new Actions(driver);
			WebElement element = driver.findElement(By.xpath("//img[contains(@class,'img-thumbnail')]")); 
			WebElement target = driver.findElement(By.id("edit_canvas_layer"));
			System.out.println("source and target identified");
		    //builder1.clickAndHold(element).moveToElement(target).release(target).build().perform();
			builder1.dragAndDrop(element, target).build().perform();*/
			File scrFile7= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	         System.out.println("captured screenshot");
	         FileUtils.copyFile(scrFile7,new File("D:\\selendroid\\mobilescreen7.jpg"));
	         System.out.println("Stored the screenshot");
			//URL jqueryUrl = Resources.getResource("drag_and_drop_helper.propagate-dropTarget.js");
	        URL jqueryUrl = Resources.getResource("drag_and_drop_helper.js");
	         
			System.out.println("loaded jquery resources");
			String jqueryText = Resources.toString(jqueryUrl,Charsets.UTF_8);
			//executor.executeScript(jqueryText);
			System.out.println("jquery injected...");
			
			driver.findElement(By.xpath("//img[contains(@class,'img-thumbnail')]")); 
			driver.findElement(By.xpath("//canvas[@id='imgEditCanvas']"));
			String dragSourceJQuerySelector="//img[contains(@class,'img-thumbnail')]";
			String dropTargetJQuerySelector="//canvas[@id='imgEditCanvas']";
			/*String javascript =
		            "var dropTarget = jQuery(" + dropTargetJQuerySelector + ");" +
		            "\n" +
		            "jQuery("+ dragSourceJQuerySelector + ").simulate('drag', { dropTarget: dropTarget });";
*/
			
		        //System.out.println("executing javascript:\n" + javascript);
		        executor.executeScript(jqueryText+"$('#{dragSourceJQuerySelector}').simulateDragDrop({ dropTarget: '#{dropTargetJQuerySelector}'});");
		        System.out.println("executed drag-n-drop action via javascript");
		        Thread.sleep(20000);
		    System.out.println("performed drag and drop");  
		
			WebElement next=driver.findElement(By.id("reviewBtn"));
			touch.scroll(next, 0,100);
			System.out.println("Next button visibility "+ next.isDisplayed());
			//next.click();
			executor.executeScript("$(arguments[0]).click();", next);
			Thread.sleep(5000);
			
			System.out.println("Page title is: " + driver.getTitle());
			driver.findElement(By.id("addToCartBtn")).click();
			Thread.sleep(5000);
			//driver.findElement(By.xpath("//div[@id='goto_billing_button_up']//a[@id='check_out']"));
			System.out.println("Page title is: " + driver.getTitle());
			System.out.println("added poster to cart");
			driver.findElement(By.id("edit_address_button")).click();
			WebElement street1=driver.findElement(By.id("streetmailing"));
			street1.clear();
			street1.sendKeys("s3");
			WebElement street2=driver.findElement(By.id("streetmailing2"));
			street2.clear();
			street2.sendKeys("s4");
			WebElement city=driver.findElement(By.id("citymailing"));
			city.clear();
			city.sendKeys("San Francisco");
			Select state= new Select(driver.findElement(By.id("statemailing")));
			System.out.println("Selection action");
			state.selectByValue("CA");
	    	System.out.println("selected from state drop down");		
	    	WebElement zip=driver.findElement(By.id("zipmailing"));
	    	zip.clear();
	    	zip.sendKeys("94104");	
	    	
	    	Select country= new Select(driver.findElement(By.id("mailingcountrycode")));
			System.out.println("Selection action");
			country.selectByValue("US");
	    	System.out.println("selected from country drop down");		
	    	driver.findElement(By.id("save_button")).click();
	    	driver.findElement(By.id("add_to_cart_top")).click();
	    	
	    	Thread.sleep(5000);
	    	driver.findElement(By.id("goto_billing_button_up")).click();
	    	driver.findElement(By.id("editpaymentButton")).click();
	    	
	    	Select cardtype= new Select(driver.findElement(By.id("cctype_cctype")));
			System.out.println("Selection cctype action");
			cardtype.selectByValue("VIS");
	    	System.out.println("selected from card type drop down");	
	    	WebElement ccno=driver.findElement(By.id("ccnumber"));
	    	ccno.clear();
	    	ccno.sendKeys("4111111111111111");
	    	Select month= new Select(driver.findElement(By.id("ccexpirationmonth")));
			System.out.println("Selection cctype action");
			month.selectByValue("7");
	    	System.out.println("selected from month drop down");		
	    	Select year= new Select(driver.findElement(By.id("ccexpirationyear_ccexpirationyear")));
			System.out.println("Selection cctype action");
			year.selectByValue("2015");
	    	System.out.println("selected from year drop down");	
	    	WebElement cvv=driver.findElement(By.id("securitycode"));
	    	cvv.clear();
	    	cvv.sendKeys("150");
	    	driver.findElement(By.id("savecctoaccount")).click();
	    	driver.findElement(By.id("use_shipping_address")).click();
	    	driver.findElement(By.id("buy_now_button_bottom")).click();
	    	Thread.sleep(10000);
	    	
	    	driver.findElement(By.id("your_account_link"));
	    	driver.findElement(By.id("ship_bin_number"));
	    	System.out.println("Page title is: " + driver.getTitle());
	    	System.out.println("order placed");
	    	
		}

		catch (Exception e) {
			System.out.println("from catch block");
			e.printStackTrace();
		}
		finally{
			driver.quit();
		}
		System.out.println("After quit");
	}
}