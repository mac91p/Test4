package zad2.app;

import zad2.service.OptionalService;
import java.util.Scanner;

public class OptionalRunner {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        OptionalService optionalService = new OptionalService();
        System.out.println(optionalService.getNameLength(sc));
        System.out.println(optionalService.getBirthDateOutOfPesel(sc));
    }
}
