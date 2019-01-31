import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;

    @BeforeClass
    public void setUp(){
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        openSite("https://trello.com/en");
    }

    public void confirmLogin() {
        wd.findElement(By.id("login")).click();
    }

    public void fillLofinForm() {
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys("elena.telran@yahoo.com");

        wd.findElement(By.name("password")).click();
        wd.findElement(By.name("password")).clear();
        wd.findElement(By.name("password")).sendKeys("12345.com");

    }

    public void logInLink(){
        wd.findElement(By.cssSelector("a.header-button-secondary")).click();
    }

    public void openSite(String url) {
        wd.get(url);
    }

    public void logIn() {
        logInLink();
        fillLofinForm();
        confirmLogin();
        goToBoard();
    }

    public boolean isUserLoggedIn() {
        return isElementPresent(By.cssSelector("img.member-avatar"));
    }

    public boolean isElementPresent(By by) {
        try {
            wd.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void goToBoard() {
        wd.findElement(By.linkText("Go to Your Boards")).click();
    }

    protected void clickOnAvatar() {
        wd.findElement(By.cssSelector("img.member-avatar")).click();
    }

    protected void clickOnLogOutButton() {
        wd.findElement(By.cssSelector("a.js-logout")).click();
    }

    @AfterClass
    public void tearDown(){
        wd.quit();
    }


}
