package zad4.app;

import zad4.model.Person;
import zad4.service.PersonService;

import java.util.ArrayList;
import java.util.List;

public class PersonRunner {
    public static void main(String[] args) {

        List<Person> peopleList = new ArrayList<>();
        peopleList.add(new Person("Jan", "Kowalski", "Warszawa", 50));
        peopleList.add(new Person("Janina", "Buczek", "Warszawa", 30));
        peopleList.add(new Person("Marian", "Lasek", "Kraków", 18));
        peopleList.add(new Person("Marcin", "Puczyk", "Poznań", 31));
        peopleList.add(new Person("Agnieszka", "Waligóra", "Kraków", 27));

        PersonService personService = new PersonService();
        System.out.println(personService.getOldestWoman(peopleList));
        System.out.println(personService.getAverageAge(peopleList));
        System.out.println(personService.getMensAverageAge(peopleList));
        System.out.println(personService.getWomenAverageAge(peopleList));
        System.out.println(personService.getSexAverageAge(peopleList, "WoMan"));
        System.out.println(personService.getCitiesWithHighestPopulation(peopleList));
        System.out.println(personService.getUniqueCities(peopleList));

    }
}
