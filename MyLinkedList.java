public class MyLinkedList{
  private int size;
  private Node<E> start,end;

  public MyLinkedList(){
      start = null;
      end = null;
      size = 0;
  }

  public int size() {
    return size;
  }
  public boolean add(int value) {
    if( size == 0) {
      Node<E> n = new Node<E>(value,null,null);
      start = n;
      end = n;
    }
    if( size >= 1) {
      Node<E> n = new Node<E>(value, null, end);
      n.prev().setNext(n);
      end = n;
    }
    size++;
    return true;
  }

  public String toString() {
    if( size == 0)
    return "[]";
    String output = "[";
    Node<E> n = start;
    while(n != end) {
      output += n.getData() +", ";
      n = n.next();
    }
    return output + n.getData() + "]";
  }

  public String toStringReverse() {
    if (size == 0)
    return "[]";
    String output = "[";
    Node<E> n = end;
    while( n != start ) {
      output += n.getData() + ", ";
      n = n.prev();
    }
    return output + n.getData() + "]";
  }

  public Integer get(int index) {
    if( index < 0 || index >= size)
    throw new IndexOutOfBoundsException("Index must be within list");
    Node<E> current = start;
    for( int i = 0; i < index; i++) {
      current = current.next();
    }
    return current.getData();
  }

  public Integer set(int index, Integer value) {
    if( index < 0 || index >= size)
    throw new IndexOutOfBoundsException("Index must be within list");
    Node<E> current = start;
    for( int i = 0; i < index; i++) {
      current = current.next();
    }
    Integer temp = current.getData();
    current.setData(value);
    return temp;
  }

  public boolean contains( Integer value){
    Node<E> current = start;
    while( current != null) {
      if ( current.getData() == value)
      return true;
      current = current.next();
    }
    return false;
    }

  public int indexOf(Integer value){
    if(contains(value)) {
      Node<E> current = start;
      int index = 0;
      while( current.getData() != value) {
        index++;
        current = current.next();
      }
      return index;
    }
    return -1;
  }

  public void add(int index, Integer value){
    if( index < 0 || index > size)
    throw new IndexOutOfBoundsException("Index must be within list");
    Node<E> n = new Node(value,null,null);
    if( index == 0){
      n.setNext(start);
      start.setPrev(n);
      start = n;
      size++;
    } else {
      Node<E> current = start;
      for( int i = 0; i < index; i++) {
        current = current.next();
      }
      Node<E> before = current.prev();
      before.setNext(n);
      current.setPrev(n);
      n.setPrev(before);
      n.setNext(current);
      size++;
    }
  }

  public Integer remove(int index){
    if( index < 0 || index >= size)
    throw new IndexOutOfBoundsException("Index must be within list");
    Node<E> current = start;
    for( int i = 0; i < index; i++) {
      current = current.next();
    }
    if( end == current) {
      Node<E> before = current.prev();
      before.setNext(null);
      end = before;
      size--;
      return current.getData();
    } else {
      if ( current == start) {
        Node<E> after = current.next();
        after.setPrev(null);
        start = after;
        size--;
      } else {
        Node<E> before = current.prev();
        Node<E> after = current.next();
        before.setNext(after);
        after.setPrev(before);
        size--;
      }
    }
    return current.getData();
  }

  public boolean remove(Integer value){
    if(contains(value)) {
      remove(indexOf(value));
      return true;
    }
    return false;
  }
   public void extend(MyLinkedList other){
      end.setNext(other.start);
      other.start.setPrev(end);
      size += other.size();
      end = other.end;
      other.start = null;
      other.end = null;
      other.size = 0;
    }

    public class Node{
 private E data;
 private Node<E> next,prev;

public Node<E>( Integer val, Node Next, Node previous) {
  data = val;
  next = Next;
  prev = previous;
}

 public E getData() {
   return data;
 }

 public Node<E> next() {
   return next;
 }

 public void setNext( Node val) {
   next = val;
 }

 public Node<E> prev() {
   return prev;
 }

 public void setPrev( Node val) {
   prev = val;
 }

 public E setData(Integer i) {
   E temp = data;
   data = i;
   return temp;
 }

 public String toString() {
   return "" + data;
 }

}

}
