package zad5.app;

import zad5.service.BirthDayService;
import java.util.Scanner;

public class BirthDayRunner {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BirthDayService birthDayService = new BirthDayService();
        birthDayService.printLifeStats(sc);
        sc.close();
    }
}
