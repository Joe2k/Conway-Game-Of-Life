package tests;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import src.*;

/**
 * The TestLogic class which has all the tests related to the logic and working of the game.
 */
public class TestLogic {
   
   @Test
   public void testLogicCase1() {
      System.out.println("Testing Logic Case 1");

      Board board1 = new Board(3, 1);

      board1.changeBoard(0, 0);
      board1.changeBoard(1, 0);
      board1.changeBoard(2, 0);
      System.out.println("Input : ");
      board1.displayBoard();
      board1.nextGeneration();
      System.out.println("Output : ");
      board1.displayBoard();
      boolean[][] check = board1.getBoard();
      boolean isCorrect = check[2][0] && check[2][1] && check[2][2];

      assertTrue("Case 1 Logic wrong", isCorrect);

   }
   
   @Test
   public void testLogicCase2() {
      System.out.println("Testing Logic Case 2");

      Board board1 = new Board(3, 3);

      board1.changeBoard(0, 0);
      board1.changeBoard(1, 1);
      board1.changeBoard(2, 2);
      board1.changeBoard(2, 1);
      System.out.println("Input : ");
      board1.displayBoard();
      board1.nextGeneration();
      System.out.println("Output : ");
      board1.displayBoard();
      boolean[][] check = board1.getBoard();
      boolean isCorrect = check[1][0] && check[1][1] && check[1][2] && check[2][1] && check[2][2];

      assertTrue("Case 2 Logic wrong", isCorrect);

   }
   
   @Test
   public void testLogicCase3() {
      System.out.println("Testing Logic Case 3");

      Board board1 = new Board(3, 3);
      
      board1.changeBoard(0, 0);
      board1.changeBoard(1, 1);
      board1.changeBoard(2, 2);
      board1.changeBoard(2, 1);
      board1.changeBoard(1, 2);
      System.out.println("Input : ");
      board1.displayBoard();
      board1.nextGeneration();
      System.out.println("Output : ");
      board1.displayBoard();
      boolean[][] check = board1.getBoard();
      boolean isCorrect = check[1][0] && check[0][1] && check[1][2] && check[2][1] && check[2][2];
      
      assertTrue("Case 3 Logic wrong", isCorrect);

   }
}
