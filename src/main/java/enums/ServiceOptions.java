package enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ksenia on 22.10.2018.
 */
public enum ServiceOptions {

    SUPPORT("Support"),
    DATES("Dates"),
    COMPLEX_TABLE("Complex Table"),
    SIMPLE_TABLE("Simple Table"),
    USER_TABLE("User Table"),
    TABLE_WITH_PAGES("Table With Pages"),
    DIFFERENT_ELEMENTS("Different Elements"),
    PERFORMANCE("Performance");

    private String displayName;

    ServiceOptions(String displayName) {
        this.displayName = displayName;
    }

    public static List<String> displayNames() {
        return Arrays.stream(ServiceOptions.values()).map(v -> v.displayName).collect(Collectors.toList());
    }

    public static List<String> upperDisplayNames() {
        return Arrays.stream(ServiceOptions.values()).map(v -> v.displayName.toUpperCase()).collect(Collectors.toList());
    }

    public static ServiceOptions getByName(String name) {
        return Stream.of(ServiceOptions.values()).filter(e -> e.displayName.equals(name)).findFirst().orElseThrow(RuntimeException::new);
    }
}
