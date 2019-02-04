import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogOut extends TestBase{
    @BeforeMethod
    public void ensurePrecondition(){
        if(!app.isUserLoggedIn()){
            app.logIn();
        };
    }

    @Test
    public void logOutTest(){
        app.clickOnAvatar();
        app.clickOnLogOutButton();

        Assert.assertFalse(app.isUserLoggedIn());
    }

}
