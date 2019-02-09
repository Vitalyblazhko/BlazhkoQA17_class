package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ListCreationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.getSessionHelper().isUserLoggedIn()) {
            app.getSessionHelper().logIn();
        }
    }

    @Test
    public void testListCreationViaBoardCreationFromHeader() throws InterruptedException {
        app.getBoardHelper().clickPlusButtonOnHeader();
        app.getBoardHelper().selectCreateBoard();
        app.getBoardHelper().addBoardTitle("newBoard" + System.currentTimeMillis());
        app.getBoardHelper().clickCreateButton();

        app.getListHelper().enterListTitle();
        app.getListHelper().submitAddListCreation();
        app.getListHelper().clickAddACard();
        app.getListHelper().enterFirstCardTitle();
        app.getListHelper().submitAddCardCreation();
        app.getListHelper().enterSecondCardTitle();
        app.getListHelper().submitAddCardCreation();

        int numberOfCards = app.getListHelper().wd.findElements(By.xpath("//*[@class='list-card-details js-card-details']")).size();

        Assert.assertEquals(2, numberOfCards);

    }
}
