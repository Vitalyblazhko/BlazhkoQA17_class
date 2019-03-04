package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToHome() {
        try {
            wd.findElement(By.xpath("//*[@class='header-btn-icon icon-lg icon-house light']")).click();
        } catch (Exception e) {}
    }

}
