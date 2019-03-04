package tests;

import models.Team;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TeamCreationTest extends TestBase {

    @DataProvider
    public Iterator <Object[]> validTeam() {
        List<Object[]> listOfTeams = new ArrayList<>();
        listOfTeams.add(new Object[]{"test1","description"});
        listOfTeams.add(new Object[]{"test2","description description"});
        listOfTeams.add(new Object[]{"test3","description description description"});
        return listOfTeams.iterator();

    }

    @BeforeMethod
    public void ensurePrecondition(){
        if(!app.getSessionHelper().isUserLoggedIn()) {
            app.getSessionHelper().logIn();
        }
    }

    @Test(dataProvider = "validTeam")
    public void teamCreationFromLeftNavMenuTest(String teamName, String description){

        app.getTeamHelper().clickCreateTeamButtonOnNavMenu();
        app.getTeamHelper().fillTeamCreationForm(new Team().
                setNameWithTeamName(teamName).
                setWithDescription(description));
        app.getTeamHelper().submitTeamCreation();
        app.returnToPreviousPage();
    }

//    @AfterMethod
//    public void postAction(){
//        app.getNavigationHelper().returnToHome();
//    }

}
