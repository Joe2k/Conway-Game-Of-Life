import src.*;

public class Game {

    private boolean[][] board = new boolean[10][10];
    

    private void handleSelection() {
        int coordinates[] = Display.getCoordinates();

        if (coordinates[0] < 0 || coordinates[0] > 9 || coordinates[1] < 0 || coordinates[1] > 9) {
            System.out.println("Invalid Choice!\n");
        } else {
            this.board[coordinates[0]][coordinates[1]] = !this.board[coordinates[0]][coordinates[1]];
            System.out.println("Selection Successful!\n");
        }
    }

    public static void main(String args[]) {
        Game game = new Game();
        boolean flag = true;

        while (flag) {
            Display.displayBoard(game.board);
            int choice = Display.displayCommands();
            
            switch (choice) {
                case 1:
                    game.handleSelection();
                    break;
                default:
                    flag=false;
                    break;
            }
        }
        
        
    }
}
