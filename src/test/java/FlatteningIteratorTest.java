import org.example.FlatteningIterator;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class FlatteningIteratorTest {

    @Test
    void testFlatteningIterator() {
        // Test with iterators over integers
        Iterator<Integer> iter = new FlatteningIterator<>(
                List.of(42, 5).iterator(),
                List.of(-4).iterator(),
                List.of(999, 998, 997).iterator()
        );

        // Test 1
        assertTrue(iter.hasNext());
        assertEquals(42, iter.next());

        // Test 2
        assertTrue(iter.hasNext());
        assertEquals(5, iter.next());

        // Test 3
        assertTrue(iter.hasNext());
        assertEquals(-4, iter.next());

        // Test 4
        assertTrue(iter.hasNext());
        assertEquals(999, iter.next());

        // Test 5
        assertTrue(iter.hasNext());
        assertEquals(998, iter.next());

        // Test 6
        assertTrue(iter.hasNext());
        assertEquals(997, iter.next());

        // Test 7: No more elements
        assertFalse(iter.hasNext());
        assertThrows(NoSuchElementException.class, iter::next);
    }

    @Test
    void testFlatteningIteratorEmptyInput() {
        // Test with an empty iterator

        int[] empty = {};

        PrimitiveIterator.OfInt emptyIterator = Arrays.stream(empty).iterator();
        Iterator<Integer> iter = new FlatteningIterator<>(emptyIterator, emptyIterator, emptyIterator);

        // Test 1: No more elements
        assertFalse(iter.hasNext());
        assertThrows(NoSuchElementException.class, iter::next);
    }
//
//    @Test
//    void testFlatteningIteratorMixedInput() {
//        // Test with mixed types of iterators
//
//
//        Iterator<Object> iter = new FlatteningIterator<>(
//                List.of("a", "b").iterator(),
//                Arrays.asList(1, 2, 3).iterator(),
//                List.of("x", "y", "z").iterator()
//        );
//
//        // Test 1
//        assertTrue(iter.hasNext());
//        assertEquals("a", iter.next());
//
//        // Test 2
//        assertTrue(iter.hasNext());
//        assertEquals("b", iter.next());
//
//        // Test 3
//        assertTrue(iter.hasNext());
//        assertEquals(1, iter.next());
//
//        // Test 4
//        assertTrue(iter.hasNext());
//        assertEquals(2, iter.next());
//
//        // Test 5
//        assertTrue(iter.hasNext());
//        assertEquals(3, iter.next());
//
//        // Test 6
//        assertTrue(iter.hasNext());
//        assertEquals("x", iter.next());
//
//        // Test 7
//        assertTrue(iter.hasNext());
//        assertEquals("y", iter.next());
//
//        // Test 8
//        assertTrue(iter.hasNext());
//        assertEquals("z", iter.next());
//
//        // Test 9: No more elements
//        assertFalse(iter.hasNext());
//        assertThrows(NoSuchElementException.class, iter::next);
//    }
}
