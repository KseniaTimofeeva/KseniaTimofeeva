package pageObjects.hw4;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RightPanel {

    @FindBy(css = "div[name='log-sidebar']")
    private SelenideElement rightSection;

    @FindBy(css = ".panel-body-list.logs")
    private SelenideElement logsPanel;


    //methods
    private List<String> parseDisplayedLog() {
        ElementsCollection displayedLogRows = logsPanel.$$("li");
        List<String> displayedLogTexts = displayedLogRows.texts();
        return displayedLogTexts.stream().map(x -> (x.split(" ", 2))[1]).collect(Collectors.toList());
    }


    //checks
    public void checkRightSectionIsDisplayed() {
        rightSection.shouldBe(Condition.visible);
    }

    public void checkLogRowsDisplayed(List<String> clickLog) {
        ElementsCollection logRows = logsPanel.$$("li");
        logRows.shouldHaveSize(clickLog.size());
        for (SelenideElement row : logRows) {
            row.shouldBe(Condition.visible);
        }
    }

    public void checkLoggedNameAndStatusCorrect(List<String> clickLog) {
        List<String> displayedLog = parseDisplayedLog();
        Collections.reverse(displayedLog);
        Assert.assertEquals(displayedLog, clickLog);
    }
}
