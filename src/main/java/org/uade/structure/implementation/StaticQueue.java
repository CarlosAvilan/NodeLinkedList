package org.uade.structure.implementation;

import org.uade.structure.definition.QueueADT;
import org.uade.structure.exception.OverflowADTException;
import org.uade.structure.exception.EmptyADTException;

public class StaticQueue implements QueueADT {
    private int[] values;
    private int firstIndex;
    private int lastIndex;
    private int size;
    private int maxSize;

    public StaticQueue(int maxSize) {
        this.values =  new int[maxSize];
        this.firstIndex = 0;
        this.lastIndex = 0;
        this.size = 0;
        this.maxSize = maxSize;
    }

    public int getElement() {
        if (!isEmpty()) {
            return values[firstIndex];
        } else {
            throw new EmptyADTException("La cola está vacía");
        }
    }

    public void add(int value) {
        if (size == maxSize) {
            throw new OverflowADTException("La cola llegó al máximo de elementos");
        }
        values[lastIndex] = value;
        lastIndex = (lastIndex + 1) % maxSize;
        size++;
    }

    public void remove() {
        if (isEmpty()) {
            throw new EmptyADTException("La cola está vacía");
        }
        firstIndex = (firstIndex + 1) % maxSize;
        size --;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }
}
