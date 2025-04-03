package org.uade.structure.implementation;

import org.uade.structure.definition.StackADT;

public class Stack implements StackADT {
    private Node top;

    public Stack() {
        this.top = null;
    }

    public int getElement() {
        if (!isEmpty()) {
            return top.getValue();
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void add(int value) {
        if (isEmpty()) {
            top = new Node(value);
        } else {
            Node last = top;
            top = new Node(value, last);
        }
    }

    public void remove() {
        if (!isEmpty()) {
            top = top.getPrevious();
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

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

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }
    }
}