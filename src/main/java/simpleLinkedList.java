
import org.w3c.dom.Node;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class simpleLinkedList<E> implements Iterable<E> {

    private int size = 0;

    private Node<E> first;
    private Node<E> last;


    private static class Node<E> {

        private E data;

        Node next;
        Node previous;


        Node(E data) {
            this.data = data;
        }
    }

    public void add(E data) {
        Node newNode = new Node(data);
        if (first == null) {
            newNode.next = null;
            newNode.previous = null;
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            newNode.previous = last;
            last = newNode;
        }
        size++;

    }

    public E get(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        Node result = first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }

        return (E) result.data;
    }


    @Override
    public Iterator<E> iterator() {


        return new Iterator<E>() {
            simpleLinkedList.Node current = first;

            @Override
            public boolean hasNext() {
                if (current != null)
                    return true;
                else
                    return false;
            }

            @Override
            public E next() {



                if (hasNext()) {
                    E data = (E) current.data;
                    current = current.next;

                    return (E) data;
                }
                else {
                    throw new NoSuchElementException();
                }


            }
        };
    }

    public E delete(int index) {
      Node del = first;
        for (int i = 1; i < size; i++) {
            del = del.next;
            if (i == index) {
                if (del.next!=null){
                del.next.previous = del.previous;
                del.previous.next = del.next;}
                else {
                    del.previous.next = last;
                }


            }

        }



        size--;





        return (E) del.data;
    }





    public int getSize() {

        return size;
    }


}

