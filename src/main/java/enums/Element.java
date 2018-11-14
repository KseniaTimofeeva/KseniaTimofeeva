package enums;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public static List<Element> getListByNames(List<String> names) {
        return Stream.of(Element.values()).filter(e -> names.contains(e.displayName)).collect(Collectors.toList());
    }

    public static Element getByName(String name) {
        return Stream.of(Element.values()).filter(e -> e.displayName.equals(name)).findFirst().orElseThrow(RuntimeException::new);
    }

}
