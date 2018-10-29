package hw4;

import base.Hw4TestBase;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import enums.CheckboxLabels;
import enums.DropdownLabels;
import enums.PageTitles;
import enums.RadioLabels;
import enums.Users;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.hw4.BasePage;
import pageObjects.hw4.ServiceDiffElementsPage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.System.setProperty;

public class ServicePageInterfaceSuite extends Hw4TestBase {

    private BasePage basePage;
    private ServiceDiffElementsPage serviceDiffElPage;
    private List<CheckboxLabels> testCheckboxes = Arrays.asList(CheckboxLabels.WATER, CheckboxLabels.WIND);
    private List<RadioLabels> testRadios = Collections.singletonList(RadioLabels.SELEN);
    private DropdownLabels testDropdown = DropdownLabels.YELLOW;

    @BeforeClass
    public void beforeClass() {
        setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        Configuration.startMaximized = true;
        basePage = Selenide.page(BasePage.class);
        serviceDiffElPage = Selenide.page(ServiceDiffElementsPage.class);
    }

    @Test
    public void servicePageInterfaceTest() {

        //1 Open test site by URL
        basePage.openPage();

        //2 Assert Browser title
        basePage.checkTitle(PageTitles.HOME_PAGE);

        //3 Perform login
        basePage.login(Users.PITER_CHAILOVSKII);

        //4 Assert User name that user is loggined
        basePage.checkUserIsLoggined(Users.PITER_CHAILOVSKII);

        //5 Click on "Service" in the header and check that drop down contains options
        basePage.checkHeaderServiceOptions();

        //6 Click on Service in the left section and check that drop down contains options
        basePage.chooseHeaderServiceCategory();
        basePage.checkLeftServiceOptions();

        //7 Open through the header menu Service -> Different Elements Page
        basePage.chooseHeaderServiceCategory();
        basePage.chooseServiceDifferentElementsOption();
        basePage.checkTitle(PageTitles.DIFFERENT_ELEMENTS);

        //8 Check interface on Different elements page, it contains all needed elements
        serviceDiffElPage.checkCheckboxesExist();
        serviceDiffElPage.checkRadiosExist();
        serviceDiffElPage.checkDropdownExist();
        serviceDiffElPage.checkButtonsExist();

        //9 Assert that there is Right Section
        serviceDiffElPage.checkRightSectionIsDisplayed();

        //10 Assert that there is Left Section
        basePage.checkLeftSectionIsDisplayed();

        //11 Select checkboxes
        for (CheckboxLabels checkbox : testCheckboxes) {
            serviceDiffElPage.selectCheckbox(checkbox);
            serviceDiffElPage.checkCheckboxIsChecked(checkbox);
        }

        //12 Assert that for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox
        serviceDiffElPage.checkLogRowsDisplayed();
        serviceDiffElPage.checkLoggedNameAndStatusCorrect();

        //13 Select radio
        for (RadioLabels radio : testRadios) {
            serviceDiffElPage.selectRadio(radio);
            serviceDiffElPage.checkRadioIsChecked(radio);
        }

        //14 Assert that for radiobutton there is a log row
        // and value is corresponded to the status of radiobutton
        serviceDiffElPage.checkLogRowsDisplayed();
        serviceDiffElPage.checkLoggedNameAndStatusCorrect();

        //15 Select in dropdown
        serviceDiffElPage.selectInDropdown(testDropdown);
        serviceDiffElPage.checkDropdownIsSelected(testDropdown);

        //16 Assert that for dropdown there is a log row
        // and value is corresponded to the selected value
        serviceDiffElPage.checkLogRowsDisplayed();
        serviceDiffElPage.checkLoggedNameAndStatusCorrect();

        //17 Unselect and assert checkboxes
        for (CheckboxLabels checkbox : testCheckboxes) {
            serviceDiffElPage.selectCheckbox(checkbox);
            serviceDiffElPage.checkCheckboxIsUnchecked(checkbox);
        }

        //18 Assert that for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox
        serviceDiffElPage.checkLogRowsDisplayed();
        serviceDiffElPage.checkLoggedNameAndStatusCorrect();
    }
}
