package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.getSessionHelper().isUserLoggedIn()) {
            app.getSessionHelper().logIn();
        }
    }

    @Test(priority = 0)
    public void testBoardCreationFromBody() {
        int beforeCount = app.getBoardHelper().personalBoardsCount();

        app.getBoardHelper().clickCreateNewBoardOnTheEndOfList();
        app.getBoardHelper().addBoardTitle("newBoard" + System.currentTimeMillis());
        app.getBoardHelper().clickCreateButton();
        app.returnToPreviousPage();

        int afterCount = app.getBoardHelper().personalBoardsCount();

        Assert.assertEquals(afterCount, 1+beforeCount);
    }

    @Test(enabled = false)
    public void testBoardCreationFromHeader() {
        app.getBoardHelper().clickPlusButtonOnHeader();
        app.getBoardHelper().selectCreateBoard();
        app.getBoardHelper().addBoardTitle("newBoard" + System.currentTimeMillis());
        app.getBoardHelper().clickCreateButton();
        app.returnToPreviousPage();
    }

    @Test(enabled = false)
    public void testBoardCreationFromHome(){
        app.getBoardHelper().clickHomeButtonFromLeftMenu();
        app.getBoardHelper().clickCreateABoard();
        app.getBoardHelper().addBoardTitle("newBoard" + System.currentTimeMillis());
        app.getBoardHelper().clickCreateButton();
        app.returnToPreviousPage();
    }

}