package org;

import org.uade.structure.definition.QueueADT;
import org.uade.structure.implementation.Queue;
import org.uade.util.QueueUtil;

//import org.uade.structure.implementation.LinkedList;//

import org.uade.structure.definition.StackADT;
import org.uade.structure.implementation.Stack;
import org.uade.util.StackUtil;

import static org.uade.util.StackUtil.copy;


public class Main {
    public static void main(String[] args) {

        QueueADT queue = new Queue();
        System.out.println(queue.isEmpty());

        queue.add(6);
        System.out.println(queue.getElement());
        queue.add(3);
        queue.add(21);
        queue.add(12);

        QueueUtil.print(queue);

        queue.remove();
        QueueUtil.print(queue);

        /*
        Stack stack = new Stack();
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
        */


        /*
        LinkedList list = new LinkedList();
        System.out.println(list.isEmpty());
        System.out.println(list.size());

        list.add(10);
        list.add(20);
        list.add(34);
        list.add(8);
        list.add(3);
        System.out.println(list);

        list.insert(3, 15);
        System.out.println(list);

        System.out.println(list.get(1));
        System.out.println(list.get(3));
        System.out.println(list.get(4));

        list.remove(1);
        System.out.println(list);

        System.out.println(list.size());
        System.out.println(list.isEmpty());
        */
        }
    }
