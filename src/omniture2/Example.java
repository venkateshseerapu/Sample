package omniture2;

import java.io.*;
import java.util.concurrent.*;
import java.lang.InterruptedException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Example {

	public static void main(String[] args) {
		FirefoxProfile profile = new FirefoxProfile();
		
		File firebug = new File(System.getProperty("user.dir") + "/src/firebug-1.10.0a11.xpi");
        File netExport = new File(System.getProperty("user.dir") + "/src/netExport-0.8b22.xpi");
        try
        {
            profile.addExtension(firebug);
            profile.addExtension(netExport);
        }
        catch (IOException err)
        {
            System.out.println(err);
        }
        
        // Set default Firefox preferences
        profile.setPreference("app.update.enabled", false);

        String domain = "extensions.firebug.";

        // Set default Firebug preferences
        profile.setPreference(domain + "currentVersion", "2.0");
        profile.setPreference(domain + "allPagesActivation", "on");
        profile.setPreference(domain + "defaultPanelName", "net");
        profile.setPreference(domain + "net.enableSites", true);

        //Send HAR files to server
        profile.setPreference(domain + "netexport.beaconServerURL", "http://localhost/har-db");
        profile.setPreference(domain + "netexport.autoExportToFile", false);
        profile.setPreference(domain + "netexport.autoExportToServer", true);
        profile.setPreference(domain + "netexport.sendToConfirmation", false);
        
        // Set default NetExport preferences
        profile.setPreference(domain + "netexport.alwaysEnableAutoExport", true);
        profile.setPreference(domain + "netexport.showPreview", false);
        profile.setPreference(domain + "netexport.defaultLogDir", "/home/venkatesh/venkatesh/seleniumtest");
        
        WebDriver driver = new FirefoxDriver(profile);
        
        try
        {
            // Wait till Firebug is loaded
            Thread.sleep(5000);

            // Load test page
            driver.get("http://www.janodvarko.cz");

            // Wait till HAR is exported
            Thread.sleep(10000);
        }
        catch (InterruptedException err)
        {
            System.out.println(err);
        }
        driver.quit();
	}

}
