import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void testLogin() {

        openSite("https://trello.com/en");
        fillLofinForm();
        confirmLogin();
    }

}
