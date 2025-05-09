package org.uade.structure.algorithms;

import java.util.Random;
import org.uade.structure.definition.LinkedListADT;
import org.uade.structure.implementation.LinkedList;
import org.uade.structure.implementation.StaticLinkedList;
import org.uade.structure.implementation.StaticSet;
import org.uade.util.LinkedListUtil;

public class Pruebastda {
    public static void main(String[] args) {
        StaticSet conjunto = new StaticSet();

        System.out.println(conjunto.isEmpty());

        conjunto.add(9);

        int numero1 = conjunto.choose();
        System.out.println(numero1);
        System.out.println(conjunto.isEmpty());

        conjunto.add(9);
        conjunto.remove(9);
        System.out.println(conjunto.isEmpty());
    }
}
