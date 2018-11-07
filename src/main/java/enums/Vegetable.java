package enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Vegetable {
    @JsonProperty("Cucumber")
    CUCUMBER("Cucumber"),
    @JsonProperty("Tomato")
    TOMATO("Tomato"),
    @JsonProperty("Vegetables")
    VEGETABLES("Vegetables"),
    @JsonProperty("Onion")
    ONION("Onion");

    private String displayName;

    Vegetable(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
