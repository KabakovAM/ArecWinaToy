package ArecWinaToy;

import java.util.List;
import java.util.Scanner;

public class Interface {
    static Scanner iScanner = new Scanner(System.in);

    public static void menu() {
        System.out.println("\nArec Win a Toy");
        System.out.println(
                "\nВыберите действие:\n1 - Провести розыгрыш\n2 - Добавить игрушку\n3 - Изменить шанс выигрыша\n0 - Выйти из программы");
        switch (iScanner.nextLine()) {
            case ("1"):
                menu1();
                break;
            case ("2"):
                menu2();
                break;
            case ("3"):
                menu3();
                break;
            case ("0"):
                break;
            default:
                System.out.println("\nВведено неверное значение! Повторите ввод!");
                menu();
                break;
        }
    }

    public static void menu1() {
        String winToy = Win.win();
        if (winToy == "false") {
            System.out.println("\nК сожалению вы проиграли. Возврат в главное меню.");
        } else {
            System.out.println("\nПоздравляем! Вы выиграли! " + winToy + "!" + "\nВозврат в главное меню.");
        }
        menu();
    }

    public static void menu2() {
        Toy toy = new Toy(null, null, null, null);
        toy.setToyId(Id.idFile("Homework14/toyId.csv"));
        System.out.println("Введите название игрушки:");
        toy.setToyName(iScanner.nextLine());
        int data = Except.getValue("Введите количество игрушек:\n");
        toy.setToyCount(data);
        data = Except.getValue("Введите шанс выигрыша игрушки:\n");
        toy.setToyValue(data);
        FileInOut.fileIn(toy);
        System.out.println("\nИгрушка успешно добалена. Выход в главное меню.");
        menu();
    }

    public static void menu3() {
        List<Toy> toys = FileInOut.fileOut();
        System.out.println("\nИгрушки в наличии:\n");
        for (Toy toy : toys) {
            System.out.println(toy.toString());
        }
        System.out.println("\nВведите название игрушки для изменения шанса выигрыша:");
        Toy toy = Except.nameExcept(toys);
        int data2 = Except.getValue("Введите шанс выигрыша игрушки:\n");
        toy.setToyValue(data2);
        FileInOut.fileReWrite(toys);
        System.out.println("\nШанс выигрыша игрушки успешно изменён. Выход в главное меню.");
        menu();
    }
}
