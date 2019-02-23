package tests;

import com.google.common.io.Files;
import manager.ApplicationManager;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;


public class TestBase {

    public static ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    public static class MyListener extends AbstractWebDriverEventListener{
        public MyListener() {
            super();
        }

        @Override
        public void beforeFindBy(By locator, WebElement element, WebDriver driver) {
            System.out.println("search" + locator);
        }

        @Override
        public void afterFindBy(By locator, WebElement element, WebDriver driver) {
            System.out.println(locator + "found");
        }

        @Override
        public void onException(Throwable throwable, WebDriver driver) {
            System.out.println("!!!***********************!!!");
            System.out.println(throwable);
            File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File screenShot = new File("screenshot-"+System.currentTimeMillis()+".png");
            try {
                Files.copy(tmp, screenShot);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("screenshot: "+screenShot);
            System.out.println("!!!***********************!!!");
        }
    }

    @BeforeSuite
    public void setUp() {
        app.start();
    }


    @AfterSuite
    public void tearDown() throws InterruptedException {
        app.stop();
    }
}
