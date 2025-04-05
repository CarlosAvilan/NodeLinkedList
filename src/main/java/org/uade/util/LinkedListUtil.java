package org.uade.util;

import org.uade.structure.definition.LinkedListADT;
import org.uade.structure.implementation.LinkedList;

public class LinkedListUtil {

       public static void print(LinkedListADT linkedList) {
        if (linkedList.isEmpty()) {
            System.out.println("La lista está vacía");
            return;
        }
        int index = 0;
        while (index < linkedList.size()) {
            System.out.print(linkedList.get(index) + " ");
            index++;
        }
        System.out.println();
    }
}
