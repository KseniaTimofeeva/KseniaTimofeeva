package pageObjects.hw4.center;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import dto.LogItem;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertTrue;

public class RightSection {

    @FindBy(css = "div[name='log-sidebar']")
    private SelenideElement rightSection;

    @FindBy(css = ".panel-body-list.logs")
    private SelenideElement logsPanel;

    private int uncheckedLogs;
    private int logRowsQty = 0;

    //methods
    public void addLog() {
        uncheckedLogs++;
        logRowsQty++;
    }

    private LogItem parseDisplayedLog(String displayedLogText) {
        String[] excludeDate = displayedLogText.split(" ", 2);
        String[] getElementName = excludeDate[1].split(":");
        String elementName = getElementName[0];
        String value;
        String[] getValue = getElementName[1].split(" ");
        if (getValue[0].matches("^\\d+$")) {
            value = getValue[0];
        } else {
            value = getValue[getValue.length - 1];
        }
        return new LogItem(elementName, value);
    }

    //checks
    @Step
    public void checkRightSectionIsDisplayed() {
        rightSection.shouldBe(Condition.visible);
    }

    @Step
    public void checkLoggedNameAndStatusCorrect(LogItem... logItems) {
        ElementsCollection logRows = logsPanel.$$("li");
        logRows.shouldHaveSize(logRowsQty);

        List<String> logRowsTexts = logRows.texts();
        List<String> actualLogs = logRowsTexts.subList(uncheckedLogs - logItems.length, uncheckedLogs);
        List<LogItem> actualLogItems = actualLogs.stream().map(this::parseDisplayedLog).collect(Collectors.toList());
        List<LogItem> expectedLogItems = Arrays.asList(logItems);
        uncheckedLogs -= expectedLogItems.size();

        assertTrue(expectedLogItems.containsAll(actualLogItems));
    }
}
