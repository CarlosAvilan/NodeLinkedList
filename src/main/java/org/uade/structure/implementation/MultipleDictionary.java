package org.uade.structure.implementation;

import org.uade.structure.definition.MultipleDictionaryADT;
import org.uade.structure.definition.SetADT;

public class MultipleDictionary implements MultipleDictionaryADT {

    private SetADT keys;
    private DynamicValueNode first;
    private DynamicValueNode last;

    public MultipleDictionary() {
        this.keys = new Set();
        this.first = null;
        this.last = null;
    }

    private static class DynamicValueNode {
        private int key;
        private int value;
        private DynamicValueNode next;

        public DynamicValueNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    @Override
    public void add(int key, int value) {
        DynamicValueNode newNode = new DynamicValueNode(key, value);
        if (!keys.exist(key)) {
            keys.add(key);
            last.next = newNode;
            last = newNode;
        } else {
            DynamicValueNode current = first;
            while (current.next != null) {
                if (current.key == key && current.value == value) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            //Llegué al último nodo (antes de null)
            if (current.key == key && current.value == value) {
                current.value = value;
            }
            last.next = newNode;
            last = newNode;
        }
    }

    @Override
    public void remove(int key) {

    }

    @Override
    public int[] get(int key) {
        return new int[0];
    }

    @Override
    public SetADT getKeys() {
        //Copia de las claves para evitar modificarlas una vez retornadas
        SetADT temp = new Set();
        SetADT copia = new Set();

        while (!keys.isEmpty()) {
            int numero = keys.choose();
            temp.add(numero);
            copia.add(numero);
            keys.remove(numero);
        }

        while (!temp.isEmpty()) {
            int numero = temp.choose();
            keys.add(numero);
            temp.remove(numero);
        }
        return copia;
    }

    @Override
    public boolean isEmpty() {
        return first == null && last == null;
    }

    @Override
    public void remove(int key, int value) {

    }
}
