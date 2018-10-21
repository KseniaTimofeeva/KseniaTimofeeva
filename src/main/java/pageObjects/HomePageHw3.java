package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageHw3 {

    @FindBy(css = ".profile-photo")
    private WebElement profilePhoto;

    @FindBy(css = "[id = 'Name']")
    private WebElement loginField;

    @FindBy(css = "[id = 'Password']")
    private WebElement passwordField;

    @FindBy(css = ".login [type = 'submit']")
    private WebElement enterButton;

    @FindBy(css = ".profile-photo [ui = 'label']")
    private WebElement userName;

    @FindBy(css = "ul.uui-navigation.nav > li > a")
    private List<WebElement> headerElements;

    @FindBy(css = "span.icons-benefit")
    private List<WebElement> images;

    @FindBy(css = "div.benefit-icon+span")
    private List<WebElement> textUnderImages;

    @FindBy(css = "h3.main-title")
    private WebElement mainTitle;

    @FindBy(css = "p.main-txt")
    private WebElement mainTextElement;

    @FindBy(css = "iframe")
    private WebElement iframe;

    @FindBy(css = "[id = epam_logo]")
    private WebElement logo;

    @FindBy(css = ".main-content > h3 > a")
    private WebElement subHeader;

    @FindBy(css = "div.uui-side-bar")
    private WebElement leftSection;

    @FindBy(css = "footer")
    private WebElement footer;


    //methods
    public void open(WebDriver driver) {
        driver.navigate().to("https://epam.github.io/JDI/");
    }

    public void login(String login, String password) {
        profilePhoto.click();
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        enterButton.click();
    }

    public void switchToIframe(WebDriver driver) {
        driver.switchTo().frame(iframe);
    }

    public void switchToOriginalWindow(WebDriver driver) {
        driver.switchTo().defaultContent();
    }


    //checks
    public void checkTitle(WebDriver driver) {
        assertEquals(driver.getTitle(), "Home Page");
    }

    public void checkUserIsLoggined(String expectedUsername) {
        assertEquals(userName.getText(), expectedUsername);
    }

    public void checkHeaderElements(List<String> expTexts) {
        assertEquals(headerElements.size(), expTexts.size());

        for (WebElement element : headerElements) {
            assertTrue(element.isDisplayed());
            assertTrue(expTexts.contains(element.getText()));
        }
    }

    public void checkImages(int expQty) {
        assertEquals(images.size(), expQty);

        for (WebElement image : images) {
            assertTrue(image.isDisplayed());
        }
    }

    public void checkTextsUnderIcons(List<String> expTexts) {
        assertEquals(textUnderImages.size(), expTexts.size());

        for (WebElement text : textUnderImages) {
            assertTrue(text.isDisplayed());
            assertTrue(expTexts.contains(text.getText()));
        }
    }

    public void checkMainHeader(String mainTitleText, String mainText) {
        assertEquals(mainTitle.getText(), mainTitleText);
        assertEquals(mainTextElement.getText(), mainText);
    }

    public void checkIframe() {
        assertTrue(iframe.isDisplayed());
    }

    public void checkLogo() {
        assertTrue(logo.isDisplayed());
    }

    public void checkSubHeader() {
        assertEquals(subHeader.getText(), "JDI GITHUB");
    }

    public void checkLeftSection() {
        assertTrue(leftSection.isDisplayed());
    }

    public void checkLink(WebDriver driver, String linkText, String href) {
        WebElement linkElement = driver.findElement(By.cssSelector("a[href='" + href + "']"));

        assertTrue(linkElement.isDisplayed());
        assertEquals(linkElement.getText(), linkText);
    }

    public void checkFooter() {
        assertTrue(footer.isDisplayed());
    }

}
