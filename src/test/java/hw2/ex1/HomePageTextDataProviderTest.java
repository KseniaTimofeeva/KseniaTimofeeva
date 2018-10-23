package hw2.ex1;

import dataProviders.HomePageTextUnderPicturesDataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageTextDataProviderTest {

    @Test(dataProvider = "homePageTextUnderPicturesProvider", dataProviderClass = HomePageTextUnderPicturesDataProvider.class)
    public void textUnderPicturesTest(String text, int qty) {

        //1 Open BR
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //2 Navigate
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //3 Assert 4 texts below 4 pictures
        List<WebElement> textUnderImages = driver.findElements(By.cssSelector("div.benefit-icon+span"));
        List<String> stringTextUnderImages = textUnderImages.stream().map(WebElement::getText).collect(Collectors.toList());
        assertEquals(textUnderImages.size(), qty);
        assertTrue(stringTextUnderImages.contains(text));

        //4 Close BR
        driver.close();
    }
}
