import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class simpleLinkedListTest {
    simpleLinkedList <Integer> list;

    /**
     * initialize
     */
    @Before
    public void setUp() {
        list = new simpleLinkedList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
    }

    /**
     * list size is The number of elements
     */
    @Test
    public void add() {
        assertThat(list.getSize(), is(4));
    }

    /**
     * get return value by index
     */
    @Test
    public void get() {
        assertThat(list.get(2), is(3));
    }
    /**
     * deleting reduces the list size by the number of elements removed
     */

    @Test
    public void delete() {
        list.delete(1);
        assertThat(list.getSize(), is(3));
        assertThat(list.get(0), is(1));
        assertThat(list.get(1), is(3));
        assertThat(list.get(2), is(4));

        list.delete(0);
        assertThat(list.getSize(),is(2));
        assertThat(list.get(0),is(3));
        assertThat(list.get(1),is(4));





    }





    /**
     * return arrayList size
     */
    @Test
    public void getSize() {
        assertThat(list.getSize(),is(4));
    }
    /**
     * If the item does not exist, an exception is thrown.
     */
    @Test(expected = NoSuchElementException.class)
    public void iteratorHasNextNextSequentialInvocation() {

        Iterator<Integer> it = list.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(false));
        it.next();

    }
    /**
     * Wrong order of invocation.
     */
    @Test(expected = NoSuchElementException.class)
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        Iterator<Integer> it = list.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        it.next();
    }
    /**
     * Multiply invocation of hasNext return the same values
     */
    @Test
    public void hasNextReturnTheSameValues() {
        Iterator<Integer> it = list.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
    }

}

