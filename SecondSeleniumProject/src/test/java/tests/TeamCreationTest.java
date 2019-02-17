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
        try {
            app.returnToHome();
        } catch (Exception e) {}
    }

    @Test
    public void teamCreationFromLeftNavMenuTest(){
        try {
            app.returnToHome();
        } catch (Exception e) {}

        app.getTeamHelper().clickCreateTeamButtonOnNavMenu();
        app.getTeamHelper().fillTeamCreationForm(new Team().
                setTeamName("newTeam" + TimeUnit.SECONDS).
                setTeamDescr("newTeam" + TimeUnit.SECONDS));
        app.getTeamHelper().submitTeamCreation();
        app.returnToPreviousPage();
    }

}
