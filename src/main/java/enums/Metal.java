package enums;

import com.google.gson.annotations.SerializedName;

public enum Metal {
    @SerializedName("Gold")
    GOLD("Gold"),
    @SerializedName("Silver")
    SILVER("Silver"),
    @SerializedName("Bronze")
    BRONZE("Bronze"),
    @SerializedName("Selen")
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
