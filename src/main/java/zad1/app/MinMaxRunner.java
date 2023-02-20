package zad1.app;

import zad1.model.Car;
import zad1.model.Person;
import zad1.service.MinMaxService;

import java.util.ArrayList;
import java.util.List;

public class MinMaxRunner {
    public static void main(String[] args) {

        List<Integer> integerList1 = new ArrayList<>();

        integerList1.add(1);
        integerList1.add(2);
        integerList1.add(3);
        integerList1.add(null);
        integerList1.add(5);

        List<String> stringList = new ArrayList<>();

        stringList.add("Jan");
        stringList.add("Jacek");
        stringList.add("Wacek");
        stringList.add("Zbyszek");


        List<Person> peopleList1 = new ArrayList<>();

        peopleList1.add(new Person("Dominik", "Kowalski"));
        peopleList1.add(new Person("Paweł", "Wiśniewski"));
        peopleList1.add(new Person("Adam", "Kowalski"));
        peopleList1.add(new Person("Adam", "Bogacz"));
        peopleList1.add(null);


        List<Car> carList = new ArrayList<>();
        carList.add(new Car("BMW", "M2 CS", 2979));
        carList.add(new Car("Mercedes", "C63 AMG", 3982));
        carList.add(new Car("BMW", "M8", 4395));
        carList.add(new Car("BMW", "M5", 4395));


        System.out.println(MinMaxService.getMinMax(integerList1));
        System.out.println(MinMaxService.getMinMax(stringList));
        System.out.println(MinMaxService.getMinMax(peopleList1));
        System.out.println(MinMaxService.getMinMax(carList));
        System.out.println(MinMaxService.getMinMax(null));


    }
}
