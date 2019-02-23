package tests;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.TestBase;

public class LoginTest extends TestBase {

    Logger logger = LoggerFactory.getLogger(LoginTest.class);

    @BeforeMethod
    public void ensurePrecondition(){
        if(app.getSessionHelper().isUserLoggedIn()){
            app.getSessionHelper().logOut();
        }
    }

    @Test
    public void testLogin() {
        logger.info("Start test LoginTest");
        app.getSessionHelper().clickLoginButton();
        app.getSessionHelper().fillLoginForm("elena.telran@yahoo.com", "12345.com");
        app.getSessionHelper().confirmLogin();
        if(app.getSessionHelper().isElementPresent(By.linkText("Go to Your Boards"))){
            app.getSessionHelper().goToBoard();
        }
        logger.info("Stop test LoginTest");
    }


}
