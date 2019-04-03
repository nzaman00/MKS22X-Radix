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
    for(int i =0;i < data.length;i++){
      if(data[i] < 0){
         neg = true;
      }if(data[i] >= 0){
         neg = false;
      }
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
    for(int i = 0; i < Hold.size(); i++){
      if(Hold.get(i) < 0){
         neg = true;
      }else{
         neg = false;
      }
      if(neg){
        buckets[9 - ((Math.abs(Hold.get(i)) / (int)Math.pow(10, Pow))%10) ].add(Hold.get(i));
      }else{
        buckets[ 10 + ((Math.abs(Hold.get(i)) / (int)Math.pow(10, Pow))%10) ].add(Hold.get(i));
      }
    }
    Hold.clear();
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
    for(int i = 0; i < Hold.size(); i++){
      if(Hold.get(i) < 0){
         neg = true;
      }else{
        neg = false;
      }
      if(neg){
        buckets[9 - ((Math.abs(Hold.get(i)) / (int)Math.pow(10, Pow))%10) ].add(Hold.get(i));
      }else{
        buckets[ 10 + ((Math.abs(Hold.get(i)) / (int)Math.pow(10, Pow))%10) ].add(Hold.get(i));
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
