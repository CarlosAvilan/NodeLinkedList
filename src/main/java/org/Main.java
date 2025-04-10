package org;

import org.uade.structure.definition.QueueADT;
import org.uade.structure.implementation.*;
import org.uade.util.QueueUtil;

import org.uade.structure.definition.LinkedListADT;
import org.uade.util.LinkedListUtil;

import org.uade.structure.definition.StackADT;
import org.uade.util.StackUtil;


public class Main {
    public static void main(String[] args) {

        /*
        QueueADT queue = new StaticQueue(4);
        System.out.println(queue.isEmpty());

        queue.add(6);
        System.out.println(queue.getElement());
        queue.add(3);
        queue.add(21);
        queue.add(12);

        QueueUtil.print(queue);

        queue.remove();
        QueueUtil.print(queue);
        */

        /*
        StackADT stack = new StaticStack();
        System.out.println(stack.isEmpty());

        stack.add(7);
        System.out.println(stack.getElement());
        stack.add(4);
        stack.add(12);
        StackUtil.print(stack);

        StackADT copia = StackUtil.copy(stack);
        StackUtil.print(copia);
        stack.remove();
        StackUtil.print(stack);
        stack.add(1);
        StackUtil.print(stack);
        */



        LinkedListADT list = new LinkedList();

        LinkedListUtil.print(list);

        list.add(10);
        list.add(20);
        list.add(34);
        list.add(8);
        list.add(3);
        LinkedListUtil.print(list);

        list.insert(3, 15);
        LinkedListUtil.print(list);

        System.out.println(list.get(1));
        System.out.println(list.get(3));
        System.out.println(list.get(4));
        System.out.println("----");

        list.remove(1);
        LinkedListUtil.print(list);

        System.out.println(list.size());
        LinkedListUtil.print(list);
        
    }
}
