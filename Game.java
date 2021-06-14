import src.*;

public class Game {

    private static boolean[][] board = new boolean[10][10];
    public static void main(String args[]) {
        Display display = new Display();
        display.displayBoard(board);
        int choice = display.displayCommands();
        int coordinates[];
        switch (choice) {
            case 1:
                coordinates = display.getCoordinates();
                break;
            default:
                break;
        }
    }
}
