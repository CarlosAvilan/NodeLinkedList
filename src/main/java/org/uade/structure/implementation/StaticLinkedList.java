package org.uade.structure.implementation;

import org.uade.structure.definition.LinkedListADT;
import org.uade.structure.exception.EmptyADTException;
import org.uade.structure.exception.OverflowADTException;

public class StaticLinkedList implements LinkedListADT {
    private LinkedListElement[] elements;
    private int first;
    private int nextSpace;
    private int size;
    private int maxSize;

    public StaticLinkedList() {
        this.maxSize = 100;
        this.elements = new LinkedListElement[maxSize];
        this.first = -1;
        this.nextSpace = 0;
        this.size = 0;
    }

    @Override
    public void add(int value) {
        if (nextSpace >= maxSize) {
            throw new OverflowADTException("Se alcanzó la capacidad máxima");
        }

        int newIndex = nextSpace;
        nextSpace++;
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
        if (index < 0 || index > size || nextSpace >= maxSize) {
            throw new OverflowADTException("Índice inválido o capacidad máxima alcanzada");
        }

        int newIndex = nextSpace;
        nextSpace++;
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

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new EmptyADTException("Índice inválido");
        }

        if (index == 0) {
            first = elements[first].next;
        } else {
            int current = first;
            for (int i = 0; i < index - 1; i++) {
                current = elements[current].next;
            }
            elements[current].next = elements[elements[current].next].next;
        }
        size--;
    }

    @Override
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new EmptyADTException("Índice inválido");
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
