package manager;

import manager.HelperBase;
import models.Team;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TeamHelper extends HelperBase {

    static WebDriver wd;

    public TeamHelper(WebDriver wd) {
        super(wd);
    }

    public static void clear(By locator) {
        wd.findElement(locator).clear();
    }

    public static void click(By locator) {
        wd.findElement(locator).click();
    }

    public void fillTeamCreationForm(Team team) {
        click(By.xpath("//*[@id='org-display-name']"));
        clear(By.xpath("//*[@id='org-display-name']"));
        wd.findElement(By.xpath("//*[@id='org-display-name']")).sendKeys(team.getTeamName());
        wd.findElement(By.xpath("//*[@id='org-desc']")).sendKeys(team.getTeamDescr());
    }

    public void clickOnCreateTeamButtonOnNavMenu() {
        click(By.xpath("//*[@data-test-id='home-navigation-create-team-button']"));
    }

    public void submitTeamCreation() {
        click(By.xpath("//*[@class='primary wide js-save']"));
    }

}
