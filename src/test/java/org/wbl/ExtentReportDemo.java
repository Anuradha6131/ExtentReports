package org.wbl;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtentReportDemo {
    ExtentReports extent;
   @BeforeTest
   public void config(){
       String path = System.getProperty("user.dir")+"\\reports\\index.html";
       ExtentSparkReporter reporter = new ExtentSparkReporter(path);
       reporter.config().setReportName("Web Automation Results");
       reporter.config().setDocumentTitle("Test Results");

       extent = new ExtentReports();
       extent.attachReporter(reporter);
       extent.setSystemInfo("Tester", "Anu");

   }
    @Test
    public void initialDemo(){
       extent.createTest("initial Demo");

        System.setProperty("webdriver.chrome.driver","C://chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.kohls.com/");
        System.out.println(driver.getTitle());
        extent.flush();
    }

}
