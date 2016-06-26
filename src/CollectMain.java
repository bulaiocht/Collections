import list.array.ArrayLizt;
import list.array.Wrapper;

import java.util.LinkedList;

/**
 *
 * Created by Kocherha Vitalii on 11.06.16.
 */
public class CollectMain {
    public static void main(String[] args) {

        ArrayLizt<Integer> lizt = new ArrayLizt<>(10);

        for (int i = 0; i < 15; i++) {
            lizt.add(i);
        }
        System.out.println(lizt);

        System.out.println(lizt.get(10));

        lizt.remove(3);

        System.out.println(lizt);

        lizt.set(5,100500);

        System.out.println(lizt);

        lizt.clear();

        System.out.println(lizt);


        System.out.println("List container capacity: " + lizt.getContainerLength());
        System.out.println("List size: " + lizt.size());

        LinkedList linkedList;

    }
}
