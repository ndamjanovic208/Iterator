package org.example;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Iterator;

public class BusinessDaysIterator implements Iterator<LocalDate> {
    private LocalDate currentDate;

    public BusinessDaysIterator(LocalDate startDate) {
        this.currentDate = startDate;
    }

    @Override
    public boolean hasNext() {
        return true; // It's an infinite iterator, always has the next business day
    }

    @Override
    public LocalDate next() {
        do {
            currentDate = currentDate.plusDays(1);
        } while (currentDate.getDayOfWeek() == DayOfWeek.SATURDAY || currentDate.getDayOfWeek() == DayOfWeek.SUNDAY);

        return currentDate;
    }

}
