public class Radix{
  public static void radixsort(int[] data){
    @SuppressWarnings("unchecked")
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
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
    
  }

}
