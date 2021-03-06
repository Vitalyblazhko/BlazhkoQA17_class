package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class SessionHelper extends HelperBase {

    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void confirmLogin() {
        click(By.cssSelector("#login"));
    }

    public void fillLoginForm(String user, String password) {
        type(By.cssSelector("input[type=email]"), user);
        type(By.cssSelector("input[type=password]"), password);
    }

    public void clickLoginButton() {
        click(By.xpath("//*[contains(text(),'Log In')]"));
    }

    public void logIn() {
        wd.get("https://trello.com/en");
        try {
            clickLoginButton();
            fillLoginForm("elena.telran@yahoo.com", "12345.com");
            confirmLogin();
        } catch (Exception e) {}
        try {
            goToBoard();
        } catch (Exception e) {}
    }

    public void logOut() {
        clickOnAvatar();
        clickLogOutButton();

    }

    public void clickLogOutButton() {
        click(By.cssSelector("a.js-logout"));
    }

    public boolean isUserLoggedIn() {
        //return isElementPresent(By.cssSelector("img.member-avatar"));
        return isElementPresent(By.xpath("//*[@class='header-btn-icon icon-lg icon-house light']"));
    }

    public void clickOnAvatar() {
        Actions actions = new Actions(wd);
        actions.moveToElement(wd.findElement(By.cssSelector("img.member-avatar"))).click().perform();
    }


}
