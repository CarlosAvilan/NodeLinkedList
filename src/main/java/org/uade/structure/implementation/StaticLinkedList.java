package org.uade.structure.implementation;

import org.uade.structure.definition.LinkedListADT;
import org.uade.structure.exception.EmptyADTException;
import org.uade.structure.exception.InvalidIndexADTException;
import org.uade.structure.exception.OverflowADTException;

public class StaticLinkedList implements LinkedListADT {
    private LinkedListElement[] elements;
    private int first;
    private int nextSpace;
    private int size;
    private int maxSize;
    private int free;

    public StaticLinkedList() {
        this.maxSize = 100;
        this.elements = new LinkedListElement[maxSize];
        this.first = -1;
        this.nextSpace = 0;
        this.size = 0;
        this.free = -1;
    }

    public StaticLinkedList(int maxSize) {
        if (maxSize <= 0) {
            throw new InvalidIndexADTException("El valor debe ser mayor a cero");
        }
        this.maxSize = maxSize;
        this.elements = new LinkedListElement[maxSize];
        this.first = -1;
        this.nextSpace = 0;
        this.size = 0;
        this.free = -1;
    }

    private int allocateNode() {
        if (free != -1) {
            int index = free;
            free = elements[free].next;
            return index;
        }

        if (nextSpace >= maxSize) {
            throw new OverflowADTException("Se alcanzó la capacidad máxima");
        }
        return nextSpace++;
    }

    private void freeNode(int index) {
        elements[index].next = free;
        free = index;
    }

    @Override
    public void add(int value) {
        int newIndex = allocateNode();
        elements[newIndex] = new LinkedListElement(value, -1);

        if (isEmpty()) {
            first = newIndex;
        } else {
            int current = first;
            while (elements[current].next != -1) {
                current = elements[current].next;
            }
            elements[current].next = newIndex;
        }
        size++;
    }

    @Override
    public void insert(int index, int value) {
        if (index < 0 || index > size) {
            throw new InvalidIndexADTException("Índice inválido");
        }

        int newIndex = allocateNode();

        if (index == 0) {
            elements[newIndex] = new LinkedListElement(value, first);
            first = newIndex;
        } else {
            int current = first;
            for (int i = 0; i < index - 1; i++) {
                current = elements[current].next;
            }
            elements[newIndex] = new LinkedListElement(value, elements[current].next);
            elements[current].next = newIndex;
        }
        size++;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new InvalidIndexADTException("Índice inválido");
        }

        int removedIndex;

        if (index == 0) {
            removedIndex = first;
            first = elements[first].next;
        } else {
            int current = first;
            for (int i = 0; i < index - 1; i++) {
                current = elements[current].next;
            }
            removedIndex = elements[current].next;
            elements[current].next = elements[removedIndex].next;
        }
        freeNode(removedIndex);
        size--;
    }

    @Override
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new InvalidIndexADTException("Índice inválido");
        }

        int current = first;
        for (int i = 0; i < index; i++) {
            current = elements[current].next;
        }
        return elements[current].value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private static class LinkedListElement {
        int value;
        int next;

        public LinkedListElement(int value, int next) {
            this.value = value;
            this.next = next;
        }
    }
}
