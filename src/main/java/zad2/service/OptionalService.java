package zad2.service;

import zad2.exception.InvalidPeselException;

import java.util.Optional;
import java.util.Scanner;

public class OptionalService {

    public void getNameLength(Scanner sc) {
        System.out.println("Podaj imię: ");
        Optional<String> opt = Optional.ofNullable(sc.nextLine());
        opt.ifPresentOrElse(x -> System.out.println(x.length()), () -> System.out.println("0"));
    }

    private String getDateOutOfPesel(String pesel) {
        StringBuilder sb = new StringBuilder(pesel.substring(0,6));
        sb.insert(2, "-");
        sb.insert(5, "-");
        return sb.toString();
    }

    public void getBirthDateOutOfPesel(Scanner sc) {
        System.out.println("Podaj pesel: ");
        Optional<String> pesel = Optional.ofNullable(sc.next());
        if (pesel.isPresent() && pesel.get().length() == 11)
            System.out.println(getDateOutOfPesel(pesel.get()));
        else {
            throw new InvalidPeselException("Wrong pesel");
        }
    }


}
