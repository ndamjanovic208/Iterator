import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.example.BusinessDaysIterator;
import org.junit.jupiter.api.Test;


public class BusinessDaysIteratorTest {

    @Test
    public void testBusinessDaysIterator() {
        // Test with a start date
        LocalDate startDate = LocalDate.of(2022, 1, 1);
        BusinessDaysIterator businessDaysIterator = new BusinessDaysIterator(startDate);

        // Test 1: Check the first few business days
        assertEquals(LocalDate.of(2022, 1, 3), businessDaysIterator.next());
        assertEquals(LocalDate.of(2022, 1, 4), businessDaysIterator.next());
        assertEquals(LocalDate.of(2022, 1, 5), businessDaysIterator.next());
        assertEquals(LocalDate.of(2022, 1, 6), businessDaysIterator.next());
        assertEquals(LocalDate.of(2022, 1, 7), businessDaysIterator.next());

        // Test 2: Check a business day after a weekend
        assertEquals(LocalDate.of(2022, 1, 10), businessDaysIterator.next());
    }
}