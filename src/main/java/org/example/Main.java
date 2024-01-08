package org.example;

import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Test with iterators over integers
        Iterator<Integer> iter = new FlatteningIterator<>(
                List.of(42, 5).iterator(),
                List.of(-4).iterator(),
                List.of(999, 998, 997).iterator()
        );

        // Test 1
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}