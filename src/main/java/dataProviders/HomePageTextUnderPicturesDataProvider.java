package dataProviders;

import org.testng.annotations.DataProvider;

public class HomePageTextUnderPicturesDataProvider {

    @DataProvider(parallel = true)
    public Object[][] homePageTextUnderPicturesProvider() {

        int textUnderPicturesQty = 4;
        return new Object[][]{
                {"To include good practices\nand ideas from successful\nEPAM project", textUnderPicturesQty},
                {"To be flexible and\ncustomizable", textUnderPicturesQty},
                {"To be multiplatform", textUnderPicturesQty},
                {"Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…", textUnderPicturesQty}
        };
    }
}
