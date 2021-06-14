import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import tests.*;

public class TestGame {
   public static void main(String[] args) {
      Result result = JUnitCore.runClasses(TestSuite.class);
		
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
		
      if(result.wasSuccessful())
         System.out.println("Tests Passed!");
   }
} 