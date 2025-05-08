package org.uade.structure.algorithms;

import org.uade.structure.definition.LinkedListADT;
import org.uade.structure.implementation.LinkedList;
import org.uade.structure.implementation.StaticLinkedList;
import org.uade.util.LinkedListUtil;

public class Pruebastda {
    public static void main(String[] args) {
        LinkedListADT list = new StaticLinkedList();

        list.add(8);
        list.add(17);
        list.add(1);

        LinkedListUtil.print(list);

        list.insert(1, 4);
        LinkedListUtil.print(list);
        System.out.println(list.size());

        list.remove(2);
        LinkedListUtil.print(list);

        int number = list.get(1);
        System.out.println(number);
        System.out.println(list.size());

        list.remove(2);
        list.remove(1);
        System.out.println(list.size());

        list.remove(0);

        System.out.println(list.isEmpty());
    }
}
