package hw4;

import base.Hw4TestBase;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import listeners.AllureAttachmentListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.hw4.DifferentElements;
import pageObjects.hw4.HomePage;

import static enums.Color.YELLOW;
import static enums.Element.WATER;
import static enums.Element.WIND;
import static enums.Metal.SELEN;
import static enums.PageTitles.DIFFERENT_ELEMENTS;
import static enums.PageTitles.HOME_PAGE;
import static enums.Users.PITER_CHAILOVSKII;

@Feature("Smoke tests")
@Story("Service page interface testing")
@Listeners(AllureAttachmentListener.class)
public class ServicePageInterfaceSuite extends Hw4TestBase {

    private HomePage homePage;
    private DifferentElements differentElements;

    @BeforeClass
    public void beforeClass() {
        homePage = Selenide.page(HomePage.class);
        differentElements = Selenide.page(DifferentElements.class);
    }

    @Test
    public void servicePageInterfaceTest() {

        //1 Open test JDIsite by URL
        homePage.openPage();

        //2 Assert Browser title
        homePage.checkTitle(HOME_PAGE);

        //3 Perform login
        homePage.login(PITER_CHAILOVSKII);

        //4 Assert User name that user is logged
        homePage.checkUserIsLogged(PITER_CHAILOVSKII);

        //5 Click on "Service" in the header and check that drop down contains options
        homePage.chooseHeaderServiceCategory();
        homePage.checkHeaderServiceOptions();

        //6 Click on "Service" in the left section and check that drop down contains options
        homePage.chooseLeftServiceCategory();
        homePage.checkLeftServiceOptions();

        //7 Open through the header menu Service -> Different Element Page
        homePage.chooseHeaderServiceCategory();
        homePage.chooseServiceDifferentElementsOption();
        differentElements.checkTitle(DIFFERENT_ELEMENTS);

        //8 Check interface on Different elements page, it contains all needed elements
        differentElements.checkCheckboxesExist();
        differentElements.checkRadiosExist();
        differentElements.checkDropdownExist();
        differentElements.checkButtonsExist();

        //9 Assert that there is Right Section
        differentElements.checkRightSectionIsDisplayed();

        //10 Assert that there is Left Section
        differentElements.checkLeftSectionIsDisplayed();

        //11 Select checkboxes
        differentElements.selectCheckbox(WATER, WIND);
        differentElements.checkCheckboxIsChecked(WATER, WIND);

        //12 Assert that for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox
        differentElements.checkLoggedNameAndStatusCorrect(WATER, true);
        differentElements.checkLoggedNameAndStatusCorrect(WIND, true);

        //13 Select radio
        differentElements.selectRadio(SELEN);
        differentElements.checkRadioIsChecked(SELEN);

        //14 Assert that for radiobutton there is a log row
        // and value is corresponded to the status of radiobutton
        differentElements.checkLoggedNameAndStatusCorrect(SELEN);

        //15 Select in dropdown
        differentElements.selectInDropdown(YELLOW);
        differentElements.checkDropdownIsSelected(YELLOW);

        //16 Assert that for dropdown there is a log row
        // and value is corresponded to the selected value
        differentElements.checkLoggedNameAndStatusCorrect(YELLOW);

        //17 Unselect and assert checkboxes
        differentElements.selectCheckbox(WATER, WIND);
        differentElements.checkCheckboxIsUnchecked(WATER, WIND);

        //18 Assert that for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox
        differentElements.checkLoggedNameAndStatusCorrect(WATER, false);
        differentElements.checkLoggedNameAndStatusCorrect(WIND, false);
    }
}
