package org.example;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;

public class CombinedIterator<A, B, C> implements Iterator<C> {
    private final Iterator<A> iteratorA;
    private final Iterator<B> iteratorB;
    private final BiFunction<A, B, C> combineFunction;

    public CombinedIterator(Iterator<A> iteratorA, Iterator<B> iteratorB, BiFunction<A, B, C> combineFunction) {
        this.iteratorA = iteratorA;
        this.iteratorB = iteratorB;
        this.combineFunction = combineFunction;
    }

    @Override
    public boolean hasNext() {
        return iteratorA.hasNext() && iteratorB.hasNext();
    }

    @Override
    public C next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        A elementA = iteratorA.next();
        B elementB = iteratorB.next();
        return combineFunction.apply(elementA, elementB);
    }

}