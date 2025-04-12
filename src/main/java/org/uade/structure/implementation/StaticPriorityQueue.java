package org.uade.structure.implementation;

import org.uade.structure.definition.PriorityQueueADT;
import org.uade.structure.exception.OverflowADTException;
import org.uade.structure.exception.EmptyADTException;

public class StaticPriorityQueue implements PriorityQueueADT {
    private int[] values;
    private int[] priorities;
    private int size;
    private int maxSize;

    public StaticPriorityQueue() {
        this.maxSize = 100;
        this.values = new int[maxSize];
        this.priorities = new int[maxSize];
        this.size = 0;
    }

    public StaticPriorityQueue(int totalSize) {
        this.maxSize = totalSize;
        this.values = new int[totalSize];
        this.priorities = new int[totalSize];
        this.size = 0;
    }


    @Override
    public int getElement() {
        return values[0];
    }

    @Override
    public int getPriority() {
        return priorities[0];
    }

    @Override
    public void add(int value, int priority) {
        if (size >= maxSize) {
            throw new OverflowADTException("La cola alcanzó su límite");
        }
        int i = size-1;
        while (i >= 0 && priorities[i] < priority) {
            values[i+1] = values[i];
            priorities[i+1] = priorities[i];
            i--;
        }
        values[i+1] = value;
        priorities[i+1] = priority;
        size++;
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new EmptyADTException("La cola está vacía");
        }
        for (int i = 1; i < size; i++) {
            values[i-1] = values[i];
            priorities[i-1] = priorities[i];
        }
        size--;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}