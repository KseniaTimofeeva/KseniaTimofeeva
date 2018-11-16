package runners;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

@CucumberOptions(features = "src/test/java/hw6", glue = "pageObjects.hw6")
public class CucumberTestngRunnerHw6 extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public void beforeSuite() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

    @AfterMethod
    public void afterMethod() {
        WebDriverRunner.closeWebDriver();
    }
}
