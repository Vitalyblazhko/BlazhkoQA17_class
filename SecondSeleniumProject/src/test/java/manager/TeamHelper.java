package manager;

import models.Team;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TeamHelper extends HelperBase {

    public TeamHelper(WebDriver wd) {
        super(wd);
    }

    public void fillTeamCreationForm(Team team) {
        type(By.xpath("//*[@id='org-display-name']"), team.getTeamName());
        type(By.xpath("//*[@id='org-desc']"), team.getTeamDescr());
    }

    public void clickOnCreateTeamButtonOnNavMenu() {
        click(By.xpath("//*[@data-test-id='home-navigation-create-team-button']"));
    }

    public void submitTeamCreation() {
        click(By.xpath("//*[@class='primary wide js-save']"));
    }

}
