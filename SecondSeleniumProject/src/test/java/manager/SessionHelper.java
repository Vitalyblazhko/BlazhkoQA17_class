package manager;

import manager.BoardHelper;
import manager.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {

    public SessionHelper(WebDriver wd) {
        super(wd);
    }



    public void confirmLogin() {
        wd.findElement(By.id("login")).click();
    }

    public void fillLofinForm() {
        TeamHelper.click(By.id("user"));
        TeamHelper.clear(By.id("user"));
        sendKeysName(By.id("user"));

        TeamHelper.click(By.name("password"));
        TeamHelper.clear(By.name("password"));
        sendKeysPassword(By.name("password"));

    }

    public void sendKeysPassword(By locator) {
        wd.findElement(locator).sendKeys("12345.com");
    }

    public void sendKeysName(By locator) {
        wd.findElement(locator).sendKeys("elena.telran@yahoo.com");
    }

    public void logInLink() {
        wd.findElement(By.cssSelector("a.header-button-secondary")).click();
    }



    public void logIn() {
        ApplicationManager.openSite("https://trello.com/en");
        logInLink();
        fillLofinForm();
        confirmLogin();
        BoardHelper.goToBoard();
    }

    public void clickOnLogOutButton() {
        wd.findElement(By.cssSelector("a.js-logout")).click();
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

    public void clickOnAvatar() {
        wd.findElement(By.cssSelector("img.member-avatar")).click();
    }


}
