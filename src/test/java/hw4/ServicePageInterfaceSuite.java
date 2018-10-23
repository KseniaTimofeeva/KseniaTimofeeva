package hw4;

import base.Hw4TestBase;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import enums.PageTitles;
import enums.Users;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.hw4.BasePageHw4;
import pageObjects.hw4.ServiceDifferentElementsPageHw4;

import static java.lang.System.setProperty;

public class ServicePageInterfaceSuite extends Hw4TestBase {

    private BasePageHw4 basePage;
    private ServiceDifferentElementsPageHw4 serviceDiffElPage;

    @BeforeClass
    public void beforeClass() {
        setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        Configuration.startMaximized = true;
        basePage = Selenide.page(BasePageHw4.class);
        serviceDiffElPage = Selenide.page(ServiceDifferentElementsPageHw4.class);
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
//        basePage.checkHeaderServiceOptions();

        //6 Click on Service in the left section and check that drop down contains options
//        basePage.chooseHeaderServiceCategory();
//        basePage.checkLeftServiceOptions();

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


    }
}
