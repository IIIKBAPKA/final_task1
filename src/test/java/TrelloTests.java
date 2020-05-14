import api.ApiRequest;
import api.SetUp;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import ui.DriverWrapper;
import ui.UiRequest;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.*;

public class TrelloTests extends Values {
    @BeforeGroups("ui")
    public void driverSetup() {
        uiRequest = driverWrapper.setUp();
    }

    @BeforeGroups("ui")
    public void login() {
        uiRequest.login();
    }

    @AfterGroups("ui")
    public void close() {
        driverWrapper.close();
    }

    @BeforeGroups({"api", "ui"})
    public void setUp() throws IOException {
        boardId = setUp.createBoard(boardName);
        listId = setUp.createList(listName, boardId);
        cardId = setUp.createCard(listId);
        setUp.addMember(boardId);
        setUp.archiveList(listId);
        labelId = setUp.createLabel(cardId, color);
    }

    @AfterGroups({"api", "ui"})
    public void deleteBoard() throws IOException {
        response.deleteBoard(boardId);
    }

    @Test(priority = 0, groups = {"api"})
    public void deleteMember() throws IOException {
        assertEquals(response.deleteMember(boardId), 200);
    }

    @Test(priority = 1, groups = {"api"})
    public void unArchiveList() throws IOException {
        assertEquals(response.unArchiveList(listId), 200);
    }

    @Test(priority = 2, groups = {"api"})
    public void deleteLabel() throws IOException {
        assertEquals(response.deleteLabel(cardId, labelId), 200);
    }

    @Test(priority = 3, groups = "ui")
    public void deleteMemberUi() {
        assertEquals((uiRequest.deleteMember(boardName)), 1);
    }

    @Test(priority = 4, groups = "ui")
    public void unArchiveListUi() {
        assertEquals((uiRequest.unArchiveListUi()), listName);
    }

    @Test(priority = 5, groups = "ui")
    public void deleteLabelUi() {
        assertFalse(uiRequest.deleteLabelUi(color));
    }
}
