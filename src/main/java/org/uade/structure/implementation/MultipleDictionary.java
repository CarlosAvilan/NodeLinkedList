package org.uade.structure.implementation;

import org.uade.structure.definition.MultipleDictionaryADT;
import org.uade.structure.definition.SetADT;
import org.uade.structure.exception.EmptyADTException;
import org.uade.structure.exception.InvalidIndexADTException;

public class MultipleDictionary implements MultipleDictionaryADT {

    private SetADT keys;
    private DynamicValueNode first;

    public MultipleDictionary() {
        this.keys = new Set();
        this.first = null;
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
        }

        if (isEmpty()) {
            first = newNode;
        }
        else {
            DynamicValueNode current = first;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    @Override
    public void remove(int key) {
        if (isEmpty()) {
            throw new EmptyADTException("El diccionario está vacío");
        }

        if (!keys.exist(key)) {
            return;
        }

        boolean found = false;

        if (first.key == key) {
            first = first.next;
            found = true;
        }
        DynamicValueNode current = first;
        while (current.next != null) {
            if (current.next.key == key) {
                current.next = current.next.next;
                if (keys.exist(key) && !found) {
                    found = true;
                }
            }
            current = current.next;
        }
        if (found) {
            keys.remove(key);
        } else {
            throw new InvalidIndexADTException("La clave existe, pero hay una inconsistencia y no se encontró el valor asociado");
        }
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
        return first == null;
    }

    @Override
    public void remove(int key, int value) {
        if (isEmpty()) {
            throw new EmptyADTException("El diccionario está vacío");
        }

        if (!keys.exist(key)) {
            return;
        }

        boolean found = false;
        int countValues = 0;
//A ver como hago la cuenta para saber si la clave se quedó sin valores asociados
        if (first.key == key && first.value == value) {
            first = first.next;
            found = true;
        }
        DynamicValueNode current = first;
        while (current.next != null) {
            if (current.next.key == key) {
                current.next = current.next.next;
                if (keys.exist(key) && !found) {
                    found = true;
                }
            }
            current = current.next;
        }
        if (found && countValues == 0) {
            keys.remove(key);
        } else {
            throw new InvalidIndexADTException("La clave existe, pero hay una inconsistencia y no se encontró el valor asociado");
        }
    }
}
