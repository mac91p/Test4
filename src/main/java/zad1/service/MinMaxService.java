package zad1.service;

import zad1.model.MinMax;

import java.util.*;

public class MinMaxService<T> {

    public static <T extends Comparable> MinMax getMinMax(List<T> elements) {
        return new MinMax(getMin(elements), getMax(elements));

    }

    private static <T extends Comparable<T>> T getMin(List<T> elements) {
        return Optional.ofNullable(elements)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .min(Comparator.naturalOrder())
                .orElse(null);
    }

    private static <T extends Comparable<T>> T getMax(List<T> elements) {
        return Optional.ofNullable(elements)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.naturalOrder())
                .orElse(null);
    }


}
