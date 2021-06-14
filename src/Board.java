package src;

public class Board {
    private boolean[][] board;

    private int[][] neighbors = {
            {0,1},
            { 0, -1 },
            { 1, 0 },
            { -1, 0 },
            { 1, 1 },
            { 1, -1 },
            { -1, 1 },
            { -1, -1 }
    };

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

    public static boolean isEqual(boolean[][] board1, boolean[][] board2) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board1[i][j] != board2[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean nextStep() {
        boolean[][] newBoard = new boolean[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                
                int neighborLiveCells = 0;
                for (int k = 0; k < 8; k++) {
                    if (i + neighbors[k][0] >= 0 && i + neighbors[k][0] <= 9 && j + neighbors[k][1] >= 0
                            && j + neighbors[k][1] <= 9) {
                        if (board[i + neighbors[k][0]][j + neighbors[k][1]]) {
                            neighborLiveCells++;
                        }
                    }
                }

                if (board[i][j]) {
                    if (neighborLiveCells < 2 || neighborLiveCells > 3) {
                        newBoard[i][j] = false;
                    } else {
                        newBoard[i][j] = true;
                    }
                } else {
                    if (neighborLiveCells == 3) {
                        newBoard[i][j] = true;
                    } else {
                        newBoard[i][j] = false;
                    }
                }
            }
        }
        boolean isSame = isEqual(board, newBoard);
        // System.out.println(isSame);
        board = newBoard;

        return isSame;
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
