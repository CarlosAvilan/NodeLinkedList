package org.uade.structure.implementation;

import org.uade.structure.definition.SetADT;
import org.uade.structure.exception.EmptyADTException;

import java.util.Random;

public class Set implements SetADT {

    private Node first;
    private int size;
    private Random rand;

    public Set() {
        this.first = null;
        this.size = 0;
        rand = new Random();
    }

    private static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    @Override
    public boolean exist(int value) {
        Node current = first;
        while (current != null) {
            if (current.value == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int choose() {
        if (isEmpty()) {
            throw new EmptyADTException("El conjunto está vacío");
        }

        int random = rand.nextInt(size);
        int count = 0;
        Node current = first;
        while (count != random) {
            current = current.next;
            count++;
        }
        return current.value;
    }

    @Override
    public void add(int value) {
        if (exist(value)) {
            return;
        }

        Node nuevo = new Node(value);

        if (isEmpty()) {
            first = nuevo;
        } else {
            int random = rand.nextInt(size+1);

            if (random == 0) {
                nuevo.next = first;
                first = nuevo;
            } else {
                Node current = first;
                int count = 0;
                while (count != (random-1)) {
                    current = current.next;
                    count++;
                }
                nuevo.next = current.next;
                current.next = nuevo;
            }
        }
        size++;
    }

    @Override
    public void remove(int element) {
        if (isEmpty()) {
            throw new EmptyADTException("El conjunto está vacío");
        } else if (!exist(element)) {
            return;
        } else if (first.value == element) {
            first = first.next;
            size--;
            return;
        } else {
            Node current = first;
            Node previous = null;
            while (current.value != element) {
                previous = current;
                current = current.next;
            }
            previous.next = current.next;
            size--;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
