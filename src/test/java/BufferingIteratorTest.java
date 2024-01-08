import org.example.BufferingIterator;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class BufferingIteratorTest {

    @Test
    void testBufferingIterator() {
        // Test with an iterator over integers
        Iterator<List<Integer>> iter = new BufferingIterator<>(
                List.of(1, 2, 3, 4, 5).iterator(),
                3  // groups of size 3
        );

        // Test 1
        assertTrue(iter.hasNext());
        List<Integer> batch1 = iter.next();
        assertEquals(List.of(1, 2, 3), batch1);

        // Test 2
        assertTrue(iter.hasNext());
        List<Integer> batch2 = iter.next();
        assertEquals(List.of(4, 5), batch2);

        // Test 3: No more elements
        assertFalse(iter.hasNext());
        assertThrows(NoSuchElementException.class, iter::next);
    }

    @Test
    void testBufferingIteratorEmptyInput() {
        // Test with an empty iterator

        int[] emptyInt = {};
        Iterator<Object> emptyIterator = List.of().iterator();

        PrimitiveIterator.OfInt iterator = Arrays.stream(emptyInt).iterator();
        Iterator<List<Integer>> iter = new BufferingIterator<>(iterator,3);

        // Test 1: No more elements
        assertFalse(iter.hasNext());
        assertThrows(NoSuchElementException.class, iter::next);
    }

    @Test
    void testBufferingIteratorSmallerBatch() {
        // Test with an iterator over integers and a smaller batch size
        Iterator<List<Integer>> iter = new BufferingIterator<>(
                List.of(1, 2, 3, 4, 5).iterator(),
                2  // groups of size 2
        );

        // Test 1
        assertTrue(iter.hasNext());
        List<Integer> batch1 = iter.next();
        assertEquals(List.of(1, 2), batch1);

        // Test 2
        assertTrue(iter.hasNext());
        List<Integer> batch2 = iter.next();
        assertEquals(List.of(3, 4), batch2);

        // Test 3
        assertTrue(iter.hasNext());
        List<Integer> batch3 = iter.next();
        assertEquals(List.of(5), batch3);

        // Test 4: No more elements
        assertFalse(iter.hasNext());
        assertThrows(NoSuchElementException.class, iter::next);
    }
}
