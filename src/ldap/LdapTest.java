package ldap;

import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;


public class LdapTest {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		 //File f=new File("C:\\SeleniumServers\\chromedriver.exe");
			//System.setProperty("webdriver.chrome.driver", f.getAbsolutePath());
			//DesiredCapabilities cap = DesiredCapabilities.chrome();
			//org.openqa.selenium.WebDriver driver = new org.openqa.selenium.chrome.ChromeDriver();
			//RemoteWebDriver driver = new RemoteWebDriver(new URL("http://172.20.105.139:4444/wd/hub"), cap);
		 WebDriver driver=new FirefoxDriver();
		//DesiredCapabilities cap=new DesiredCapabilities().android();
		//RemoteWebDriver driver = new RemoteWebDriver(new URL("http://172.20.104.184:4444/wd/hub"), cap);

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("https://us.sf-qa.com/photo-gift/ldap-login");
		//Thread.sleep(5000);
		/*driver.findElement(By.id("sqat_logIn_Link")).click();
        WebElement loginframe=driver.findElement(By.xpath("//iframe[@class='panelIframe']"));
        driver.switchTo().frame(5);
		 */
		driver.findElement(By.xpath("//input[@id='EmailAddress']")).sendKeys("sqat");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Sfq1Test1");
		driver.findElement(By.xpath("//a[@id='loginsubmit']")).click();
		Thread.sleep(5000);
		System.out.println("Page title is: " + driver.getTitle());
		String str = driver.getCurrentUrl();
		System.out.println(str);
		driver.get(str+"/logout");
		
		/*driver.findElement(By.xpath("//a[contains(text(),'Create')]")).click();
		driver.findElement(By.xpath("//input[contains(@id,'name')]")).sendKeys("Swetha_300333");
		
		Select prd=new Select(driver.findElement(By.xpath("//select[contains(@id,'product_types')]")));
		prd.selectByVisibleText("Poster");
		Select size=new Select(driver.findElement(By.xpath("//select[contains(@id,'sizes')]")));
		size.selectByVisibleText("20x30");
		
			
		driver.findElement(By.xpath("//table[@id='mrchInfo']/tbody/tr[1]/td/input")).click();
		
		Select orient=new Select(driver.findElement(By.xpath("//select[contains(@id,'orientations')]")));
		orient.selectByVisibleText("Portrait");
		Select price=new Select(driver.findElement(By.xpath("//select[contains(@id,'price_level')]")));
		price.selectByVisibleText("Good");
		
		driver.findElement(By.xpath("//input[contains(@id,'date_picker_1')]")).sendKeys("12/31/2014 00:00");
		driver.findElement(By.xpath("//input[contains(@id,'date_picker_2')]")).sendKeys("12/31/2015 00:00");
		
		driver.findElement(By.cssSelector("input[value='Create']")).click();
		driver.findElement(By.xpath("//a[contains(@id,'add_file')]")).click();
				*/
		
		/*driver.get("http://library.sf-qa.com");
		Thread.sleep(5000);
		String mainWindow = driver.getWindowHandle();
		System.out.println("main window name : "+mainWindow);
		driver.findElement(By.linkText("Add photos & videos")).click();
		Set<String> windows = driver.getWindowHandles();
		System.out.println(" all windows : "+windows);
		Thread.sleep(5000);
		String childWindow = null;
		for(String s: windows){
			if(!s.equals(mainWindow)) {
				childWindow = s;
			}
		}
		driver.switchTo().window(childWindow);
		//driver.findElement(By.xpath("//td[@class='name-holder']/a[contains(text(),'Automation')]")).click();
		driver.findElement(By.xpath("//span[@id='select-file-btn']/input[@id='photo_image_select']")).click();
		//driver.findElement(By.id("psdUpload")).click();
		System.out.println("clicked on add file");
		
		
		Process process = new ProcessBuilder("c:\\sqat\\AutoitScripts\\UploadScript.exe","open","c:\\sqat\\Images","HighResolution1.jpg").start();
		

		Thread.sleep(30000);
		driver.quit();*/
		System.out.println("After quit");

		

	}

}
