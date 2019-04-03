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
      for(int i = 0; i < data.length; i++){
        int ones = data[i] % 10;
        if (data[i] < 0){
          buckets[9 - Math.abs(ones)].add(data[i]);
        }else{
          buckets[10 + ones].add(data[i]);
        }
      }
      for(int i = 0; i < 20; i++){
        if(buckets[i].size() > 0){
          Hold.extend(buckets[i]);
        }
      }
      for(int place = 2; place <= max; place++){
        while(Hold.size()> 0){
          int item = Hold.remove(0);
          int digitAt = (item / (int)Math.pow(10, place-1)) %10;
          if(item < 0){
            buckets[9 - Math.abs(digitAt)].add(item);
          }else{
              buckets[10 + digitAt].add(item);
          }
        }
        for(int i = 0; i < 20; i++){
          if(buckets[i].size() > 0){
            Hold.extend(buckets[i]);
          }
        }

      }

      int index = 0;
      while(Hold.size()>0){
        data[index]= Hold.remove(0);
        index++;
      }
    }
    public static void main(String[]args){
  System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
  int[]MAX_LIST = {1000000000,500,10};
  for(int MAX : MAX_LIST){
    for(int size = 31250; size < 2000001; size*=2){
      long qtime=0;
      long btime=0;
      //average of 5 sorts.
      for(int trial = 0 ; trial <=5; trial++){
        int []data1 = new int[size];
        int []data2 = new int[size];
        for(int i = 0; i < data1.length; i++){
          data1[i] = (int)(Math.random()*MAX);
          data2[i] = data1[i];
        }
        long t1,t2;
        t1 = System.currentTimeMillis();
        Radix.radixsort(data2);
        t2 = System.currentTimeMillis();
        qtime += t2 - t1;
        t1 = System.currentTimeMillis();
        Arrays.sort(data1);
        t2 = System.currentTimeMillis();
        btime+= t2 - t1;
        if(!Arrays.equals(data1,data2)){
          System.out.println("FAIL TO SORT!");
          System.exit(0);
        }
      }
      System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
    }
    System.out.println();
  }
}
  }
