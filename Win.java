package ArecWinaToy;

import java.util.List;
import java.util.Random;

public class Win {

    public static String win() {
        List<Toy> winLine = FileInOut.fileOut();
        Toy winToy = winLine.get(new Random().nextInt(winLine.size()));
        int i = (int) (Math.random() * 100);
        if (i <= winToy.getToyValue()) {
            for (Toy toy : winLine) {
                if (toy.getToyId() == winToy.getToyId()) {
                    toy.setToyCount(toy.getToyCount() - 1);
                }
            }
            FileInOut.fileWin(winToy, winLine);
            return winToy.getToyName();
        } else {
            return "false";
        }
    }
}
