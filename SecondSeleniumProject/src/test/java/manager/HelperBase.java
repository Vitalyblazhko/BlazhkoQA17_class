package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperBase {
    public WebDriver wd;
    WebDriverWait wait;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void type(By locator, String text) {
        if(text!=null){
            wd.findElement(locator).click();
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);
        }
    }

    public void clear(By locator) {
        wd.findElement(locator).clear();
    }

    public void click(By locator) {
        wd.findElement(locator).click();
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

}
