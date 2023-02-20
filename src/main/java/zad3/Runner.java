package zad3;

import java.util.*;
import java.util.stream.Collectors;


public class Runner {
    public static void main(String[] args) {

        List<Integer> integerList1 = List.of(3, 65, 34, 678, 234, 54, 12, 5677, 7987);
        List<Integer> integerList2 = List.of(3, 65, 34, 4);
        List<Integer> integerList3 = new ArrayList<>();
        integerList3.add(2);
        integerList3.add(2345);
        integerList3.add(435);
        integerList3.add(null);
        integerList3.add(37);
        integerList3.add(36);
        System.out.println(getFiveHighestValues(integerList1));
        System.out.println(getFiveHighestValues(integerList2));
        System.out.println(getFiveHighestValues(null));
        System.out.println(getFiveHighestValues(integerList3));

    }

    static List<Integer> getFiveHighestValues(List<Integer> integerList) {
        return Optional.ofNullable(integerList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter( x -> integerList.size() > 5)
                .sorted(Comparator.comparingInt(Integer::intValue).reversed())
                .limit(5)
                .collect(Collectors.toList());
    }
}
