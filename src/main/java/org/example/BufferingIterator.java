package org.example;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class BufferingIterator<T> implements Iterator<List<T>> {
    private final Iterator<T> iterator;
    private final int batchSize;

    public BufferingIterator(Iterator<T> iterator, int batchSize) {
        this.iterator = iterator;
        this.batchSize = batchSize;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public List<T> next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        List<T> batch = new ArrayList<>();
        for (int i = 0; i < batchSize && iterator.hasNext(); i++) {
            batch.add(iterator.next());
        }
        return batch;
    }

}
