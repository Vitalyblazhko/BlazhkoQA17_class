package tests;

import models.Team;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TeamCreationTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        if(!TestBase.app.getSessionHelper().isUserLoggedIn()){
            TestBase.app.getSessionHelper().logIn();
        };
    }

    @Test
    public void teamCreationFromLeftNavMenuTest(){
        TestBase.app.getTeamHelper().clickOnCreateTeamButtonOnNavMenu();
        TestBase.app.getTeamHelper().fillTeamCreationForm(new Team().
                setTeamName("newTeam" + TimeUnit.SECONDS).
                setTeamDescr("newTeam" + TimeUnit.SECONDS));
        TestBase.app.getTeamHelper().submitTeamCreation();
    }

}
