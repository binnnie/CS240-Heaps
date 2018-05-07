import java.util.*;

/*
* Brandon Dixon, TJ Dillon, Saywere Hendricks
* ThreeHeap.java
* 05/09/2018
*
* A heap with three children at each node. Supports insert, deleteMin, findMin, isEmpty, buildQueue, and makeEmpty.
* */

public class ThreeHeap implements PriorityQueue {
   private double[] data;
   private int size;
   
   public ThreeHeap() {
      data = new double[10];
      size = 0;
   }

   //Returns true if the heap is empty, false if it is not.

   public boolean isEmpty() {
      return size == 0;
   }

   //Returns the number of nodes in the heap.

   public int size() {
      return size;
   }

   //Returns the minimum value in the heap.

   public double findMin() {
      if (size == 0) {
         throw new EmptyHeapException();
      } else {
         return data[1];
      }
   }

   //Accepts a parameter x and inserts it into the heap. If the array runs out of size, resize it.

   public void insert (double x) {
      if (size == data.length - 1) {
         resize();
      }
      int hole = percolateUp(size + 1, x);
      data[hole] = x;
      size++;
   }

   //Resizes the data array to be twice its length.

   private void resize() {
      data = Arrays.copyOf(data, data.length * 2);
   }

   //Takes parameters hole and x. Percolates x up the heap and returns an int with the correct index that x should be
   //placed at while moving other values out of the way.

   private int percolateUp(int hole, double x) {
      while (x < data[(hole + 1) / 3] && hole > 1) {
         data[hole] = data[(hole + 1) / 3];
         hole = (hole + 1) / 3;
      }
      return hole;
   }

   //Deletes the minimum value node in the heap. Returns the value that was deleted. If the heap is empty throws
   //EmptyHeapException.

   public double deleteMin() {
      if (size == 0) {
         throw new EmptyHeapException();
      } else {
         double ans = data[1];
         int hole = percolateDown(1, data[size]);
         data[hole] = data[size];
         size--;
         return ans;
      }
   }

   //Takes parameters hole and x. Percolates x down the heap and returns an int with the correct index that x should be
   //placed at while moving other values out of the way.

   private int percolateDown(int hole, double x) {
      int target = findTarget(hole * 3 - 1, hole * 3, hole * 3 + 1);
      while (target <= size && x > data[target]) {
         data[hole] = data[target];
         hole = target;
         target = findTarget(hole * 3 - 1, hole * 3, hole * 3 + 1);
      }
      return hole;
   }

   //Compares values at 3 index and returns the min of the 3. If any of the indexes are out of the size bound
   //it disregards them.

   private int findTarget (int left, int mid, int right) {
      if (right > size) {    //If either right or mid is out of the size bounds of the heap, set them equal to left.
         if (mid > size) {
            mid = left;
         }
         right = left;
      }
      int target;
      if (data[left] <= data[mid] && data[left] <= data[right]) {
         target = left;
      } else if (data[mid] < data[left] && data[mid] <= data[right]) {
         target = mid;
      } else if (data[right] < data[left] && data[right] < data[mid]) {
         target = right;
      } else {
         target = left;
      }
      return target;
   }

   //Accepts a List parameter and builds a heap from the data in it.

   public void buildQueue (List<Double> list) {
      double[] hold = new double[list.size() * 2];
      for (int i = 0 ; i < list.size() ; i++) {
         hold[i + 1] = list.get(i);
      }
      data = hold;
      for (int i = list.size() / 3 + 1 ; i > 0 ; i--) {
         double value = data[i];
         int hole = percolateDown(i, value);
         data[hole] = value;
      }
      size = list.size();
   }

   //Returns a String representation of the heap.

   public String toString() {
      String out = "[";
      for (int i = 1 ; i < size ; i++) {
         out += data[i] + ", ";
      }
      return out + data[size] + "]";
   }

   //Makes the heap appear empty to clients.

   public void makeEmpty() {
      size = 0;
   }
}