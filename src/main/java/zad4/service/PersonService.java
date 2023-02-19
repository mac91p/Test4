package zad4.service;

import zad4.exception.NoWomenException;
import zad4.exception.WrongSexException;
import zad4.model.Person;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonService {

    public Person getOldestWoman(List<Person> personList) {
        return Optional.ofNullable(personList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(x -> x.getFirstName().endsWith("a"))
                .max(Comparator.comparingInt(Person::getAge))
                .orElseThrow(() -> new NoWomenException("No woman have been found"));
    }

    public int getAverageAge(List<Person> personList) {
        return (int) Optional.ofNullable(personList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .mapToInt(Person::getAge)
                .average()
                .orElseThrow();
    }

    public int getMensAverageAge(List<Person> personList) {
        return (int) Optional.ofNullable(personList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(x -> !x.getFirstName().endsWith("a"))
                .mapToInt(Person::getAge)
                .average()
                .orElseThrow();
    }

    public int getWomenAverageAge(List<Person> personList) {
        return (int) Optional.ofNullable(personList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(x -> x.getFirstName().endsWith("a"))
                .mapToInt(Person::getAge)
                .average()
                .orElseThrow();
    }

    public int getSexAverageAge(List<Person> personList, String sex) {
        Predicate<Person> sexPredicate;
        if (sex.equalsIgnoreCase("woman")) {
            sexPredicate = x -> x.getFirstName().endsWith("a");
        } else if (sex.equalsIgnoreCase("men")) {
            sexPredicate = x -> !x.getFirstName().endsWith("a");
        } else {
            throw new WrongSexException("Given sex is not correct");
        }
        return (int) Optional.ofNullable(personList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(sexPredicate)
                .mapToInt(Person::getAge)
                .average()
                .orElseThrow();
    }
    //wybrałem listę miast, żeby w przypadku gdy będzie kilka miast z taką samą, najwyższą liczbą ludzi, były zwrócone wszystkie
    public List<String> getCitiesWithHighestPopulation(List<Person> personList) {
        Map<String, Long> citiesMap = Optional.ofNullable(personList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(x -> x.getCity() != null)
                .collect(Collectors.groupingBy(Person::getCity, Collectors.counting()));
        return citiesMap
                .entrySet()
                .stream()
                .filter(x -> x.getValue().equals(Collections.max(citiesMap.values())))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public List<String> getUniqueCities(List<Person> personList) {
        return Optional.ofNullable(personList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .map(Person::getCity)
                .filter(Objects::nonNull)
                .distinct()
                .collect(Collectors.toList());

    }

}
