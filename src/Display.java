package src;

import java.util.*;

public class Display {
    static Scanner myInput = new Scanner(System.in);
    
    public static int displayCommands() {
        System.out.println("Press 1 to select a cell and negate it's current state");
        System.out.println("Press 2 to run the Conway's Game of Life");
        System.out.println("Press 3 to change the dimensions of the board");
        System.out.println("Press any other character to exit the game\n");

        
        int choice = myInput.nextInt();
        System.out.println("");

        return choice;
    }

    public static int[] getCoordinates() {
        int coordinates[] = new int[2];

        System.out.print("Enter the 1st co-ordinate of the cell : ");
        coordinates[0] = myInput.nextInt();

        System.out.print("Enter the 2nd co-ordinate of the cell : ");
        coordinates[1] = myInput.nextInt();

        System.out.println("");

        return coordinates;
    }

    public static int[] getDimensions() {
        int dimensions[] = new int[2];

        System.out.print("Enter number of rows you want : ");
        dimensions[0] = myInput.nextInt();

        System.out.print("Enter number of columns you want : ");
        dimensions[1] = myInput.nextInt();

        System.out.println("");

        return dimensions;
    }
    
}
