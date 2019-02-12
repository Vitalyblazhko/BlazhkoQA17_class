package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    static BoardHelper boardHelper;
    static TeamHelper teamHelper;
    static SessionHelper sessionHelper;
    static ListHelper listHelper;
    static WebDriver wd;
    String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void start() {
        //String browser = BrowserType.CHROME;
        if(browser.equals(BrowserType.CHROME)){
            wd = new ChromeDriver();
        } else if(browser.equals(BrowserType.FIREFOX)){
            wd = new FirefoxDriver();
        } else if(browser.equals(BrowserType.IE)){
            wd = new InternetExplorerDriver();
        }
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        openSite("https://trello.com/en");
        ApplicationManager.sessionHelper = new SessionHelper(wd);
        ApplicationManager.boardHelper = new BoardHelper(wd);
        ApplicationManager.teamHelper = new TeamHelper(wd);
        ApplicationManager.listHelper = new ListHelper(wd);
    }

    public void stop() throws InterruptedException {
        Thread.sleep(3000);
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
