package zad2.service;

import zad2.exception.InvalidPeselException;

import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

public class OptionalService {

    public int getNameLength(Scanner sc) {
        System.out.println("Podaj imię: ");
        return Optional.ofNullable(sc.nextLine())
                .map(String::length)
                .orElse(0);
    }

    public String getBirthDateOutOfPesel(Scanner sc) {
        System.out.println("Podaj pesel: ");
        return Optional.ofNullable(sc.next())
                .filter(x -> !x.isEmpty())
                .filter(x -> x.length() == 11)
                .map(x -> x.substring(0, 2) + "-" + x.substring(2,4) + "-" + x.substring(4,6))
                .orElseThrow(() -> new InvalidPeselException("Wrong pesel"));
    }


}
