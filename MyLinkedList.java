import java.io.* ;
import java.util.* ;

public class MyLinkedList<E> {

  public class Node {
    private E data ;
    private Node next, prev ;
    public Node(E d, Node p, Node n) {
      data = d ;
      next = n ;
      prev = p ;
    }
    public Node(E d) {
      data = d ;
      prev = null ;
      next = null ;
    }
    public E getData() {
      return data ;
    }
    public Node next() {
      return next ;
    }
    public Node prev() {
      return prev ;
    }
    public boolean hasNext() {
      if (next == null) return false ;
      return true ;
    }
    public E setData(E d) {
      data = d ;
      return data ;
    }
    public void setNext(Node n) {
      next = n ;
    }
    public void setPrev(Node p) {
      prev = p ;
    }
    public String toString() {
      String fin = "" ;
      return fin ;
    }
  }

  private int length ;
  private Node start, end ;
  public MyLinkedList() {
    length = 0 ;
    start = new Node(null, null, null) ;
    end = new Node(null, null, null) ;
  }
  public MyLinkedList(E[] a) {
    	length = a.length ;
    	if (a.length > 0){
    		start = new Node(a[0]) ;
    		Node current = start ;
    		for (int i = 1 ; i < length ; i++) {
    			current.setNext(new Node(a[i], current, null)) ;
    			current = current.next() ;
    		}
    		end = current ;
    	}
    }

  public int size() {
    return length ;
  }
  @SuppressWarnings("unchecked")
  public void extend(MyLinkedList other){
        if(other.size() == 0){
          return;
        }
        if(this.size() ==0){
          this.start = other.start;
          this.length = other.length;
          this.end= other.end;
          other.clear();
          return;
        }
        this.end.setNext(other.start);
        this.end = other.end;
        this.length += other.length;
        other.clear();


    }

  private Node getNthNode(int n) {
    if (n < 0 || n >= length) throw new IndexOutOfBoundsException("The index given is not valid and can't be used to find a Node!") ;
    Node result = start ;
    for (int i = 0 ; i < length && i < n ; i++) {
      result = result.next() ;
    }
    return result ;
  }

  public E get(int index) {
    if (index < 0 || index >= length) throw new IndexOutOfBoundsException("The index given is not valid!") ;
    Node item = getNthNode(index) ;
    return item.getData() ;
  }

  public E set(int index, E value) {
    if (index < 0 || index >= length) throw new IndexOutOfBoundsException("The index given is not valid!") ;
    Node result = start ;
    for (int i = 0 ; i < length ; i++) {
      result = result.next() ;
    }
    E previousData = result.getData() ;
    result.setData(value) ;
    return result.getData() ;
  }

  public boolean contains(E value) {
    Node result = start ;
    for (int i = 0 ; i < length ; i++) {
      if (result.getData() == value) return true ;
      result = result.next() ;
    }
    return false ;
  }

  public void clear() {
    length = 0 ;
		start = null ;
    end = null ;
	}

  public int indexOf(E value) {
    Node current = start ;
    int index = 0 ;
    while (current != null) {
      E v = current.getData() ;
      if (v.equals(value)) return index ;
      current = current.next() ;
      index++ ;
    }
    return -1 ;
  }

  public boolean add(E value) {
    if (length == 0) {
      end = new Node(value) ;
      start = end ;
      length++ ;
    }
    else {
      Node nextNode = new Node(value, end, null) ;
      end.setNext(nextNode) ;
      end = end.next() ;
      length++ ;
    }
    return true ;
  }

  public void add(int index, E value) {
    if (index < 0 || index > length) throw new IndexOutOfBoundsException("The index given does not exist. Therefore, nothing can be changed!") ;
    Node nodeToAdd = new Node(value, null, null) ;
    if (index == 0) {
      start.setPrev(nodeToAdd) ;
      nodeToAdd.setNext(start) ;
      start = nodeToAdd ;
      length++ ;
    }
    else if (index == length) {
      add(value) ;
    }
    else {
      Node nodeToBeShifted = getNthNode(index) ;
      nodeToAdd.setPrev(nodeToBeShifted.prev()) ;
      nodeToAdd.setNext(nodeToBeShifted) ;
      Node nodeThatStays = nodeToBeShifted.prev() ;
      nodeThatStays.setNext(nodeToAdd) ;
      nodeToBeShifted.setPrev(nodeToAdd) ;
      length++ ;
    }
  }

  public E remove(int index) {
    if (index < 0 || index >= length) throw new IndexOutOfBoundsException("The given index can't be used!") ;
    E old = get(index) ;
    if (index == 0) {
      start = start.next() ;
      if(start != null){


      start.setPrev(null) ;
    }
      length-- ;
      return old ;
    }
    if (index == length - 1) {
      end = end.prev() ;
      end.setNext(null) ;
      length-- ;
      return old ;
    }

    Node prevNode = getNthNode(index - 1) ;
    Node nextNode = getNthNode(index + 1) ;
    prevNode.setNext(nextNode) ;
    nextNode.setPrev(prevNode) ;
    length-- ;
    return old ;
  }

  public boolean remove(E value) {
    int index = indexOf(value) ;
    if (index == -1) return false ;
    else {
      remove(index) ;
      return true ;
    }
  }
  public E removeFront() {
    return remove(0) ;
  }

  public String toString() {
    String fin = "[" ;
    Node index = start ;
    for (int i = 0 ; i < length ; i++) {
      if (i < length - 1) fin += index.getData() + ", " ;
      else {
        fin += index.getData() ;
      }
      index = index.next() ;
    }
    return fin += "]" ;
  }
}
