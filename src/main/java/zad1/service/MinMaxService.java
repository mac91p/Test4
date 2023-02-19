package zad1.service;

import zad1.model.MinMax;

import java.util.List;

public class MinMaxService<T> {

    public static <T extends Comparable> MinMax getMinMax(List<T> elements) {
        return new MinMax(getMin(elements), getMax(elements));

    }

    private static <T extends Comparable<T>> T getMin(List<T> elements) {
        T min = null;
        for (T element : elements) {
            if (min == null) {
                min = element;
                continue;
            }
            if (element.compareTo(min) < 0) {
                min = element;
            }
        }
        return min;
    }


    private static <T extends Comparable<T>> T getMax(List<T> elements) {
        T max = null;
        for (T element : elements) {
            if (max == null) {
                max = element;
                continue;
            }
            if (element.compareTo(max) > 0) {
                max = element;
            }
        }
        return max;
    }


}
