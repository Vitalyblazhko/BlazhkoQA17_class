package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogOutTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        if(!app.getSessionHelper().isUserLoggedIn()){
            app.getSessionHelper().logIn();
        }
    }

    @Test
    public void logOutTest(){
        app.getSessionHelper().clickOnAvatar();
        app.getSessionHelper().clickLogOutButton();

        Assert.assertFalse(app.getSessionHelper().isUserLoggedIn());
    }

}
