package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.getSessionHelper().isUserLoggedIn()) {
            app.getSessionHelper().logIn();
        }
    }

    @Test
    public void testBoardCreationFromBody() {

        app.getBoardHelper().clickCreateNewBoardOnTheEndOfList();
        app.getBoardHelper().addBoardTitle("newBoard" + System.currentTimeMillis());
        app.getBoardHelper().clickCreateButton();
        app.returnToPreviousPage();
    }

   @Test
    public void testBoardCreationFromHeader() {
        app.getBoardHelper().clickPlusButtonOnHeader();
        app.getBoardHelper().selectCreateBoard();
        app.getBoardHelper().addBoardTitle("newBoard" + System.currentTimeMillis());
        app.getBoardHelper().clickCreateButton();
        app.returnToPreviousPage();
    }

    @Test
    public void testBoardCreationFromHome(){
        app.getBoardHelper().clickHomeButtonFromLeftMenu();
        app.getBoardHelper().clickCreateABoard();
        app.getBoardHelper().addBoardTitle("newBoard" + System.currentTimeMillis());
        app.getBoardHelper().clickCreateButton();
        app.returnToPreviousPage();
    }

}