package hw1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.System.setProperty;

public class HomePageContentSuiteSoft {

    private List<String> headerElementsText = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");

    private List<String> imagesText = Arrays.asList("To include good practices\nand ideas from successful\nEPAM project",
            "To be flexible and\ncustomizable",
            "To be multiplatform",
            "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

    private String mainText = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, " +
            "SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. " +
            "UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS " +
            "NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN " +
            "REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";


    @Test
    public void homePageContentTest() {

        setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        SoftAssert softAssert = new SoftAssert();

        //0 Open Browser
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //1 Open test site
        driver.navigate().to("https://epam.github.io/JDI/");

        //2 Assert Browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        //3 Login
        driver.findElement(By.cssSelector(".profile-photo")).click();
        driver.findElement(By.cssSelector("[id = 'Name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id = 'Password']")).sendKeys("1234");
        driver.findElement(By.cssSelector(".login [type = 'submit']")).click();

        //4 Assert User name that user is loggined
        softAssert.assertEquals(driver.findElement(By.cssSelector(".profile-photo [ui = 'label']")).getText(), "PITER CHAILOVSKII");

        //5 Assert Browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        //6 Assert that 4 items on the header section are displayed and they have proper texts
        List<WebElement> headerElements = driver.findElements(By.cssSelector("ul.uui-navigation.nav > li > a"));

        softAssert.assertEquals(headerElements.size(), 4);

        for (WebElement element : headerElements) {
            softAssert.assertTrue(element.isDisplayed());
            softAssert.assertTrue(headerElementsText.contains(element.getText()));
        }

        //7 Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> images = driver.findElements(By.cssSelector("span.icons-benefit"));

        softAssert.assertEquals(images.size(), 4);

        for (WebElement image : images) {
            softAssert.assertTrue(image.isDisplayed());
        }

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> textUnderImages = driver.findElements(By.cssSelector("div.benefit-icon+span"));

        softAssert.assertEquals(textUnderImages.size(), 4);

        for (WebElement text : textUnderImages) {
            softAssert.assertTrue(text.isDisplayed());
            softAssert.assertTrue(imagesText.contains(text.getText()));
        }

        //9 Assert text of the main header
        softAssert.assertEquals(driver.findElement(By.cssSelector("h3.main-title")).getText(), "EPAM FRAMEWORK WISHES…");
        softAssert.assertEquals(driver.findElement(By.cssSelector("p.main-txt")).getText(), mainText);

        //10 Assert iframe
        WebElement iframe = driver.findElement(By.cssSelector("iframe"));
        softAssert.assertTrue(iframe.isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo
        driver.switchTo().frame(iframe);
        softAssert.assertTrue(driver.findElement(By.cssSelector("[id = epam_logo]")).isDisplayed());

        //12 Switch to original window
        driver.switchTo().defaultContent();

        //13 Assert a text of the sub header
        softAssert.assertEquals(driver.findElement(By.cssSelector("div.main-content > h3 > a")).getText(), "JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        WebElement subHeaderLink = driver.findElement(By.linkText("JDI GITHUB"));
        softAssert.assertTrue(subHeaderLink.isDisplayed());
        softAssert.assertEquals(subHeaderLink.getAttribute("href"), "https://github.com/epam/JDI");


        //15 Assert left section
        softAssert.assertTrue(driver.findElement(By.cssSelector("div.uui-side-bar")).isDisplayed());

        //16 Assert footer
        softAssert.assertTrue(driver.findElement(By.cssSelector("footer")).isDisplayed());

        //17 Close BR
        driver.close();
    }
}
