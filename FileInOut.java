package ArecWinaToy;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;

public class FileInOut {

    public static List<Toy> fileOut() {
        List<Toy> toys = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("ArecWinaToy/toy.csv"));) {
            while (scanner.hasNextLine()) {
                toys.add(getRecordFromLine(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return toys;
    }

    public static Toy getRecordFromLine(String line) {
        Toy toy = new Toy(null, null, null, null);
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                toy.setToyId(Integer.parseInt(rowScanner.next()));
                toy.setToyName(rowScanner.next());
                toy.setToyCount(Integer.parseInt(rowScanner.next()));
                toy.setToyValue(Integer.parseInt(rowScanner.next()));
            }
        }
        return toy;
    }

    public static void fileIn(Toy toy) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("ArecWinaToy/toy.csv", true))) {
            StringBuilder sb = new StringBuilder();
            sb.append(toy.getToyId());
            sb.append(',');
            sb.append(toy.getToyName());
            sb.append(',');
            sb.append(toy.getToyCount());
            sb.append(',');
            sb.append(toy.getToyValue());
            sb.append('\n');
            writer.write(sb.toString());
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void fileWin(Toy winToy, List<Toy> toys) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("ArecWinaToy/winToy.csv", true))) {
            Date dt = new Date();
            StringBuilder sb = new StringBuilder();
            sb.append(Id.idFile("ArecWinaToy/winToyId.csv"));
            sb.append(',');
            sb.append(dt);
            sb.append(',');
            sb.append(winToy.getToyName());
            sb.append('\n');
            writer.write(sb.toString());
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        fileReWrite(toys);
    }

    public static void fileReWrite(List<Toy> toys) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("ArecWinaToy/toy.csv", false))) {
            for (Toy toy : toys) {
                if (toy.getToyCount() != 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(toy.getToyId());
                    sb.append(',');
                    sb.append(toy.getToyName());
                    sb.append(',');
                    sb.append(toy.getToyCount());
                    sb.append(',');
                    sb.append(toy.getToyValue());
                    sb.append('\n');
                    writer.write(sb.toString());
                }
            }
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
