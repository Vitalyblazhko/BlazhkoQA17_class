import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogOut extends TestBase{
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

}
