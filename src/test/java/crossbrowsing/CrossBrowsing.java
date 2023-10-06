package crossbrowsing;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.*;
import org.apache.http.util.Asserts;
import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class CrossBrowsing {
    WebDriver driver = null;
    ExtentReports extent = new ExtentReports();
    ExtentTest test = null;

    @BeforeSuite
    public void setUpExtentReport() {
        ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\PranathiGoketi-Kairo\\Downloads\\CrossBrowsing\\report.html");
        extent.attachReporter(spark);
    }

    @BeforeMethod
    @Parameters("browser")
    public void setUpbrowser(String browser) throws IOException {

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

            String screenshotPath = "C:\\Users\\PranathiGoketi-Kairo\\Downloads\\CrossBrowsing\\src\\test\\Screenshots";
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File(screenshotPath + "screenshot.png"));
        }
    }

    @Test
    public void testGoogle() throws InterruptedException, IOException {

        test = extent.createTest("Test Google", "Verify Google website opens");
        String url = "https://kairostech.com/";
        driver.get("https://kairostech.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        String strURL = driver.getCurrentUrl();
        Assert.assertEquals(url, strURL);
        test.log(Status.INFO, "Opened Google website");
        test.log(Status.PASS, "Test passed");

        WebElement acceptall = driver.findElement(By.xpath("//button[text() ='Accept All']"));
        acceptall.click();
        Assert.assertTrue(acceptall.isEnabled(), "Accept All button should be enabled after clicking");
        test.log(Status.INFO, "Click on the Cookies");
        test.log(Status.PASS, "Test passed");


        String screenshotPath = "C:\\Users\\PranathiGoketi-Kairo\\Downloads\\CrossBrowsing\\src\\test\\Screenshots";
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(screenshotPath + "screenshot.png"));
    }

    @AfterMethod
    public void sendEmail() throws EmailException {
        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath("C:\\Users\\PranathiGoketi-Kairo\\Downloads\\CrossBrowsing\\test-output\\emailable-report.html");
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription("Report of the test execution");
        attachment.setName("Pranathi");

        Email email = new MultiPartEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(587);
        email.setAuthenticator(new DefaultAuthenticator("gpranu73@gmail.com", "oqif jxin xljl myqu"));
        email.setSSLOnConnect(true);
        email.setFrom("gpranu73@gmail.com");
        email.setSubject("Selenium TestMail");
        email.setMsg("Good Evening!.\n\n This is a test mail from pranathi where I am sending to all simultaneously for testing of my code.\n Kindly ignore. \n\n With Best Regards,\n Pranathi");
        email.addTo("pranathi.g@kairostech.com");
        ((MultiPartEmail) email).attach(attachment);

        email.send();
        System.out.println("mail sent");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @AfterSuite
    public void teardownExtentReport() {
        extent.flush();
    }
}


