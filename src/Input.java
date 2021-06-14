package src;

public class Input {
    private boolean[][] board = new boolean[10][10];

    public void getInput() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board[i][j]) {
                    System.out.print("O ");
                } else {
                    System.out.print("X ");
                }

            }
            System.out.println("");
        }
    }
    
}
