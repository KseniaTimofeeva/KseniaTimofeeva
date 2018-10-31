package hw4;

import base.Hw4TestBase;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.hw4.Dates;
import pageObjects.hw4.HomePage;

import static enums.PageTitles.DATES;
import static enums.PageTitles.HOME_PAGE;
import static enums.Users.PITER_CHAILOVSKII;

public class DatesPageSlidersSuite extends Hw4TestBase {

    private HomePage homePage;
    private Dates dates;

    @BeforeClass
    public void beforeClass() {
        homePage = Selenide.page(HomePage.class);
        dates = Selenide.page(Dates.class);
    }

    @Test
    public void datesPageSlidersTest() {

        //1 Open test site by URL
        homePage.openPage();

        //2 Assert Browser title
        homePage.checkTitle(HOME_PAGE);

        //3 Perform login
        homePage.login(PITER_CHAILOVSKII);

        //4 Assert User name that user is loggined
        homePage.checkUserIsLogged(PITER_CHAILOVSKII);

        //5 Open through the header menu Service -> Dates Page
        homePage.chooseHeaderServiceCategory();
        homePage.chooseServiceDatesOption();
        dates.checkTitle(DATES);

        //6 Set Range sliders.
        // left slider - the most left position,
        // right slider - the most rigth position
        dates.setSliders(0, 100);

        //7 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        dates.checkSlidersLoggedNameAndStatusCorrect(0, 100);

        //8 Set Range sliders.
        // left sliders - the most left position,
        // right slider - the most left position
        dates.setSliders(0, 0);

        //9 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        dates.checkSlidersLoggedNameAndStatusCorrect(0, 0);

        //10 Set Range sliders.
        // left sliders - the most rigth position,
        // right slider - the most rigth position
        dates.setSliders(100, 100);

        //11 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        dates.checkSlidersLoggedNameAndStatusCorrect(100, 100);

        //12 Set Range sliders
        dates.setSliders(30, 70);

        //13 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        dates.checkSlidersLoggedNameAndStatusCorrect(30, 70);
    }
}
