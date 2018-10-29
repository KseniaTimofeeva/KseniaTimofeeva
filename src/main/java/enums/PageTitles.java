package enums;

public enum PageTitles {
    HOME_PAGE("Home Page"),
    DIFFERENT_ELEMENTS("Different Elements"),
    DATES("Dates");

    private String displayName;

    PageTitles(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
