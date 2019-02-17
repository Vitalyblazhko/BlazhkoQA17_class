package manager;

import models.Team;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.TestBase;

import java.util.concurrent.TimeUnit;

public class TeamHelper extends HelperBase {

    public TeamHelper(WebDriver wd) {
        super(wd);
    }

    public void teamCreationFromLeftNavMenu() {
        clickCreateTeamButtonOnNavMenu();
        fillTeamCreationForm(new Team().
                setTeamName("newTeam" + TimeUnit.SECONDS).
                setTeamDescr("newTeam" + TimeUnit.SECONDS));
        submitTeamCreation();
    }

    public void fillTeamCreationForm(Team team) {
        type(By.xpath("//*[@id='org-display-name']"), team.getTeamName());
        type(By.xpath("//*[@id='org-desc']"), team.getTeamDescr());
    }

    public void clickCreateTeamButtonOnNavMenu() {
        click(By.xpath("//*[@data-test-id='home-navigation-create-team-button']"));
    }

    public void submitTeamCreation() {
        wait = new WebDriverWait(wd, 10);
        click(By.xpath("//*[@class='primary wide js-save']"));
    }


    public int teamCount() {
        //wait = new WebDriverWait(wd, 20);
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@data-test-id='home-team-tab-name']")));
        int teamsCount = wd.findElements(By.cssSelector("[data-test-id^='home-team-tab-section']")).size();
        return teamsCount;
    }

    public void clickFirstTeam() {
        wd.findElements(By.cssSelector("[data-test-id^='home-team-tab-section']")).get(0).click();
    }

    public void clickSettings() {
        wait = new WebDriverWait(wd, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'Settings')]")));
        click(By.xpath("//*[contains(text(), 'Settings')]"));
    }

    public void clickDeleteThisTeamQuestion() {
        click(By.xpath("//span[contains(text(),'Delete this team?')]"));
    }

    public void submitTeamDeleting() {
        wait = new WebDriverWait(wd, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='js-confirm full negate']")));
        click(By.xpath("//*[@class='js-confirm full negate']"));
    }




}
