package org.uade.structure.implementation;

import org.uade.structure.exception.EmptyADTException;
import org.uade.structure.definition.QueueADT;

public class Queue implements QueueADT {
    private Node first;
    private Node last;

    public Queue() {
        this.first = null;
        this.last = null;
    }


    public int getElement() {
        if (!isEmpty()) {
            return first.value;
        } else {
            throw new EmptyADTException("La cola está vacía");
        }
    }


    public void add(int value) {
        if (isEmpty()) {
            first = new Node(value);
            last = first;
        } else {
            Node current = new Node(value);
            last.next = current;
            last = current;
        }
    }


    public void remove() {
        if (!isEmpty()) {
            first = first.next;
            if (first == null) {
                last = null;
            }
        } else {
            throw new EmptyADTException("La cola está vacía");
        }
    }


    public boolean isEmpty() {
        return first == null;
    }

    private static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }
}
