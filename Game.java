import src.*;

/**
 * The main Game class which overlooks over the flow of the game and creates instances of Board and Display class.
 */
public class Game {

    /**
    * Initializing the Board Object with dimensions.
    */
    private static Board board = new Board(10, 10);
    
    /**
    * For Case 1 to handle the input of coordinates form user.
    */
    private void handleSelection() {
        int coordinates[] = Display.getCoordinates();

        if (coordinates[0] < 0 || coordinates[0] >= board.getSize()[0] || coordinates[1] < 0 || coordinates[1] >= board.getSize()[1]) {
            System.out.println("Invalid Choice!\n");
        } else {
            board.changeBoard(coordinates[0], coordinates[1]);
            System.out.println("Selection Successful!\n");
        }
    }

    /**
    * For Case 2 to run the game with the given board.
    */
    private int run() {
        int i = 0;
        while (!board.isEmpty()) {
            System.out.println("***** At Generation : " + Integer.toString(i)+" ***** \n");
            board.displayBoard();
            boolean isSame = board.nextGeneration();
            if (isSame) {
                break;
            }
            i++;
        }

        int choice = board.displayFinalState();

        return choice;
    }

    /**
    * For Case 3 to change the dimension according to the user.
    */
    private void changeDimension() {
        int dimensions[] = Display.getDimensions();
        if(dimensions[0]>0 && dimensions[1]>0)
            board.setDimensions(dimensions[0], dimensions[1]);
        else {
            System.out.println("Invalid Dimentions! \n");
        }
    }

    /**
    * Main function for the Game class which is called when the game starts.
    */
    public static void main(String args[]) {
        Game game = new Game();
        boolean flag = true;

        while (flag) {
            board.displayBoardWithLabels();
            int choice = Display.displayCommands();
            
            switch (choice) {
                case 1:
                    game.handleSelection();
                    break;
                case 2:
                    int toContinue = game.run();
                    if (toContinue != 1) flag=false;
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
