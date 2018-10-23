package enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ksenia on 22.10.2018.
 */
public enum ServiceOptions {

    SUPPORT("Support"),
    DATES("Dates"),
    COMPLEX_TABLE("Complex Table"),
    SIMPLE_TABLE("Simple Table"),
    TABLES_WITH_WAGES("Tables With Pages"),
    DIFFERENT("Different Elements");

    private String displayName;

    ServiceOptions(String displayName) {
        this.displayName = displayName;
    }

    public static List<String> displayNames() {
        return Arrays.stream(ServiceOptions.values()).map(v -> v.displayName).collect(Collectors.toList());
    }
}
