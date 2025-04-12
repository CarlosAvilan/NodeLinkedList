package org.uade.util;

import org.uade.structure.definition.QueueADT;
import org.uade.structure.implementation.Queue;
import org.uade.structure.exception.EmptyADTException;
import org.uade.structure.implementation.StaticQueue;

public class QueueUtil {
    public static QueueADT copy(QueueADT queue) {
        QueueADT newQueue = getNewQueue(queue);
        QueueADT temp = getNewQueue(queue);

        while (!queue.isEmpty()) {
            temp.add(queue.getElement());
            newQueue.add(queue.getElement());
            queue.remove();
        }
        while (!temp.isEmpty()) {
            queue.add(temp.getElement());
            temp.remove();
        }

        return newQueue;
    }


    public static void print(QueueADT queue) {
        if (queue.isEmpty()) {
            throw new EmptyADTException("La cola está vacía");
        }

        QueueADT myQueue = copy(queue);
        while (!myQueue.isEmpty()) {
            System.out.println(myQueue.getElement());
            myQueue.remove();
        }
    }

    public static QueueADT getNewQueue(QueueADT queue) {
        if (queue instanceof Queue) {
            return new Queue();
        } else {
            return new StaticQueue();
        }
    }
}
