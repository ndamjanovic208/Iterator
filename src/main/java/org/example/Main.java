package org.example;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;


public class Main {
    public static void main(String[] args) {
        // Test with an iterator over integers
        Iterator<List<Integer>> iter = new BufferingIterator<>(List.of(1, 2, 3, 4, 5).iterator(), 3  // groups of size 3
        );

        // Test 1
        List<Integer> batch1 = iter.next();
        System.out.println(batch1);  // Output: [1, 2, 3]

        // Test 2
        List<Integer> batch2 = iter.next();
        System.out.println(batch2);  // Output: [4, 5]

        // Test 3: No more elements
        try {
            iter.next();
        } catch (NoSuchElementException e) {
            System.out.println("All tests passed!");
        }
    }
}