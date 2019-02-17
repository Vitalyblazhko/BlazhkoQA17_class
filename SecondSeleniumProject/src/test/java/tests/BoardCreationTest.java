package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BoardCreationTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.getSessionHelper().isUserLoggedIn()) {
            app.getSessionHelper().logIn();
        }
        try {
            app.returnToHome();
        } catch (Exception e) {}
    }

    @Test
    public void testBoardCreationFromBody(){
        try {
            app.returnToHome();
        } catch (Exception e) {}
        app.getBoardHelper().clickShowAllBoards();
        int beforeCount = app.getBoardHelper().personalBoardsCount();

        app.getBoardHelper().clickCreateNewBoardOnTheEndOfList();
        app.getBoardHelper().addBoardTitle("newBoard" + System.currentTimeMillis());
        app.getBoardHelper().clickCreateButton();
        app.returnToPreviousPage();

        app.getBoardHelper().clickShowAllBoards();
        int afterCount = app.getBoardHelper().personalBoardsCount();

        app.getBoardHelper().wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Assert.assertEquals(afterCount, beforeCount+1);
        app.returnToHome();
    }

    /*@Test(enabled = false)
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
    }*/

}