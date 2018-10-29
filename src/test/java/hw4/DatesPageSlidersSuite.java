package hw4;

import base.Hw4TestBase;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import enums.PageTitles;
import enums.Users;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.hw4.BasePage;
import pageObjects.hw4.DatesPage;

import static java.lang.System.setProperty;

public class DatesPageSlidersSuite extends Hw4TestBase {

    private BasePage basePage;
    private DatesPage datesPage;

    @BeforeClass
    public void beforeClass() {
        setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        Configuration.startMaximized = true;
        basePage = Selenide.page(BasePage.class);
        datesPage = Selenide.page(DatesPage.class);
    }

    @Test
    public void datesPageSlidersTest() {

        //1 Open test site by URL
        basePage.openPage();

        //2 Assert Browser title
        basePage.checkTitle(PageTitles.HOME_PAGE);

        //3 Perform login
        basePage.login(Users.PITER_CHAILOVSKII);

        //4 Assert User name that user is loggined
        basePage.checkUserIsLoggined(Users.PITER_CHAILOVSKII);

        //5 Open through the header menu Service -> Dates Page
        basePage.chooseHeaderServiceCategory();
        basePage.chooseServiceDatesOption();
        basePage.checkTitle(PageTitles.DATES);

        //6 Set Range sliders.
        // left slider - the most left position,
        // right slider - the most rigth position
        datesPage.setSliders(0, 100);

        //7 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogRowsDisplayed();
        datesPage.checkLoggedNameAndStatusCorrect();

        //8 Set Range sliders.
        // left sliders - the most left position,
        // right slider - the most left position
        datesPage.setSliders(0, 0);

        //9 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogRowsDisplayed();
        datesPage.checkLoggedNameAndStatusCorrect();

        //10 Set Range sliders.
        // left sliders - the most rigth position,
        // right slider - the most rigth position
        datesPage.setSliders(100, 100);

        //11 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogRowsDisplayed();
        datesPage.checkLoggedNameAndStatusCorrect();

        //12 Set Range sliders
        datesPage.setSliders(30, 70);

        //13 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogRowsDisplayed();
        datesPage.checkLoggedNameAndStatusCorrect();

    }

}
