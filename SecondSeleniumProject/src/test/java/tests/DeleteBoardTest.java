package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteBoardTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.getSessionHelper().isUserLoggedIn()) {
            app.getSessionHelper().logIn();
        }
    }

    @Test
    public void deleteBoardFromStartOfList(){
        app.getBoardHelper().clickFirstBoard();
        app.getBoardHelper().clickShowMenu();
        app.getBoardHelper().clickMoreFromMenu();
        app.getBoardHelper().clickCloseBoardFromMenu();

    }

}
