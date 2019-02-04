import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamCreationTest extends TestBase {
    @BeforeMethod
    public void ensurePrecondition(){
        if(!app.isUserLoggedIn()){
            app.logIn();
        };
    }

    @Test
    public void teamCreationFromLeftNavMenuTest(){
        app.clickOnCreateTeamButtonOnNavMenu();
        app.fillTeamCreationForm();
        app.submitTeamCreation();
    }




}
