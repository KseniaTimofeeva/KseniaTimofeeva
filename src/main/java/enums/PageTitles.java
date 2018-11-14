package enums;

public enum PageTitles {
    HOME_PAGE("Home Page"),
    DIFFERENT_ELEMENTS("Different Elements"),
    DATES("Dates"),
    USER_TABLE("User Table");

    private String displayName;

    PageTitles(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return "'" + displayName + "'";
    }
}
