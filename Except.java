package ArecWinaToy;

import java.util.List;
import java.util.Scanner;

public class Except {
    static Scanner iScanner = new Scanner(System.in);

    public static int getValue(String title) {
        int a = 0;
        System.out.printf(title);
        while (!iScanner.hasNextInt()) {
            System.out.println("\nВведено неверное значение! Повторите ввод!");
            iScanner.next();
        }
        a = iScanner.nextInt();
        if (a > 0) {
            return a;
        } else {
            return getValue("\nВведено неверное значение! Повторите ввод!\n");
        }
    }

    public static Toy nameExcept(List<Toy> toys) {
        String name = iScanner.nextLine();
        for (Toy toy : toys) {
            if (name.equals(toy.getToyName())) {
                return toy;
            }
        }
        System.out.println("\nВведено неверное значение! Повторите ввод!");
        return nameExcept(toys);
    }
}
