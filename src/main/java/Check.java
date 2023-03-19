import java.util.Iterator;

public class Check {
    public static void main(String[] args) {
        simpleLinkedList <Integer> list = new simpleLinkedList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.delete(3);

        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(list.get(i));
        }
        Iterator<Integer> it = list.iterator();
        it.hasNext();
        it.next();
        it.next();
        it.next();
     //   it.next();


    }


}
