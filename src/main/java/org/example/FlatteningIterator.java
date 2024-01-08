package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class FlatteningIterator<T> implements Iterator<T> {
    private final List<Iterator<T>> iterators;
    private int currentIteratorIndex;
    private Iterator<T> currentIterator;

    public FlatteningIterator(Iterator<T>... iterators) {
        this.iterators = new ArrayList<>();
        for (Iterator<T> iterator : iterators) {
            this.iterators.add(iterator);
        }
        this.currentIteratorIndex = 0;
        this.currentIterator = getNextNonEmptyIterator();
    }

    @Override
    public boolean hasNext() {
        return currentIterator != null && currentIterator.hasNext();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        T nextElement = currentIterator.next();
        if (!currentIterator.hasNext()) {
            currentIterator = getNextNonEmptyIterator();
        }
        return nextElement;
    }

    private Iterator<T> getNextNonEmptyIterator() {
        while (currentIteratorIndex < iterators.size()) {
            Iterator<T> iterator = iterators.get(currentIteratorIndex);
            if (iterator.hasNext()) {
                currentIteratorIndex++;
                return iterator;
            }
            currentIteratorIndex++;
        }
        return null;
    }


}
