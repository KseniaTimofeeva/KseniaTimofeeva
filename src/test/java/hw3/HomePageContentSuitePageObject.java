package hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePageHw3;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.System.setProperty;

public class HomePageContentSuitePageObject {

    private List<String> headerElementsText = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");

    private List<String> imagesText = Arrays.asList("To include good practices\nand ideas from successful\nEPAM project",
            "To be flexible and\ncustomizable",
            "To be multiplatform",
            "Already have good commonElements\n(about 20 internal and\nsome external projects),\nwish to get more…");

    private String mainText = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, " +
            "SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. " +
            "UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS " +
            "NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN " +
            "REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";

    private WebDriver driver;
    private HomePageHw3 homePage;

    @BeforeClass
    public void beforeClass() {
        setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        homePage = PageFactory.initElements(driver, HomePageHw3.class);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }


    @Test
    public void homePageContentTest() {

        //1 Open test JDIsite
        homePage.open(driver);

        //2 Assert Browser title
        homePage.checkTitle(driver);

        //3 Login
        homePage.login("epam", "1234");

        //4 Assert User name that user is loggined
        homePage.checkUserIsLoggined("PITER CHAILOVSKII");

        //5 Assert Browser title
        homePage.checkTitle(driver);

        //6 Assert that 4 items on the header section are displayed and they have proper texts
        homePage.checkHeaderElements(headerElementsText);

        //7 Assert that there are 4 images on the Index Page and they are displayed
        homePage.checkImages(4);

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        homePage.checkTextsUnderIcons(imagesText);

        //9 Assert text of the main
        homePage.checkMainHeader("EPAM FRAMEWORK WISHES…", mainText);

        //10 Assert iframe
        homePage.checkIframe();

        //11 Switch to the iframe and check that there is Epam logo
        homePage.switchToIframe(driver);
        homePage.checkLogo();

        //12 Switch to original window
        homePage.switchToOriginalWindow(driver);

        //13 Assert a text of the sub header
        homePage.checkSubHeader();

        //14 Assert that JDI GITHUB is a link and has a proper URL
        homePage.checkLink(driver, "JDI GITHUB", "https://github.com/epam/JDI");

        //15 Assert left section
        homePage.checkLeftSection();

        //16 Assert footer
        homePage.checkFooter();
    }

}
