package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import tests.TestBase;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    static BoardHelper boardHelper;
    static TeamHelper teamHelper;
    static SessionHelper sessionHelper;
    static ListHelper listHelper;
    static NavigationHelper navigationHelper;
    static EventFiringWebDriver wd;
    String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void start() {
        //String browser = BrowserType.CHROME;
        if(browser.equals(BrowserType.CHROME)){
            wd = new EventFiringWebDriver(new ChromeDriver());
        } else if(browser.equals(BrowserType.FIREFOX)){
            wd = new EventFiringWebDriver(new FirefoxDriver());
        } else if(browser.equals(BrowserType.IE)){
            wd = new EventFiringWebDriver(new InternetExplorerDriver());
        } else if(browser.equals(BrowserType.EDGE)){
            wd = new EventFiringWebDriver(new EdgeDriver());
        }

        wd.register(new TestBase.MyListener());

        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        openSite("https://trello.com/en");
        sessionHelper = new SessionHelper(wd);
        boardHelper = new BoardHelper(wd);
        teamHelper = new TeamHelper(wd);
        listHelper = new ListHelper(wd);
        navigationHelper = new NavigationHelper(wd);
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

    public static NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

}
