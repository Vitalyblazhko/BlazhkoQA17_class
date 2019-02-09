package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        click(By.cssSelector("a.header-button-secondary"));
    }

    public void logIn() {
        clickLoginButton();
        fillLoginForm("elena.telran@yahoo.com", "12345.com");
        confirmLogin();
        goToBoard();
    }

    public void logOut() {
        clickOnAvatar();
        clickLogOutButton();

    }

    public void clickLogOutButton() {
        click(By.cssSelector("a.js-logout"));
    }

    public boolean isUserLoggedIn() {
        return isElementPresent(By.cssSelector("img.member-avatar"));
    }

    public void clickOnAvatar() {
        click(By.cssSelector("img.member-avatar"));
    }


}
