import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogOut extends LoginTest{
    @BeforeMethod
    public void ensurePrecondition(){
        if(!isUserLoggedIn()){
            logIn();
        };
    }

    @Test
    public void logOutTest(){
        clickOnAvatar();
        clickOnLogOutButton();

        Assert.assertFalse(isUserLoggedIn());

    }

    private void clickOnAvatar() {
        wd.findElement(By.cssSelector("img.member-avatar")).click();
    }

    private void clickOnLogOutButton() {
        wd.findElement(By.cssSelector("a.js-logout")).click();
    }
}
