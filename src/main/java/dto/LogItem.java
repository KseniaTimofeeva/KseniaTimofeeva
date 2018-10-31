package dto;

public class LogItem {

    private String element;
    private String value;

    public LogItem(String element, String value) {
        this.element = element;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LogItem logItem = (LogItem) o;

        if (element != null ? !element.equals(logItem.element) : logItem.element != null) return false;
        return value != null ? value.equals(logItem.value) : logItem.value == null;
    }

    @Override
    public int hashCode() {
        int result = element != null ? element.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
