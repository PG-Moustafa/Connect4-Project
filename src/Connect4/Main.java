package Connect4;

import java.util.Scanner;

import javax.swing.SwingUtilities;

public class Main {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            Connect4GUI game = new Connect4GUI();
            game.setVisible(true);
        });

    }
}
