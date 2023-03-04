package ArecWinaToy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Id {
    static int id;

    public static int idFile(String filePath) {
        try (Scanner scanner = new Scanner(new File(filePath));) {
            while (scanner.hasNextLine()) {
                id = Integer.parseInt(scanner.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, false))) {
            StringBuilder sb = new StringBuilder();
            sb.append(id + 1);
            writer.write(sb.toString());
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }
}
