package tests;

import dataProvider.StaticProvider;
import models.Team;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TeamCreationTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        if(!app.getSessionHelper().isUserLoggedIn()) {
            app.getSessionHelper().logIn();
        }
    }

    /*@Test(dataProvider = "validTeam", dataProviderClass = StaticProvider.class)
    public void teamCreationFromLeftNavMenuTest(String teamName, String description){

        app.getTeamHelper().clickCreateTeamButtonOnNavMenu();
        app.getTeamHelper().fillTeamCreationForm(new Team().
                setNameWithTeamName(teamName).
                setWithDescription(description));
        app.getTeamHelper().submitTeamCreation();
        app.returnToPreviousPage();
    }*/

    @Test(dataProvider = "validTeamFromCsv", dataProviderClass = StaticProvider.class)
    public void teamCreationFromLeftNavMenuTest(Team team){

        app.getTeamHelper().clickCreateTeamButtonOnNavMenu();
        app.getTeamHelper().fillTeamCreationForm(team);
        app.getTeamHelper().submitTeamCreation();
        app.returnToPreviousPage();
    }

//    @AfterMethod
//    public void postAction(){
//        app.getNavigationHelper().returnToHome();
//    }

}
