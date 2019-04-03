import java.util.*;
public class Radix{
  public static void radixsort(int[] data){
    @SuppressWarnings("unchecked")
    MyLinkedList<Integer> Hold = new MyLinkedList<Integer>();
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    //finding max number of digits
    int number = 0;
    boolean neg;
    for(int i = 0; i < data.length; i++){
      if(Math.abs(data[i]) > number){
      number = Math.abs(data[i]);
    }
    }
    int max = String.valueOf(number).length();
    for(int i =0; i < 20; i++){
      buckets[i]= new MyLinkedList<Integer>();
      }
    for(int Pow = 0; Pow < max; Pow++){
      if(Pow == 0){//first case
      if(data[i] < 0){
        buckets[9 - ((Math.abs(data[i]) / (int)Math.pow(10, Pow))%10) ].add(data[i]);
      }else{
        buckets[10 + ((Math.abs(data[i]) / (int)Math.pow(10, Pow))%10)].add(data[i]);
      }
    }
    for(int i = 0; i < 20; i++){
      if(buckets[i].size() > 0){
        Hold.extend(buckets[i]);
      }
    }
  }
  if (Pow + 1 == max){//final case
    while(Hold.size() > 0){
      int item = Hold.remove(0);
      if(item < 0){
        buckets[9 - ((Math.abs(item) / (int)Math.pow(10, Pow))%10) ].add(item);
      }else{
        buckets[ 10 + ((Math.abs(item) / (int)Math.pow(10, Pow))%10) ].add(item);
      }
    }
    for(int i = 0; i < 20; i++){
      if(buckets[i].size() > 0){
        Hold.extend(buckets[i]);
      }
    }
    for(int i = 0; i < Hold.size(); i++){
      data[i] = Hold.get(i);
    }
  }
  if(Pow > 0 && Pow+1 < max){//intermediate passes if any
    while( Hold.size() > 0){
      int item = Hold.remove(0);
      if(item < 0){
        buckets[9 - ((Math.abs(item) / (int)Math.pow(10, Pow))%10) ].add(item);
      }else{
        buckets[ 10 + ((Math.abs(item) / (int)Math.pow(10, Pow))%10) ].add(item);
      }
    }
    Hold.clear();
    for(int i = 0; i < 20; i++){
      if(buckets[i].size() > 0){
        Hold.extend(buckets[i]);
      }
    }
  }
  }



  }
  public static void main(String[] args) {
    int[] a1 = {1,22,12,74,44};
    radixsort(a1);
    System.out.println("radixsort(a1) : Should be [1, 22, 74, 312, 8444], Actual : " + Arrays.toString(a1) + "\n");

  }

}
