package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BoardHelper extends HelperBase {

    public BoardHelper(WebDriver wd) {
        super(wd);
        this.wd = wd;
    }

    public void clickCreateNewBoardOnTheEndOfList() {
        WebElement personalBoards = wd.findElement(By.xpath("//*[@class='icon-lg icon-member']/../../.."));
        int boardsCount = personalBoards.findElements(By.xpath(".//*[@class='boards-page-board-section-list-item']")).size();
        personalBoards.findElement(By.xpath(".//*[@class='boards-page-board-section-list-item']["+(boardsCount)+"]")).click();

    }

    public int personalBoardsCount(){
        WebElement personalBoards = wd.findElement(By.xpath("//*[@class='icon-lg icon-member']/../../.."));
        int boardsCount = personalBoards.findElements(By.xpath(".//*[@class='boards-page-board-section-list-item']")).size()-1;
        return boardsCount;
    }

    public void clickPlusButtonOnHeader() {
        click(By.cssSelector("div.header-user .icon-add"));
    }

    public void addBoardTitle(String boardName) {
        type(By.cssSelector("input.subtle-input"), boardName);
    }

    public void clickCreateButton() {
        click(By.cssSelector("[class='primary']"));
    }

    public void selectCreateBoard() {
        click(By.cssSelector(".js-new-board"));
    }

    public void clickHomeButtonFromLeftMenu() {
        click(By.cssSelector("[data-test-id='home-link']"));
    }

    public void clickCreateABoard() {
        click(By.xpath("//*[@class='icon-add icon-sm _1qcR9v_U6yheVw']"));
    }

    public void clickFirstBoard() {
        WebElement personalBoards = wd.findElement(By.xpath("//*[@class='icon-lg icon-member']/../../.."));
        WebElement firstElement = personalBoards.findElements(By.xpath(".//*[@class='board-tile-details is-badged']")).get(0);
        firstElement.click();

    }

    public void clickShowMenu() {
        click(By.xpath("//*[@class='icon-sm icon-overflow-menu-horizontal board-header-btn-icon']"));
    }

    public void clickMoreFromMenu() {
        click(By.xpath("//*[@class='board-menu-navigation-item-link js-open-more']"));
    }

    public void clickCloseBoardFromMenu() {
        click(By.xpath("//*[@class='board-menu-navigation-item-link js-close-board']"));
    }




}
