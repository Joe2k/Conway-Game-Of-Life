package tests;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import src.*;

public class TestBoard {

   @Test
   public void testConstructor() {
      System.out.println("Testing Constructor");

      Board board = new Board(2, 3);
      boolean[][] checkBoard = board.getBoard();

      assertTrue("The board size is not correctly initialized",checkBoard.length == 2 && checkBoard[0].length == 3);
   }
   
   @Test
   public void testSetDimensions() {
      System.out.println("Testing Set Dimensions");

      Board board = new Board(2, 3);
      board.setDimensions(3, 2);
      boolean[][] checkBoard = board.getBoard();

      assertTrue("The board size is not correctly set",checkBoard.length == 3 && checkBoard[0].length == 2);
   }

   @Test 
   public void testChangeBoard() {
      System.out.println("Testing Change Board");

      Board board = new Board(2, 3);
      board.changeBoard(1, 1);
      board.changeBoard(0, 0);
      board.changeBoard(0, 0);
      boolean[][] checkBoard = board.getBoard();

      assertFalse("The board value is not negated on multiple changes", checkBoard[0][0]);
      assertTrue("The board value is not made positive in single change", checkBoard[1][1]);
   }
   
   @Test
   public void testGetSize() {
      System.out.println("Testing Get Size");

      Board board = new Board(2, 3);
      int size[] = board.getSize();

      assertEquals(2, size[0]);
      assertEquals(3, size[1]);
   }

   @Test
   public void testIsEmpty() {
      System.out.println("Testing Is Empty");

      Board board = new Board(2, 3);
      assertTrue("The board should be empty", board.isEmpty());
      board.changeBoard(0, 0);
      assertFalse("The board should not be empty", board.isEmpty());
   }

   @Test
   public void testIsEqual() {
      System.out.println("Testing Is Equal");

      boolean[][] board1 = new boolean[2][3];
      boolean[][] board2 = new boolean[2][3];
      boolean[][] board3 = new boolean[2][3];

      board1[0][0] = true;
      board2[0][0] = true;
      board3[0][0] = true;
      board3[1][1] = true;

      assertTrue("Board must be equal", Board.isEqual(board1, board2));
      assertFalse("Boards must not be equal", Board.isEqual(board1, board3));

   }
}
