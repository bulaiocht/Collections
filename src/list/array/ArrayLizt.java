package list.array;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.StringJoiner;

/**
 * This class is an implementation of ArrayList collection
 * Created by Kocherha Vitalii on 11.06.16.
 */
public class ArrayLizt <E> implements Iterable, Cloneable{
    private final int SCALE_FACTOR = 2;
    private final int ZERO_SIZE = 0;
    private final int INITIAL_CAPACITY = 15;
    private int listSize;
    private int modCounter = 0;

    private E [] container;

    public ArrayLizt () {
        this.listSize = ZERO_SIZE;
        this.container = (E[]) new Object [INITIAL_CAPACITY];
    }

    public ArrayLizt (int capacity) {
        this.listSize = ZERO_SIZE;
        if (capacity<0){
            throw new IllegalArgumentException("Illegal list capacity: " + capacity);
        } else {
            this.container = (E[]) new Object [capacity];
        }
    }

    private void checkAndScale() {
        if (listSize==container.length-1){
            E [] tempCont = (E[]) new Object [container.length*SCALE_FACTOR];
            for (int i = 0; i < listSize; i++) {
                tempCont [i] = container[i];
            }
            this.container = tempCont;
        }
    }

    private void indexCheck (int index) {
        if (index<0 || index > listSize-1){
            throw new ArrayIndexOutOfBoundsException("No such element");
        }
    }


    public void add(Wrapper<? extends E> wrap){
        checkAndScale();
        container[listSize] = wrap.getParameter();
        listSize++;
        modCounter++;
    }

    public void add(E value){
        checkAndScale();
        container[listSize] = value;
        listSize++;
        modCounter++;
    }

    public void remove(int index){
        indexCheck(index);
        for (int i = index; i < listSize; i++) {
            container[i] = container[i+1];
        }
        listSize--;
        modCounter++;
    }

    public void set (int index, E val){
        indexCheck(index);
        container[index] = val;
        modCounter++;
    }

    public E get (int index){
        indexCheck(index);
        return container[index];
    }

    public void clear(){
        for (Object obj : container) {
            obj = null;
        }
        container = (E[]) new Object [INITIAL_CAPACITY];
        listSize=0;
        modCounter++;
    }


    public int size() {
        return listSize;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ArrayLizt{");
        if (listSize==0){
            return builder.append('}').toString();
        }
        for (int i = 0; ; i++) {
            builder.append(String.valueOf(container[i]));
            if (i == listSize-1){
                return builder.append("}").toString();
            }
            builder.append(',');
        }
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            int checker = modCounter;
            int index =0;
            @Override
            public boolean hasNext() {
                if (checker!=modCounter){
                    throw new ConcurrentModificationException();
                }
                return index < listSize;
            }

            @Override
            public E next() {
                if (checker!=modCounter){
                    throw new ConcurrentModificationException();
                }
                return container[++index];
            }
        };
    }

    @Deprecated
    public int getContainerLength() {
        return container.length;
    }
}


