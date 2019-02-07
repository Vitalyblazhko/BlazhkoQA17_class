package tests;

import manager.TestBase;
import org.testng.annotations.Test;
public class LoginTest extends TestBase {

    @Test
    public void testLogin() {

        TestBase.app.getSessionHelper().logInLink();
        TestBase.app.getSessionHelper().fillLofinForm();
        TestBase.app.getSessionHelper().confirmLogin();
    }


}
