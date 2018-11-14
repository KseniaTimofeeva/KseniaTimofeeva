package enums;

import com.google.gson.annotations.SerializedName;

import java.util.stream.Stream;

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

    public static Metal getByName(String name) {
        return Stream.of(Metal.values()).filter(e -> e.displayName.equals(name)).findFirst().orElseThrow(RuntimeException::new);
    }

}
