package enums;

import com.google.gson.annotations.SerializedName;

public enum Vegetable {
    @SerializedName("Cucumber")
    CUCUMBER("Cucumber"),
    @SerializedName("Tomato")
    TOMATO("Tomato"),
    @SerializedName("Vegetables")
    VEGETABLES("Vegetables"),
    @SerializedName("Onion")
    ONION("Onion");

    private String displayName;

    Vegetable(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
