package utils;

import enums.CheckboxLabels;
import enums.DropdownLabels;
import enums.RadioLabels;

public class LogFactory {

    public static String createLog(Object element, Object value) {
        if (element instanceof CheckboxLabels) {
            return String.format("%s: %s %b", ((CheckboxLabels) element).getDisplayName(), CheckboxLabels.logAction(), value);
        } else if (element instanceof RadioLabels) {
            return String.format("%s: %s %s", RadioLabels.type(), RadioLabels.logAction(), ((RadioLabels) element).getDisplayName());
        } else if (element instanceof DropdownLabels) {
            return String.format("%s: %s %s", DropdownLabels.type(), DropdownLabels.logAction(), ((DropdownLabels) element).getDisplayName());
        } else if (element instanceof String) {
            String el = (String) element;
            switch (el) {
                case "Range 2(From)":
                    return String.format("%s:%d link clicked", el, value);
                case "Range 2(To)":
                    return String.format("%s:%d link clicked", el, value);
                default:
                    throw new UnsupportedOperationException();
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }
}
