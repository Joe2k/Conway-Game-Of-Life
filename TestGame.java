import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import tests.*;

/**
 * The main TestGame class which instantiates all the tests from the TestSuite class and gets control to handle when a test fails/passes.
 */
public class TestGame {
   /**
   * The main method to call JUnitCore to run the test and catch passes/fails of tests.
   */
   public static void main(String[] args) {
      Result result = JUnitCore.runClasses(TestSuite.class);
		
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
		
      if(result.wasSuccessful())
         System.out.println("All Tests Passed!");
   }
} 