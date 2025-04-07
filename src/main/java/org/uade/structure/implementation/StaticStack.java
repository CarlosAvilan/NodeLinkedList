package org.uade.structure.implementation;

import org.uade.structure.definition.StackADT;
import org.uade.structure.exception.EmptyADTException;
import org.uade.structure.exception.OverflowADTException;

public class StaticStack implements StackADT {
    private int[] values;
    private int topIndex;
    private int size;
    private int maxSize;

    public StaticStack(int maxSize) {
        this.values = new int[maxSize];
        this.topIndex = -1;
        this.size = 0;
        this.maxSize = maxSize;
    }


    public int getElement() {
        if (isEmpty()) {
            throw new EmptyADTException("La pila está vacía");
        } else {
            return values[topIndex];
        }
    }

    public void add(int value) {
        if (size == maxSize) {
            throw new OverflowADTException("El índice está fuera de rango");
        }
        topIndex++;
        values[topIndex] = value;
        size++;
    }

    public void remove() {
        if (isEmpty()) {
            throw new EmptyADTException("La pila está vacía");
        }
        topIndex--;
        size --;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }
}
