package org.uade.structure.implementation;

import org.uade.structure.definition.StackADT;
import org.uade.structure.exception.EmptyADTException;

public class Stack implements StackADT {
    private Node top;

    public Stack() {
        this.top = null;
    }

    @Override
    public int getElement() {
        if (!isEmpty()) {
            return top.value;
        } else {
            throw new EmptyADTException("La pila está vacía");
        }
    }

    @Override
    public void add(int value) {
        if (isEmpty()) {
            top = new Node(value);
        } else {
            Node last = top;
            top = new Node(value, last);
        }
    }

    @Override
    public void remove() {
        if (!isEmpty()) {
            top = top.previous;
        } else {
            throw new EmptyADTException("La pila está vacía");
        }
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    private static class Node {
        private int value;
        private Node previous;

        public Node(int value) {
            this.value = value;
            this.previous = null;
        }

        public Node(int value, Node previous) {
            this.value = value;
            this.previous = previous;
        }
    }
}