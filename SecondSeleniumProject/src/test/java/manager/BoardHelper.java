package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        //wait = new WebDriverWait(wd, 20);
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='icon-lg icon-member']/../../..")));
        WebElement personalBoards = wd.findElement(By.xpath("//*[@class='icon-lg icon-member']/../../.."));
        clickShowAllBoards();
        int boardsCount = personalBoards.findElements(By.xpath(".//*[@class='boards-page-board-section-list-item']")).size();
        return boardsCount;
    }

    public void clickPlusButtonOnHeader() {
        click(By.xpath("//*[@class='header-btn-icon icon-lg icon-add light']"));
    }

    public void addBoardTitle(String boardName) {
        type(By.xpath("//*[@placeholder='Add board title']"), boardName);
    }

    public void clickCreateButton() {
        wait = new WebDriverWait(wd, 10);
        click(By.cssSelector("[class='primary']"));
        wait = new WebDriverWait(wd, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='icon-sm icon-add']")));
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
        personalBoards.findElements(By.xpath(".//*[@class='board-tile-details is-badged']")).get(0).click();
    }

    public void clickShowMenu() {
        click(By.xpath("//*[@class='board-header-btn mod-show-menu js-show-sidebar']"));
    }

    public void clickMoreFromMenu() {
        click(By.xpath("//a[@class='board-menu-navigation-item-link js-open-more']"));
    }

    public void clickCloseBoardFromMenu() {
        click(By.xpath("//*[@class='board-menu-navigation-item-link js-close-board']"));
    }


    public void confirmBoardDeleting() {
        click(By.xpath("//*[@value='Close']"));
    }

    public void boardCreationFromBody() {
        clickCreateNewBoardOnTheEndOfList();
        addBoardTitle("newBoard" + System.currentTimeMillis());
        clickCreateButton();
    }

    public void clickShowAllBoards() {
        if(isElementPresent(By.xpath("//*[@class='boards-page-show-all-boards quiet-button']"))){
            click(By.xpath("//*[@class='boards-page-show-all-boards quiet-button']"));
        }
    }

   /* public boolean checkMenu(){
        boolean flag = false;

        click(By.xpath("//a[@class='board-menu-navigation-item-link js-power-up-empty-slot']"));
        if(isElementPresent(By.xpath("//a[@class='board-menu-navigation-item-link js-power-up-empty-slot']"))){
            flag = true;
        } return flag;
    }*/
}
