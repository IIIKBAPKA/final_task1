package ui;

import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class UiRequest {
    WebDriver driver;
    private By memberInitials = By.cssSelector("a span.member-initials");

    public UiRequest(WebDriver driver) {
        this.driver = driver;
    }

    public void login() {

        driver.get("https://trello.com/");
        $("div a[href='/login']").click();
        $("#google-link").click();
        $("#identifierId").sendKeys("final.group005@gmail.com", Keys.ENTER);
        WebDriverWait wait1 = new WebDriverWait(driver, 10);
        WebElement element = wait1.until(ExpectedConditions.elementToBeClickable($("div input[name='password']")));
        element.sendKeys("1Qwerty7", Keys.ENTER);
    }

    @Step("Delete member from board")
    public int deleteMember(String boardName) {
        WebElement board = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable($("div[title='" + boardName + "']")));
        board.click();
        $("span[title$='(user95411438)']").click();
        $("a.js-remove-member").click();
        $("input.js-confirm").click();
        List<WebElement> elements = driver.findElements(memberInitials);
        return elements.size();
    }

    @Step("unArchive List")
    public String unArchiveListUi() {
        $("a.js-open-more").click();
        $("a.js-open-archive").click();
        $("a.js-switch-section").click();
        $(".button-link").click();
        return $("textarea.list-header-name").getText();
    }

    @Step("Delete label from card")
    public boolean deleteLabelUi(String color) {
        Actions actions = new Actions(driver);
        WebElement elementLocator = $("div.js-card-details");
        actions.contextClick(elementLocator).perform();
        $("a.js-edit-labels").click();
        $("span.active.card-label-" + color).click();
        $("input.js-save-edits").click();
        return $("span.card-label-" + color).exists();
    }
}
