package zad4.service;

import zad4.exception.NoWomenException;
import zad4.exception.WrongSexException;
import zad4.model.Person;

import java.util.*;
import java.util.function.Function;
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

    public int getMensAverageAge(List<Person> peopleList) {
        return (int) Optional.ofNullable(peopleList)
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
        Map<String, Function<List<Person>, Integer>> sexFunctions = new HashMap<>();
        sexFunctions.put("man", this::getMensAverageAge);
        sexFunctions.put("woman", this::getWomenAverageAge);
        return Optional.ofNullable(sexFunctions.get(sex == null ? "" : sex.toLowerCase()))
                .orElseThrow(() -> new WrongSexException("Wrong or null provided sex"))
                .apply(personList);
    }


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
