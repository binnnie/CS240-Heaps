import java.util.ArrayList;

/*
 * Brandon Dixon, TJ Dillon, Saywere Hendricks
 * MyClient.java
 * 05/09/2018
 *
 * A runnable class for testing the functionality of the ThreeHeap object.
 * */

public class MyClient{
   public static void main(String[] args) {
      ThreeHeap testOne = new ThreeHeap();
      performTests(testOne);
      for (int i = 0 ; i < 24 ; i++) {
         testOne.insert(Math.random());
      }
      performTests(testOne);
      testOne.makeEmpty();
      performTests(testOne);
      ArrayList<Double> testList = new ArrayList<>();
      for (int i = 0 ; i < 22 ; i++) {
         testList.add(Math.random());
      }
      System.out.println(testList);
      testOne.buildQueue(testList);
      performTests(testOne);

      ThreeHeap testTwo = new ThreeHeap();
      testTwo.insert(4.4);
      testTwo.insert(3.2);
      testTwo.insert(2.9);
      testTwo.insert(8.2);
      testTwo.insert(4.2);
      System.out.println(testTwo);
      testTwo.deleteMin();
      testTwo.deleteMin();
      System.out.println(testTwo);
   }

   public static void performTests(ThreeHeap test) {
      System.out.println(test);
      System.out.println(test.isEmpty());
      System.out.println(test.size());
   }
}