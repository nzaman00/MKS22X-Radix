import java.util.*;
public class Radix{
  public static void radixsort(int[] data){
    @SuppressWarnings("unchecked")
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    int number = (int)Collections.max(Arrays.asList(data));
    int max = String.valueOf(number).length();
    for(int i =0; i < 20; i++){
      buckets[i]= new MyLinkedList<Integer>();
      }
    for(int i =0;i < data.length;i++){
      if(data[i]% 10 < 0){
        buckets[9 + (data[i]% 10)].add(data[i]);
      }
      if(data[i]% 10 >= 0){
        buckets[10 + (data[i]% 10)].add(data[i]);
      }
    }
    MyLinkedList<Integer> Hold = new MyLinkedList<Integer>();
    for(int i = 0; i < 20; i++){
      if(buckets[i].size() > 0){
        Hold.extend(buckets[i]);
      }
    }


  }

}
