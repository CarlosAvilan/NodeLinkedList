package org.uade.structure.algorithms;

import org.uade.structure.definition.QueueADT;
import org.uade.util.QueueUtil;
import org.uade.structure.implementation.Queue;

public class RemoveElementRecursion {

    public static void main(String[] args) {
        QueueADT queue = new Queue();

        queue.add(17);
        queue.add(81);
        queue.add(29);
        queue.add(40);

        QueueUtil.print(queue);
        System.out.println("---");
        int removeValue = 81;
        removeElementRecursion(queue, removeValue);
        QueueUtil.print(queue);
    }



    //metodo publico que engloba (y luego ordena) y dentro privado de remover elemento

    public static void removeElementRecursion(QueueADT queue, int value) {
        if (queue.isEmpty()) {
            return;
        }

        int currentValue = queue.getElement();
        queue.remove();

        removeElementRecursion(queue, value);

        if (currentValue != value) {
            queue.add(currentValue);
        }
    }
    //segunda recursion para voltearlo otra vez, ya sin el elemento
}

