package enums;

public enum RadioLabels {
    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");

    private String displayName;

    RadioLabels(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static String type() {
        return "metal";
    }

    public static String logAction() {
        return "value changed to";
    }
}
