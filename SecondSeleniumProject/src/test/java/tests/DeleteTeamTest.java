package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteTeamTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if(!app.getSessionHelper().isUserLoggedIn()) {
            app.getSessionHelper().logIn();
        }
        //if(app.getTeamHelper().teamCount() == 0){
       //     app.getTeamHelper().teamCreationFromLeftNavMenu();
       // }
    }

    @Test
    public void deleteTeamFromLeftNavMenu(){
        int beforeTestTeamCount = app.getTeamHelper().teamCount();

        app.getTeamHelper().clickFirstTeam();
        app.getTeamHelper().clickSettings();
        app.getTeamHelper().clickDeleteThisTeamQuestion();
        app.getTeamHelper().submitTeamDeleting();

        int afterTestTeamCount = app.getTeamHelper().teamCount();

        Assert.assertEquals(afterTestTeamCount, beforeTestTeamCount-1);
    }
}
