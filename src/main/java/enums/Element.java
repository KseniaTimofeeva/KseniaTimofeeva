package enums;

import com.google.gson.annotations.SerializedName;

public enum Element {
    @SerializedName("Water")
    WATER("Water"),
    @SerializedName("Earth")
    EARTH("Earth"),
    @SerializedName("Wind")
    WIND("Wind"),
    @SerializedName("Fire")
    FIRE("Fire");

    private String displayName;

    Element(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
