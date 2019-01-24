import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OpenWikiInChrome {
    WebDriver wd;

    @BeforeClass
    public void setUP(){
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    @Test
    public void chromeBrowserWikiTest(){
        wd.get("http://wikipedia.com");
        //Type in search bar

        wd.findElement(By.id("searchInput")).click();
        wd.findElement(By.id("searchInput")).clear();
        wd.findElement(By.id("searchInput")).sendKeys("java");
        wd.findElement(By.("search-input-button")).click();

    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        // Thread.sleep(3000);
        // wd.quit();
    }
}
