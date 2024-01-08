package org.example;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiFunction;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Test with two iterators over integers
        int[] firstIntArray = {1, 4, 5};
        int[] secondIntArray = {10, 20, 30, 40, 50, 60, 70};

        Iterator<Integer> iteratorA = Arrays.stream(firstIntArray).iterator();
        Iterator<Integer> iteratorB = Arrays.stream(secondIntArray).iterator();


        BiFunction<Integer, Integer, String> combineFunction = (a, b) -> a + "-" + b;

        CombinedIterator<Integer, Integer, String> combinedIterator = new CombinedIterator<>(iteratorA, iteratorB, combineFunction);

        // Test 1
        while (combinedIterator.hasNext()) {
            String result = combinedIterator.next();
            System.out.println(result);
        }
    }
}