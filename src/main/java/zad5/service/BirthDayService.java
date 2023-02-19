package zad5.service;


import zad5.exception.InvalidBirthDateException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class BirthDayService {

    private LocalDate convertStringToDate(String userInput) {
        String datePattern = "dd/MM/yyyy";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(datePattern);
        return LocalDate.parse(userInput, dtf);
    }

    public void printLifeStats(Scanner sc) {
        System.out.println("Provide you birth date in format dd/mm/yyyy: ");
        LocalDate birthDay = convertStringToDate(sc.nextLine());
        LocalDate currentDate = LocalDate.ofInstant(Instant.now(), ZoneOffset.UTC);
        if (birthDay.isAfter(currentDate))
            throw new InvalidBirthDateException("Invalid birth date.");
        else {
            System.out.print("You live " + ChronoUnit.DAYS.between(birthDay, currentDate) + " days,  " +
            ChronoUnit.MONTHS.between(birthDay, currentDate) + " months,  " +
            ChronoUnit.YEARS.between(birthDay, currentDate) + " years. You were born on " + birthDay.getDayOfWeek() + ".");
        }
    }
}
