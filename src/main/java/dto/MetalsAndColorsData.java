package dto;

import com.epam.commons.DataClass;
import enums.Color;
import enums.Element;
import enums.Metal;
import enums.Vegetable;

import java.util.List;

public class MetalsAndColorsData extends DataClass {

    public List<Integer> summary;
    public List<Element> elements;
    public Color color;
    public Metal metals;
    public List<Vegetable> vegetables;
}
