package enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Element {
    @JsonProperty("Water")
    WATER("Water"),
    @JsonProperty("Earth")
    EARTH("Earth"),
    @JsonProperty("Wind")
    WIND("Wind"),
    @JsonProperty("Fire")
    FIRE("Fire");

    private String displayName;

    Element(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
