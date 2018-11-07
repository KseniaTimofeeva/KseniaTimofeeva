package enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Color {
    @JsonProperty("Red")
    RED("Red"),
    @JsonProperty("Green")
    GREEN("Green"),
    @JsonProperty("Blue")
    BLUE("Blue"),
    @JsonProperty("Yellow")
    YELLOW("Yellow");

    private String displayName;


    Color(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static String type() {
        return "Colors";
    }
}
