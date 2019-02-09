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
}
