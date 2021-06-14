package src;

public class Board {
    private boolean[][] board;

    public Board(int i, int j) {
        board = new boolean[i][j];
    }

    public boolean[][] getBoard() {
        return board;
    }

    public void changeBoard(int i, int j) {
        board[i][j] = !board[i][j];
    }
    
    public boolean isEmpty() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board[i][j] == true) {
                    return false;
                }
            }
        }

        return true;
    }

    public void displayBoard() {

        System.out.println("Your Current Board \nO - Live Cell     X - Dead Cell \n");

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board[i][j]) {
                    System.out.print("O (" + Integer.toString(i) + ", " + Integer.toString(j) + ")  ");
                } else {
                    System.out.print("X (" + Integer.toString(i) + ", " + Integer.toString(j) + ")  ");
                }

            }
            System.out.println("");
        }
        System.out.println("");
    }
}
