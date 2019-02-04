import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;

    public void start() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        openSite("https://trello.com/en");
    }

    public void confirmLogin() {
        wd.findElement(By.id("login")).click();
    }

    public void fillLofinForm() {
        click(By.id("user"));
        clear(By.id("user"));
        sendKeysName(By.id("user"));

        click(By.name("password"));
        clear(By.name("password"));
        sendKeysPassword(By.name("password"));

    }

    public void sendKeysPassword(By locator) {
        wd.findElement(locator).sendKeys("12345.com");
    }

    public void sendKeysName(By locator) {
        wd.findElement(locator).sendKeys("elena.telran@yahoo.com");
    }

    public void clear(By locator) {
        wd.findElement(locator).clear();
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void logInLink(){
        wd.findElement(By.cssSelector("a.header-button-secondary")).click();
    }

    public void openSite(String url) {
        wd.get(url);
    }

    public void logIn() {
        openSite("https://trello.com/en");
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

    public void stop() {
        wd.quit();
    }
    public void submitTeamCreation() {
    }

    public void fillTeamCreationForm() {
    }

    public void clickOnCreateTeamButtonOnNavMenu() {


    }
}
