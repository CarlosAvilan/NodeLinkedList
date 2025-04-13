package org;

import org.uade.structure.definition.PriorityQueueADT;
import org.uade.util.PriorityQueueUtil;
import org.uade.structure.implementation.*;



public class Main {
    public static void main(String[] args) {

        PriorityQueueADT queue = new PriorityQueue();
        System.out.println(queue.isEmpty());

        queue.add(10, 5);
        queue.add(20, 7);
        queue.add(30, 7);
        queue.add(40, 7);
        queue.add(15, 6);
        queue.add(5, 4);
        PriorityQueueUtil.print(queue);

        System.out.println("---");

        queue.add(90, 8);
        queue.add(100, 8);

        PriorityQueueADT copia = PriorityQueueUtil.copy(queue);
        PriorityQueueUtil.print(copia);


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

        /*
        LinkedListADT list = new StaticLinkedList();

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
        */
        
    }
}
