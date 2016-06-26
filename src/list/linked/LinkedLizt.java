package list.linked;
import java.util.ListIterator;

/**
 *
 * Created by Kocherha Vitalii on 25.06.16.
 */
public class LinkedLizt <E> {

    private LiztNode<E> first;
    private LiztNode<E> last;
    private int modCount;
    private int size;

    /**
     * Inner wrapper class which stores data in LinkedLizt;
     * @param <E>
     */
    private class LiztNode<E>{

        private E value;
        private LiztNode<E> next;
        private LiztNode<E> prev;

        public LiztNode(LiztNode<E> prev, E value, LiztNode<E> next) {
            this.next = next;
            this.prev = prev;
            this.value = value;
        }
    }

    /**
     * Basic empty constructor
     */
    public LinkedLizt() {

    }

    /**
     * Adding element to the first position in list
     * @param value
     */
    public void addFirst(E value){
        LiztNode<E> newFirst = new LiztNode<>(null, value, first);
        if (first==null){
            last = newFirst;
        } else {
            first.prev = newFirst;
        }
        first = newFirst;
        size++;
        modCount++;

    }

    /**
     * Adding element to the last position in list
     * @param value
     */
    public void addLast (E value) {
        LiztNode<E> newLast = new LiztNode<>(last,value,null);
        if (last==null){
            first = newLast;
        } else {
            last.next = newLast;
        }
        last = newLast;
        size++;
        modCount++;
    }

    /**
     * unlinking the node element as it is first element in the list
     * @param frst
     * @return
     */
    private E unbindFirst(LiztNode<E> frst) {
        E temp = frst.value;
        frst.value = null;
        frst = frst.next;
        frst.prev = null;
        return temp;
    }

    /**
     * unlinking the last element as it is last element in the list
     * @param lst
     * @return
     */
    private E unbindLast(LiztNode<E> lst) {
        E temp = lst.value;
        lst.value = null;
        lst = lst.prev;
        lst.next = null;
        return temp;
    }

    /**
     * Removes the first element in list
     * @return value of removed element
     */
    public E removeFirst (){
        if (first!=null){
            size--;
            modCount++;
            return unbindFirst(first);
        }
        return null;
    }

    /**
     * Removes the last element in list
     * @return value of removed element
     */
    public E removeLast(){
        if (last!=null){
            size--;
            modCount++;
            return unbindLast(last);
        }
        return null;
    }

    /*TODO addAll() method*/
/*
    public LinkedLizt(Collection<? extends E> collection) {
        this();
        addAll(collection);
    }

    private void addAll(Collection<? extends E> collection){

    }
*/

    public ListIterator<E> listIterator (){

        return new ListIterator<E>() {

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public E next() {
                return null;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }

            @Override
            public E previous() {
                return null;
            }

            @Override
            public int nextIndex() {
                return 0;
            }

            @Override
            public int previousIndex() {
                return 0;
            }

            @Override
            public void remove() {

            }

            @Override
            public void set(E e) {

            }

            @Override
            public void add(E e) {

            }
        };
    }






}
