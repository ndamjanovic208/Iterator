import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.example.CombinedIterator;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class CombinedIteratorTest {

    @Test
    public void testCombinedIterator() {
        // Test with two iterators over integers
        Iterator<Integer> iteratorA = Arrays.asList(1, 2, 3, 4, 5).iterator();
        Iterator<Integer> iteratorB = Arrays.asList(10, 20, 30, 40, 50).iterator();
        CombinedIterator<Integer, Integer, String> combinedIterator =
                new CombinedIterator<>(iteratorA, iteratorB, (a, b) -> a + "-" + b);

        // Test 1
        List<String> expectedResults = Arrays.asList("1-10", "2-20", "3-30", "4-40", "5-50");
        expectedResults.forEach(expectedResult -> assertEquals(expectedResult, combinedIterator.next()));

        // Test 2: No more elements
        assertFalse(combinedIterator.hasNext());
        assertThrows(NoSuchElementException.class, combinedIterator::next);
    }

    @Test
    public void testCombinedIteratorEmptyInput() {
        // Test with one empty iterator
        Iterator<Integer> iteratorA = Arrays.asList(1, 2, 3, 4, 5).iterator();
        int[] emptyInt = {};
        Iterator<Integer> emptyIteratorB = Arrays.stream(emptyInt).iterator();
        CombinedIterator<Integer, Integer, String> combinedIterator =
                new CombinedIterator<>(iteratorA, emptyIteratorB, (a, b) -> a + "-" + b);

        // Test 1
        assertFalse(combinedIterator.hasNext());
        assertThrows(NoSuchElementException.class, combinedIterator::next);
    }
}
