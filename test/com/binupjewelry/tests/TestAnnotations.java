package com.binupjewelry.tests;
/**
 * Created by binup on 5/13/2017.
 */
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.binupjewelry.config.ConfigReader;
import com.binupjewelry.config.Settings;
import com.binupjewelry.base.DriverContext;

public class TestAnnotations {
	
	@BeforeSuite(alwaysRun = true)
    public void setupTestSuite() {
		System.out.println("Beginning Test initialization.....");		
        ConfigReader.PopulateSettings();
        System.setProperty("webdriver.gecko.driver",Settings.geekoDriverPath);
        
        DriverContext.driver = new FirefoxDriver();	
        System.out.println("Navigating to test URL: " +Settings.AUT);
        DriverContext.driver.get(Settings.AUT);
        DriverContext.driver.manage().window().maximize();   
        System.out.println("Test initialization Completed");

    }
	
	@AfterSuite
    public void TearDownTestSuite() {	        
        // close application
       // DriverContext.driver.close();		 		 
        }
}
