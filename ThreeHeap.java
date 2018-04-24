import java.util.*;

public class ThreeHeap implements PriorityQueue{
   
   private double[] data;
   
   private int size;
   
   public ThreeHeap(){
      this.data = new double[10];
      size = 0;
   }
   
   public boolean isEmpty(){
      return size == 0;
   }
   
   public int size(){
      return size;
   }
   
   public double findMin(){
      if(size == 0){
         throw new EmptyHeapException();
      } else {
         return data[1];
      }
   }
   
   public void insert(double x){ 
      if (size == data.length - 1){
         resize();
      }
      size++;     
      int hole = percolateUp(size + 1, x);
      data[hole] = x;
   }
   private void resize(){
      data = Arrays.copyOf(data, data.length * 2);
   }
   
   private int percolateUp(int hole, double x){
      while(x < data[(hole + 1) / 3] && hole > 1){
         data[hole] = data[(hole + 1) / 3];
         hole = (hole + 1) / 3;
      }
      return hole;
   }
   
   public double deleteMin(){
      if(size == 0){
         throw new EmptyHeapException();
      } else {
         double ans = data[1];
         int hole = percolateDown(1, data[size]);
         data[hole] = data[size];
         size--;
         return ans;
      }
   }
   
   private int percolateDown(int hole, double x){
      int target = findTarget(hole * 3 - 1, hole * 3, hole * 3 + 1);
      while(hole * 3 - 1 <= size && x > data[target]){
         data[hole] = data[target];
         hole = target;
         target = findTarget(hole * 3 - 1, hole * 3, hole * 3 + 1);         
      }
      return hole;
   }
   
   private int findTarget(int left, int mid, int right){
      if(right > size){
         if(mid > size){
            mid = left;
         }
         right = left;
      }
      int target;
      if (data[left] <= data[mid] && data[left] <= data[right]){
         target = left;
      } else if (data[mid] < data[left] && data[mid] <= data[right]){
         target = mid;
      } else if (data[right] < data[left] && data[right] < data[mid]){
         target = right;
      } else {
         target = left;
      }
      return target;
   }
   
   public void buildQueue(List<Double> list){
      double[] hold = new double[list.size() * 2];
      for(int i = 1 ; i <= list.size() ; i++){
         hold[i] = list.get(i);
      }
      for(int i = list.size() / 3 + 1 ; i > 0 ; i--){
         double value = data[i];
         int hole = percolateDown(i, value);
         data[hole] = value;
      }
      size = list.size();
   }
   
   public String toString(){
      String out = "[";
      for(int i = 1 ; i < size ; i++){
         out += data[i] + ", ";
      }
      return out + data[size] + "]";
   }
   
   public void makeEmpty(){
      size = 0;
   }
}