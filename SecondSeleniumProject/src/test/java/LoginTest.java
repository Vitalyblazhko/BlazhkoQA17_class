import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver wd;

    @BeforeClass
    public void setUp(){
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        wd.manage().window().maximize();
    }

    @Test
    public void testLogin() {

        openSite();
        fillLofinForm();
        confirmLogin();
    }

    public void confirmLogin() {
        wd.findElement(By.id("login")).click();
    }

    public void fillLofinForm() {
        wd.findElement(By.className("header-button-secondary")).click();
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys("elena.telran@yahoo.com");

        wd.findElement(By.name("password")).click();
        wd.findElement(By.name("password")).clear();
        wd.findElement(By.name("password")).sendKeys("12345.com");

    }

    public void openSite() {
        wd.get("https://trello.com/en");
    }

}
