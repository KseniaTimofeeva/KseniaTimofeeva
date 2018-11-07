package enums;

import java.util.stream.Stream;

public enum Odd {
    ONE(1),
    THREE(3),
    FIVE(5),
    SEVEN(7);

    public int value;

    Odd(int value) {
        this.value = value;
    }

    public static Odd getByValue(int value) {
        return Stream.of(Odd.values()).filter(e -> e.value == value).findFirst().orElseThrow(RuntimeException::new);
    }
}
