package enums;

public enum CheckboxLabels {
    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire");

    private String displayName;

    CheckboxLabels(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static String logAction() {
        return "condition changed to";
    }
}
