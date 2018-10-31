package enums;

public enum Sliders {
    FROM_SLIDER("Range 2(From)"),
    TO_SLIDER("Range 2(To)");

    private String displayName;

    Sliders(String displayName) {
        this.displayName = displayName;
    }
}
