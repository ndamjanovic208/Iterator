package org.example;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
// Test with a start date
        LocalDate startDate = LocalDate.of(2022, 1, 1);
        BusinessDaysIterator businessDaysIterator = new BusinessDaysIterator(startDate);

        // Test 1: Check the first few business days
        for (int i = 0; i < 5; i++) {
            LocalDate nextBusinessDay = businessDaysIterator.next();
            System.out.println(nextBusinessDay);
        }

        // Test 2: Check a business day after a weekend
        LocalDate nextBusinessDay = businessDaysIterator.next();  // Skips Saturday (2022-01-08) and Sunday (2022-01-09)
        System.out.println(nextBusinessDay);  // Output: 2022-01-10
    }
}
