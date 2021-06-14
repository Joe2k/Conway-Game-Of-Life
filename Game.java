import src.*;

public class Game {

    private static Board board = new Board(10, 10);
    

    private void handleSelection() {
        int coordinates[] = Display.getCoordinates();

        if (coordinates[0] < 0 || coordinates[0] >= board.getSize()[0] || coordinates[1] < 0 || coordinates[1] >= board.getSize()[1]) {
            System.out.println("Invalid Choice!\n");
        } else {
            board.changeBoard(coordinates[0], coordinates[1]);
            System.out.println("Selection Successful!\n");
        }
    }

    private void run() {
        int i = 0;
        while (!board.isEmpty()) {
            System.out.println("At Generation : " + Integer.toString(i));
            board.displayBoard();
            boolean isSame = board.nextStep();
            if (isSame) {
                break;
            }
            i++;
        }
    }

    private void changeDimension() {
        int dimensions[] = Display.getDimensions();
        board.setDimensions(dimensions[0], dimensions[1]);
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
                case 3:
                    game.changeDimension();
                    break;
                default:
                    flag=false;
                    break;
            }
        }
        
    }
}
