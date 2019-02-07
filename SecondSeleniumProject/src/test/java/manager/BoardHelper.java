package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BoardHelper {

    static WebDriver wd;

    public BoardHelper(WebDriver wd) {
        this.wd = wd;
    }

    public static void goToBoard() {
        wd.findElement(By.linkText("Go to Your Boards")).click();
    }
}
