package hw8;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import org.testng.annotations.BeforeSuite;
import pageObjects.JDIsite.JDISite;

public class MetalAndColorsPageInit extends TestNGBase {

    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        WebSite.init(JDISite.class);
    }
}
