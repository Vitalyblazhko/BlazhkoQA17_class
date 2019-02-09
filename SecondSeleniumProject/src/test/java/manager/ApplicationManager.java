package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    static BoardHelper boardHelper;
    static TeamHelper teamHelper;
    static SessionHelper sessionHelper;
    static ListHelper listHelper;
    WebDriver wd;

    public void start() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        openSite("https://trello.com/en");
        ApplicationManager.sessionHelper = new SessionHelper(wd);
        ApplicationManager.boardHelper = new BoardHelper(wd);
        ApplicationManager.teamHelper = new TeamHelper(wd);
        ApplicationManager.listHelper = new ListHelper(wd);
    }

    public void stop() {
        wd.quit();
    }

    public void openSite(String url) {
        wd.get(url);
    }

    public void returnToPreviousPage() {
        wd.navigate().back();
    }

    public BoardHelper getBoardHelper() {
        return boardHelper;
    }

    public static TeamHelper getTeamHelper() {
        return teamHelper;
    }

    public static SessionHelper getSessionHelper() {
        return sessionHelper;
    }

    public static ListHelper getListHelper() {
        return listHelper;
    }
}
