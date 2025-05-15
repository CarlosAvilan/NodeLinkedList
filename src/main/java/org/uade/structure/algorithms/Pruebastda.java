package org.uade.structure.algorithms;

import java.util.Random;
import org.uade.structure.definition.LinkedListADT;
import org.uade.structure.implementation.LinkedList;
import org.uade.structure.implementation.StaticLinkedList;
import org.uade.structure.implementation.StaticSet;
import org.uade.structure.implementation.Set;
import org.uade.util.LinkedListUtil;
import org.uade.util.SetUtil;

public class Pruebastda {
    public static void main(String[] args) {
        Set conjunto = new Set();

        System.out.println(conjunto.isEmpty());

        conjunto.add(9);
        conjunto.add(8);
        conjunto.add(7);
        conjunto.add(6);

        SetUtil.print(conjunto);

        int numero1 = conjunto.choose();
        System.out.println(numero1);
        System.out.println(conjunto.isEmpty());

        conjunto.add(9);
        int conteo = SetUtil.count(conjunto);
        System.out.println(conteo);
        System.out.println("---");
        conjunto.remove(9);
        conjunto.remove(7);
        conjunto.add(11);
        System.out.println(conjunto.isEmpty());
        SetUtil.print(conjunto);
        int conteo2 = SetUtil.count(conjunto);
        System.out.println(conteo2);
        boolean prueba = conjunto.exist(21);
        System.out.println(prueba);
        System.out.println("---");
        boolean prueba2 = conjunto.exist(11);
        System.out.println(prueba2);
    }
}
