package org.uade.structure.algorithms;

import org.uade.structure.implementation.Stack;
import org.uade.structure.definition.StackADT;
import org.uade.util.StackUtil;

import static org.uade.util.StackUtil.copy;

public class OrderStack {

    public static void main(String[] args) {
        StackADT dada = new Stack();
        dada.add(7);
        dada.add(4);
        dada.add(1);
        dada.add(16);
        dada.add(9);

        StackUtil.print(dada);
        System.out.println("---");
        StackUtil.print(orderStack(dada));
        System.out.println("---");
        StackUtil.print(dada);
    }

    public static StackADT orderStack(StackADT stack) {
        StackADT ordered = new Stack();
        StackADT copyStack = copy(stack);

        while (!copyStack.isEmpty()) {
            int temp = copyStack.getElement();
            copyStack.remove();

            while (!ordered.isEmpty() && ordered.getElement() < temp) {
                copyStack.add(ordered.getElement());
                ordered.remove();
            }
            ordered.add(temp);
        }
        return ordered;
    }
}
