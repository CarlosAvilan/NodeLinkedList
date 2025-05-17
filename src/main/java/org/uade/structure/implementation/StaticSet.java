package org.uade.structure.implementation;

import java.util.Random;
import org.uade.structure.definition.SetADT;
import org.uade.structure.exception.EmptyADTException;
import org.uade.structure.exception.InvalidIndexADTException;
import org.uade.structure.exception.OverflowADTException;

public class StaticSet implements SetADT {

    private int[] values;
    private int size;
    private int maxSize;
    private Random rand;

    public StaticSet() {
        this.maxSize = 100;
        this.values = new int[maxSize];
        this.size = 0;
        rand = new Random();

        for (int i = 0; i < maxSize; i++) {
            values[i] = -1;
        }
    }

    public StaticSet(int maxSize) {
        this.maxSize = maxSize;
        this.values = new int[maxSize];
        this.size = 0;
        rand = new Random();

        for (int i = 0; i < maxSize; i++) {
            values[i] = -1;
        }
    }

    @Override
    public boolean exist(int value) {

        if (!isEmpty()) {
            for (int i = 0; i < maxSize; i++) {
                if (values[i] == value) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int choose() {
        if (isEmpty()) {
            throw new EmptyADTException("El conjunto está vacío");
        }

        while (true) {
            int index = rand.nextInt(maxSize);
            if (values[index] != -1) {
                return values[index];
            }
        }
    }

    @Override
    public void add(int value) {
        if (size == maxSize) {
            throw new OverflowADTException("El conjunto ya está lleno");
        }

        if (exist(value)) {
            return;
        }

        boolean added = false;

        while (added == false) {
            int index = rand.nextInt(maxSize);
            if (values[index] == -1) {
                values[index] = value;
                size++;
                added = true;
            }
        }
    }

    @Override
    public void remove(int element) {
        if (isEmpty()) {
            throw new EmptyADTException("El conjunto está vacío");
        }

        if (!exist(element)) {
            return;
        }

        for (int i = 0; i < maxSize; i++) {
            if (values[i] == element) {
                values[i] = -1;
                size--;
                return;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}