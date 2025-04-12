package org.uade.util;

import org.uade.structure.definition.LinkedListADT;
import org.uade.structure.implementation.LinkedList;
import org.uade.structure.implementation.StaticLinkedList;
import org.uade.structure.exception.EmptyADTException;


public class LinkedListUtil {
   public static LinkedListADT copy(LinkedListADT linkedList) {
       LinkedListADT newList = getNewLinkedList(linkedList);

       for (int i = 0; i < linkedList.size(); i++) {
           int value = linkedList.get(i);
           newList.add(value);
       }

       return newList;
   }


   public static void print(LinkedListADT linkedList) {
       if (linkedList.isEmpty()) {
           throw new EmptyADTException("La lista está vacía");
       }
       int index = 0;
       while (index < linkedList.size()) {
           System.out.print(linkedList.get(index) + " ");
           index++;
       }
       System.out.println();
   }

    public static LinkedListADT getNewLinkedList(LinkedListADT linkedList) {
        if (linkedList instanceof LinkedList) {
            return new LinkedList();
        } else {
            return new StaticLinkedList();
        }
    }
}
