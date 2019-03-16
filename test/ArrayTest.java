package com.atechac.web;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class MyTest {
   
   static int[] expectedValues = new int[] {3,3,0};
   static int index = 0;

   @Parameters
   public static Collection<int[]> testData() {
      return Arrays.asList(new int[][] {  
         {2, 1, 2, 3, 4}, 
         {2, 2, 0},
         {1, 3, 5}
      });
   }
   
   @Parameter(0)
   public int[] inputArray;
   
      
   @Test
   public void testMethod() {
      Runner testRunner = new Runner();
      assertEquals(expectedValues[index], testRunner.countEvens(inputArray));
   }
   
   @After
   public void next() throws Exception {
      if (++index >= testData().size()) {
         index = 0;        
      }
   }
   
}
