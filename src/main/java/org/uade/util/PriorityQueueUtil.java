package org.uade.util;

import org.uade.structure.definition.PriorityQueueADT;
import org.uade.structure.implementation.PriorityQueue;
import org.uade.structure.exception.EmptyADTException;

public class PriorityQueueUtil {
    public static PriorityQueueADT copy(PriorityQueueADT queue) {
        PriorityQueueADT newQueue = new PriorityQueue();
        PriorityQueueADT temp = new PriorityQueue();

        while (!queue.isEmpty()) {
            int value = queue.getElement();
            int priority = queue.getPriority();
            temp.add(value, priority);
            newQueue.add(value, priority);
            queue.remove();
        }
        while (!temp.isEmpty()) {
            int value = temp.getElement();
            int priority = temp.getPriority();
            queue.add(value, priority);
            temp.remove();
        }

        return newQueue;
    }


    public static void print(PriorityQueueADT queue) {
        if (queue.isEmpty()) {
            System.out.println("La cola está vacía");
            return;
        }

        PriorityQueueADT myQueue = copy(queue);
        while (!myQueue.isEmpty()) {
            System.out.println(myQueue.getElement());
            myQueue.remove();
        }
    }
}