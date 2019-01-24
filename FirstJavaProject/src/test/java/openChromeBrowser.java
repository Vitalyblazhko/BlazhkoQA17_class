import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.*;

public class OpenChromeBrowser {
    WebDriver wd;

    @BeforeClass
    public void setUP(){
        //System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver_win32\\chromedriver.exe");
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    @Test
    public void chromeBrowserTest(){
        wd.get("http://google.com");
        //Type in search bar

        wd.findElement(By.linkText("English")).click();
        wd.findElement(By.name("q")).click();
        wd.findElement(By.name("q")).clear();
        wd.findElement(By.name("q")).sendKeys("selenium");
        wd.findElement(By.name("btnK")).click();
        wd.findElement(By.linkText("Images")).click();

    }

    @AfterClass
    public void tearDown() throws InterruptedException {
       // Thread.sleep(3000);
       // wd.quit();
    }
}
