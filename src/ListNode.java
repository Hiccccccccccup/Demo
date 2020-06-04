public class ListNode<E> {

    public E val;
    public ListNode next;


    public ListNode(E e){
        this(e,null);


    }
    public ListNode(E e,ListNode next){
        this.val = e;
        this.next = next;


    }
}
