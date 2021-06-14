package src;

import java.util.*;

public class Display {

    public static void displayBoard(boolean[][] board) {

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
    
    public static int displayCommands() {
        System.out.println("Press 1 to select a cell and negate it's current state");
        System.out.println("Press 2 to run the Conway's Game of Life");
        System.out.println("Press any other character to exit the game\n");

        Scanner myInput = new Scanner(System.in);
        int choice = myInput.nextInt();
        System.out.println("");

        return choice;
    }

    public static int[] getCoordinates() {
        int coordinates[] = new int[2];
        Scanner myInput = new Scanner(System.in);

        System.out.print("Enter the 1st co-ordinate of the cell : ");
        coordinates[0] = myInput.nextInt();

        System.out.print("Enter the 2nd co-ordinate of the cell : ");
        coordinates[1] = myInput.nextInt();

        System.out.println("");

        return coordinates;
    }
    
}
