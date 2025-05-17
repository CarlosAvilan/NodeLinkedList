package org.uade.structure.implementation;

import org.uade.structure.definition.MultipleDictionaryADT;
import org.uade.structure.definition.SetADT;
import org.uade.structure.exception.EmptyADTException;
import org.uade.structure.exception.InvalidIndexADTException;

public class StaticMultipleDictionary implements MultipleDictionaryADT {

    private SetADT keys;
    private StaticValueNode[] values;
    private int size;
    private int maxSize;

    public StaticMultipleDictionary() {
        this.keys = new StaticSet();
        this.size = 0;
        this.maxSize = 100;
        this.values = new StaticValueNode[maxSize];
    }

    public StaticMultipleDictionary(int maxSize) {
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
        if (size >= maxSize) {
            throw new InvalidIndexADTException("No se pueden agregar más claves");
        }

        if (keys.exist(key)) {
            //Si la clave existe, solo agrego el valor, no importa que ya exista y sea duplicado
            for (int i = 0; i < maxSize; i++) {
                if (values[i] == null) {
                    values[i] = new StaticValueNode(key, value);
                    return;
                }
            }
        }
        //Si la clave no existe, entonces agrego clave y valor
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
        if (isEmpty()) {
            throw new EmptyADTException("El diccionario está vacío");
        }

        if (!keys.exist(key)) {
            throw new InvalidIndexADTException("La clave no existe");
        } else {
            for (int i = 0; i < maxSize; i++) {
                if (values[i] != null && values[i].key == key) {
                    values[i] = null;
                }
            }
            keys.remove(key);
            size--;
        }
    }

    @Override
    public int[] get(int key) {
        if (isEmpty()) {
            throw new EmptyADTException("El diccionario está vacío");
        }

        if (!keys.exist(key)) {
            throw new InvalidIndexADTException("La clave no existe");
        } else {
            int count = 0;
            int[] result = new int[maxSize];
            for (int i = 0; i < maxSize; i++) {
                if (values[i] != null && values[i].key == key) {
                    result[count] = values[i].value;
                    count++;
                }
            }
            if (count == 0) {
                throw new InvalidIndexADTException("La clave existe, pero hay una inconsistencia y no se encontró el nodo asociado");
            }
            return result;
        }
    }

    @Override
    public SetADT getKeys() {
        if (isEmpty()) {
            throw new EmptyADTException("El diccionario está vacío");
        }

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

    @Override
    public void remove(int key, int value) {
        if (isEmpty()) {
            throw new EmptyADTException("El diccionario está vacío");
        }
        if (!keys.exist(key)) {
            throw new InvalidIndexADTException("La clave no existe");
        } else {
            int count = 0;
            for (int i = 0; i < maxSize; i++) {
                if (values[i] != null && values[i].key == key && values[i].value == value) {
                    values[i] = null;
                    count++;
                    //Si la clave puede tener el mismo numero repetido como valor hay que cambiar esto
                }
            }
            if (count == 0) {
                throw new InvalidIndexADTException("El valor asociado a la clave no existe");
            } else {
                //Para saber si la clave se quedó sin valores y hay que eliminarla
                int valueCount = 0;
                for (int i = 0; i < maxSize; i++) {
                    if (values[i] != null && values[i].key == key) {
                        valueCount++;
                    }
                }
                if (valueCount == 0) {
                    keys.remove(key);
                    size--;
                }
            }
        }
    }
}