package org.uade.util;

import org.uade.structure.definition.PriorityQueueADT;
import org.uade.structure.definition.QueueADT;
import org.uade.structure.implementation.StaticPriorityQueue;
import org.uade.structure.implementation.PriorityQueue;
import org.uade.structure.exception.EmptyADTException;

public class PriorityQueueUtil {
    public static PriorityQueueADT copy(PriorityQueueADT queue) {
        PriorityQueueADT newQueue = getNewPriorityQueue(queue);
        PriorityQueueADT temp = getNewPriorityQueue(queue);

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
            throw new EmptyADTException("La cola está vacía");
        }

        PriorityQueueADT myQueue = copy(queue);
        while (!myQueue.isEmpty()) {
            System.out.println(myQueue.getElement());
            myQueue.remove();
        }
    }

    public static PriorityQueueADT getNewPriorityQueue(PriorityQueueADT queue) {
        if (queue instanceof PriorityQueue) {
            return new PriorityQueue();
        } else {
            return new StaticPriorityQueue();
        }
    }

    public static int count(PriorityQueueADT queue) {
        PriorityQueueADT myQueue = copy(queue);
        int count = 0;
        while (!myQueue.isEmpty()) {
            myQueue.remove();
            count++;
        }
        return count;
    }
}