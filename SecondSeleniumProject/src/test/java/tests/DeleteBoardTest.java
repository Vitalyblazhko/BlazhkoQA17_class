package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteBoardTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if(!app.getSessionHelper().isUserLoggedIn()) {
                app.getSessionHelper().logIn();
        }
        //if(app.getBoardHelper().personalBoardsCount() == 0){
       //    app.getBoardHelper().boardCreationFromBody();
        //}
    }

    @Test
    public void deleteBoardFromStartOfList(){
        int beforeCount = app.getBoardHelper().personalBoardsCount();

        app.getBoardHelper().clickFirstBoard();
        try {
            app.getBoardHelper().clickShowMenu();
        } catch (Exception e) {
        };

        app.getBoardHelper().clickMoreFromMenu();
        app.getBoardHelper().clickCloseBoardFromMenu();
        app.getBoardHelper().confirmBoardDeleting();
        app.returnToPreviousPage();

        int afterCount = app.getBoardHelper().personalBoardsCount();

        Assert.assertEquals(afterCount+1, beforeCount);
        app.getNavigationHelper().returnToHome();
    }

}
