package enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Metal {
    @JsonProperty("Gold")
    GOLD("Gold"),
    @JsonProperty("Silver")
    SILVER("Silver"),
    @JsonProperty("Bronze")
    BRONZE("Bronze"),
    @JsonProperty("Selen")
    SELEN("Selen");

    private String displayName;

    Metal(String displayName) {
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
