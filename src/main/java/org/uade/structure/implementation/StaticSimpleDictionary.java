package org.uade.structure.implementation;

import org.uade.structure.definition.SetADT;
import org.uade.structure.exception.InvalidIndexADTException;
import org.uade.structure.definition.SimpleDictionaryADT;

public class StaticSimpleDictionary implements SimpleDictionaryADT {

    private SetADT keys;
    private StaticValueNode[] values;
    private int size;
    private int maxSize;

    public StaticSimpleDictionary() {
        this.keys = new StaticSet();
        this.size = 0;
        this.maxSize = 100;
        this.values = new StaticValueNode[maxSize];
    }

    public StaticSimpleDictionary(int maxSize) {
        if (maxSize <= 0) {
            throw new InvalidIndexADTException("El tamaño de la estructura debe ser mayor a 0");
        }
        this.keys = new StaticSet();
        this.size = 0;
        this.maxSize = maxSize;
        this.values = new StaticValueNode[maxSize];
    }

    private static class StaticValueNode {
        private int key;
        private int value;

        public StaticValueNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    @Override
    public void add(int key, int value) {
        if (keys.exist(key)) {
            for (int i = 0; i < maxSize; i++) {
                if (values[i] != null && values[i].key == key) {
                    values[i].value = value;
                    return;
                }
            }
            throw new InvalidIndexADTException("La clave existe, pero hay una inconsistencia y no se encontró el nodo asociado");
        }

        if (size >= maxSize) {
            throw new InvalidIndexADTException("No se pueden agregar más claves");
        }
        for (int i = 0; i < maxSize; i++) {
            if (values[i] == null) {
                values[i] = new StaticValueNode(key, value);
                keys.add(key);
                size++;
                return;
            }
        }
    }

    @Override
    public void remove(int key) {
        if (!keys.exist(key)) {
            throw new InvalidIndexADTException("La clave no existe");
        }
        for (int i = 0; i < maxSize; i++) {
            if (values[i] != null && values[i].key == key) {
                values[i] = null;
                keys.remove(key);
                size--;
                return;
            }
        }
        throw new InvalidIndexADTException("La clave existe, pero no se encontró un valor asociado");
    }

    @Override
    public int get(int key) {
        if (keys.exist(key)) {
            for (int i = 0; i < maxSize; i++) {
                if (values[i] != null && values[i].key == key) {
                    return values[i].value;
                }
            }
            throw new InvalidIndexADTException("La clave existe, pero hay una inconsistencia y no se encontró el valor asociado");
        } else {
            throw new InvalidIndexADTException("La clave no existe");
        }
    }

    @Override
    public SetADT getKeys() {
        //Copia de las claves para evitar modificarlas una vez retornadas
        SetADT temp = new StaticSet();
        SetADT copia = new StaticSet();

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
        return size == 0;
    }
}
