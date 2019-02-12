package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteBoardTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if(!app.getSessionHelper().isUserLoggedIn()) {
            app.getSessionHelper().logIn();
        }
        if(app.getBoardHelper().personalBoardsCount() == 0){
            app.getBoardHelper().boardCreationFromBody();
        }
    }

    @Test
    public void deleteBoardFromStartOfList(){
        app.getBoardHelper().clickFirstBoard();
        app.getBoardHelper().clickShowMenu();
        app.getBoardHelper().clickMoreFromMenu();
        app.getBoardHelper().clickCloseBoardFromMenu();
        app.getBoardHelper().confirmBoardDeleting();
    }

}
