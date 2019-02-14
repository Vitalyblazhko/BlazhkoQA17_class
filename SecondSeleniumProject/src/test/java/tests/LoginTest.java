package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.TestBase;

public class LoginTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        if(app.getSessionHelper().isUserLoggedIn()){
            app.getSessionHelper().logOut();
        }
        //comment
    }

    @Test
    public void testLogin() {

        app.getSessionHelper().clickLoginButton();
        app.getSessionHelper().fillLoginForm("elena.telran@yahoo.com", "12345.com");
        app.getSessionHelper().confirmLogin();
    }


}
