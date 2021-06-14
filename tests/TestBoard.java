package tests;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import src.*;

public class TestBoard {

   @Test
   public void testConstructor() {
      System.out.println("Testing Constructor");

      Board board = new Board(2, 3);
      boolean[][] checkBoard = board.getBoard();

      assertTrue(checkBoard.length == 2 && checkBoard[0].length == 3);
   }
   
   @Test
   public void testSetDimensions() {
      System.out.println("Testing Set Dimensions");

      Board board = new Board(2, 3);
      board.setDimensions(3, 2);
      boolean[][] checkBoard = board.getBoard();

      assertTrue(checkBoard.length == 3 && checkBoard[0].length == 2);
   }

   @Test 
   public void testChangeBoard() {
      System.out.println("Testing Change Board");

      Board board = new Board(2, 3);
      board.changeBoard(1, 1);
      board.changeBoard(0, 0);
      board.changeBoard(0, 0);
      boolean[][] checkBoard = board.getBoard();

      assertTrue(checkBoard[0][0]==false && checkBoard[1][1]==true);
   }
}
