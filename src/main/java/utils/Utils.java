package utils;

import dto.MetalsAndColorsData;
import enums.Element;
import enums.Vegetable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    public static List<String> getExpectedResults(MetalsAndColorsData data) {
        List<String> results = new ArrayList<>();
        results.add("Summary: " + String.valueOf(data.summary.get(0) + data.summary.get(1)));
        results.add("Elements: " + data.elements.stream().map(Element::getDisplayName).collect(Collectors.joining(", ")));
        results.add("Color: " + data.color.getDisplayName());
        results.add("Metal: " + data.metals.getDisplayName());
        results.add("Vegetables: " + data.vegetables.stream().map(Vegetable::getDisplayName).collect(Collectors.joining(", ")));
        return results;
    }
}
