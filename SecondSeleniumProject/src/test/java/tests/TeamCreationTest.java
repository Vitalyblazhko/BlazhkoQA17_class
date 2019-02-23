package tests;

import models.Team;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TeamCreationTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        if(!app.getSessionHelper().isUserLoggedIn()) {
            app.getSessionHelper().logIn();
        }
    }

    @Test
    public void teamCreationFromLeftNavMenuTest(){

        app.getTeamHelper().clickCreateTeamButtonOnNavMenu();
        app.getTeamHelper().fillTeamCreationForm(new Team().
                setNameWithTeamName("newTeam" + TimeUnit.SECONDS).
                setWithDescription("description of the new team"));
        app.getTeamHelper().submitTeamCreation();
        app.returnToPreviousPage();
    }

}
