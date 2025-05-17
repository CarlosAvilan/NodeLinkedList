package org.uade.structure.implementation;

import org.uade.structure.definition.SetADT;
import org.uade.structure.definition.SimpleDictionaryADT;
import org.uade.structure.exception.InvalidIndexADTException;
import org.uade.structure.implementation.Set;

public class SimpleDictionary implements SimpleDictionaryADT {

    private SetADT keys;
    private DynamicValueNode first;
    private DynamicValueNode last;

    public SimpleDictionary() {
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
                if (current.key == key) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            //Llegué al último nodo (antes de null)
            if (current.key == key) {
                current.value = value;
            }
        }
    }

    @Override
    public void remove(int key) {
        if (!keys.exist(key)) {
            return;
        } else {
            DynamicValueNode current = first;
            if (current.key == key) {
                first = current.next;
            }
            while (current.next != null) {
                if (current.next.key == key) {
                    current.next = current.next.next;
                    keys.remove(key);
                }
                current = current.next;
            }
        }
    }

    @Override
    public int get(int key) {
        if (keys.exist(key)) {
            DynamicValueNode current = first;
            while (current != null) {
                if (current.key == key) {
                    return current.value;
                }
                current = current.next;
            }
            throw new InvalidIndexADTException("La clave existe, pero hay una inconsistencia y no se encontró el nodo asociado");
        } else {
            throw new InvalidIndexADTException("No existe la clave");
        }
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
}
