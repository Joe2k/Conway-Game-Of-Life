package tests;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import src.*;

public class TestLogic {
   
   @Test
   public void testNextGeneration() {
      System.out.println("Testing Next Generation Logic");

      Board board1 = new Board(3, 1);
      
      board1.changeBoard(0, 0);
      board1.changeBoard(1, 0);
      board1.changeBoard(2, 0);
      board1.nextGeneration();
      boolean[][] check = board1.getBoard();
      boolean isCorrect = check[2][0] && check[2][1] && check[2][2];
      
      assertTrue("Next Gen Logic wrong", isCorrect);

   }
}
