package tests;

import manager.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogOut extends TestBase {
    @BeforeMethod
    public void ensurePrecondition(){
        if(!TestBase.app.getSessionHelper().isUserLoggedIn()){
            TestBase.app.getSessionHelper().logIn();
        };
    }

    @Test
    public void logOutTest(){
        TestBase.app.getSessionHelper().clickOnAvatar();
        TestBase.app.getSessionHelper().clickOnLogOutButton();

        Assert.assertFalse(TestBase.app.getSessionHelper().isUserLoggedIn());
    }

}
