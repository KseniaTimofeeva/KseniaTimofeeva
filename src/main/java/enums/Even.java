package enums;

import java.util.stream.Stream;

public enum Even {

    TWO(2),
    FOUR(4),
    SIX(6),
    EIGHT(8);

    public int value;

    Even(int value) {
        this.value = value;
    }

    public static Even getByValue(int value) {
        return Stream.of(Even.values()).filter(e -> e.value == value).findFirst().orElseThrow(RuntimeException::new);
    }
}
