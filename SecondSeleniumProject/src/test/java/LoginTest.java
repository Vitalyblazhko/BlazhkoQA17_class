import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void testLogin() {

        openSite("https://trello.com/en");
        fillLofinForm();
        confirmLogin();
    }


}
