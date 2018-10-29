package enums;

public enum DropdownLabels {
    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow");

    private String displayName;


    DropdownLabels(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static String type() {
        return "Colors";
    }

    public static String logAction() {
        return "value changed to";
    }
}
