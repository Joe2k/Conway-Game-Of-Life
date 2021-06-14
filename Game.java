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

    private void changeDimension() {
        int dimensions[] = Display.getDimensions();
        if(dimensions[0]>0 && dimensions[1]>0)
            board.setDimensions(dimensions[0], dimensions[1]);
        else {
            System.out.println("Invalid Dimentions! \n");
        }
    }

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
