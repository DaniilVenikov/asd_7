import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OrderedListTest {
    OrderedList<Integer> list;

    @Before
    public void setUp() {
        list = new OrderedList<>(true);
        list.add(5);
        list.add(2);
        list.add(8);
        list.add(3);
    }
    @Test
    public void testAddAscending() {
        assertEquals(2, (int) list.head.value);
        assertEquals(3, (int) list.head.next.value);
        assertEquals(5, (int) list.head.next.next.value);
        assertEquals(8, (int) list.tail.value);
    }

    @Test
    public void testAddDescending() {
        OrderedList<Integer> descendingList = new OrderedList<>(false);
        descendingList.add(5);
        descendingList.add(2);
        descendingList.add(8);
        descendingList.add(3);
        assertEquals(8, (int) descendingList.head.value);
        assertEquals(5, (int) descendingList.head.next.value);
        assertEquals(3, (int) descendingList.head.next.next.value);
        assertEquals(2, (int) descendingList.tail.value);
    }

    @Test
    public void testDelete() {
        list.delete(5);
        assertEquals(2, (int) list.head.value);
        assertEquals(3, (int) list.head.next.value);
        assertEquals(8, (int) list.tail.value);
        list.delete(2);
        assertEquals(3, (int) list.head.value);
        assertEquals(8, (int) list.head.next.value);
        assertEquals(8, (int) list.tail.value);
    }

    @Test
    public void testFind() {
        assertNotNull(list.find(5));
        assertNotNull(list.find(2));
        assertNull(list.find(10));
    }
}

