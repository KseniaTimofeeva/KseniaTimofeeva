package hw8;

import dataProviders.MetalsAndColorsDataProvider;
import dto.MetalsAndColorsData;
import dto.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static enums.HeaderMenuItem.METALS_AND_COLORS;
import static pageObjects.JDIsite.JDISite.checkResultSectionContainsData;
import static pageObjects.JDIsite.JDISite.chooseHeaderMenu;
import static pageObjects.JDIsite.JDISite.homePage;
import static pageObjects.JDIsite.JDISite.login;
import static pageObjects.JDIsite.JDISite.metalAndColorsPage;

public class MetalAndColorsPageTest extends MetalAndColorsPageInit {

    @AfterMethod
    public static void afterMethod() {
        homePage.clearCache();
    }

    @Test(dataProvider = "metalsAndColorsDataProvider", dataProviderClass = MetalsAndColorsDataProvider.class)
    public void metalAndColorsFormTest(MetalsAndColorsData data) {

        //1 Login on JDI site as User
        homePage.open();
        homePage.checkOpened();
        login(new User());

        //2 Open Metals & Colors page by Header menu
        chooseHeaderMenu(METALS_AND_COLORS);
        metalAndColorsPage.checkOpened();

        //3 Fill form Metals & Colors by data
        //Submit form Metals & Colors
        metalAndColorsPage.metalsAndColorsForm.fill(data);
        metalAndColorsPage.metalsAndColorsForm.submit();

        //4 Result sections should contains data
        checkResultSectionContainsData(data);
    }
}
