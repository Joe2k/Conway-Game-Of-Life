import src.*;

public class Game {

    private static Board board = new Board(10, 10);
    

    private void handleSelection() {
        int coordinates[] = Display.getCoordinates();

        if (coordinates[0] < 0 || coordinates[0] > 9 || coordinates[1] < 0 || coordinates[1] > 9) {
            System.out.println("Invalid Choice!\n");
        } else {
            board.changeBoard(coordinates[0], coordinates[1]);
            System.out.println("Selection Successful!\n");
        }
    }

    private void run() {
        int i = 0;
        while (!board.isEmpty()) {
            System.out.println("At Iteration : " + Integer.toString(i));
            board.displayBoard();
            boolean isSame = board.nextStep();
            if (isSame) {
                break;
            }
            i++;
        }
    }

    public static void main(String args[]) {
        Game game = new Game();
        boolean flag = true;

        while (flag) {
            board.displayBoard();
            int choice = Display.displayCommands();
            
            switch (choice) {
                case 1:
                    game.handleSelection();
                    break;
                case 2:
                    game.run();
                    break;
                default:
                    flag=false;
                    break;
            }
        }
        
        
    }
}
