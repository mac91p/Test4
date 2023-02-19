package zad3;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class Runner {
    public static void main(String[] args) {

        List<Integer> integerList1 = List.of(3, 65, 34, 678, 234, 54, 12, 5677, 7987);
        List<Integer> integerList2 = List.of(3, 65, 34, 678);
        System.out.println(getFiveHighestValues(integerList1));
        System.out.println(getFiveHighestValues(integerList2));
        System.out.println(getFiveHighestValues(null));

    }

    static List<Integer> getFiveHighestValues(List<Integer> integerList) {
        return Optional.ofNullable(integerList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter( x -> integerList.size() > 5)
                .sorted(Comparator.comparingInt(Integer::intValue).reversed())
                .limit(5)
                .collect(Collectors.toList());
    }
}
