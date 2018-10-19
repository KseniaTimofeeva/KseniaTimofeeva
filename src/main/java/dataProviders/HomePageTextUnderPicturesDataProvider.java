package dataProviders;

import org.testng.annotations.DataProvider;

public class HomePageTextUnderPicturesDataProvider {

    @DataProvider(parallel = true)
    public Object[][] homePageTextUnderPicturesProvider() {
        return new Object[][]{
                {"To include good practices\nand ideas from successful\nEPAM project"},
                {"To be flexible and\ncustomizable"},
                {"To be multiplatform"},
                {"Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"}
        };
    }
}
