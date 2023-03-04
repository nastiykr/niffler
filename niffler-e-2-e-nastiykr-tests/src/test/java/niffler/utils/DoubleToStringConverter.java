package niffler.utils;

public class DoubleToStringConverter {
    public static String convert(Double value) {
        if (value % 1.0 != 0)
            return String.format("%s", value);
        else
            return String.format("%.0f", value);
    }
}
