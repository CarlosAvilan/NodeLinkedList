package org.uade.structure.implementation;

import org.uade.structure.definition.PriorityQueueADT;
import org.uade.structure.exception.EmptyADTException;

public class PriorityQueue implements PriorityQueueADT {
    private static class Node {
        private int value;
        private int priority;
        private Node next;

        public Node(int value, int priority) {
            this.value = value;
            this.priority = priority;
        }
    }

    private Node head = null;

    public PriorityQueue() {
        head = null;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void add(int value, int priority) {
        Node newNode = new Node(value, priority);
        if (head == null || priority < head.priority) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null && current.next.priority <= priority) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }


    @Override
    public int getElement() {
        if (isEmpty()) {
            throw new EmptyADTException("La cola está vacía");
        }
        return head.value;
    }

    @Override
    public int getPriority() {
        if (isEmpty()) {
            throw new EmptyADTException("La cola está vacía");
        }
        return head.priority;
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new EmptyADTException("La cola está vacía");
        }
        head = head.next;
    }
}
