import org.testng.annotations.Test;
public class LoginTest extends TestBase {

    @Test
    public void testLogin() {

        app.logInLink();
        app.fillLofinForm();
        app.confirmLogin();
    }


}
