package hw2.ex1;

import dataProviders.HomePageTextUnderPicturesDataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class HomePageTextDataProviderTest {

    @Test(dataProvider = "homePageTextUnderPicturesProvider", dataProviderClass = HomePageTextUnderPicturesDataProvider.class)
    public void textUnderPicturesTest(String text) {

        //1 Open BR
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //2 Navigate
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //3 Assert 4 texts below 4 pictures
        WebElement textElement = driver.findElement(
                By.xpath("//div[@class='benefit']/span[@class='benefit-txt' and contains(normalize-space(), '"
                        + text.replaceAll("\n", "") + "')]"));

        assertEquals(textElement.getText(), text);

        //4 Close BR
        driver.close();
    }
}
