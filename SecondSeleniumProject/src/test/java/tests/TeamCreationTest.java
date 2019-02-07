package tests;

import manager.TestBase;
import models.Team;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
        TestBase.app.getTeamHelper().fillTeamCreationForm(new Team("newTeam", "newTeam"));
        TestBase.app.getTeamHelper().submitTeamCreation();
    }




}
