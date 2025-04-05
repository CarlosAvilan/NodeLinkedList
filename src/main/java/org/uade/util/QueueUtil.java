package org.uade.util;

import org.uade.structure.definition.QueueADT;
import org.uade.structure.implementation.Queue;

public class QueueUtil {
    public static QueueADT copy(QueueADT queue) {
        QueueADT newQueue = new Queue();
        QueueADT temp = new Queue();

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
        QueueADT myQueue = copy(queue);
        while (!myQueue.isEmpty()) {
            System.out.println(myQueue.getElement());
            myQueue.remove();
        }
    }
}
