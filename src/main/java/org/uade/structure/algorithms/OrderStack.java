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
        StackUtil.print(orderStack(dada));
        StackUtil.print(dada);
    }

    public static StackADT orderStack(StackADT stack) {
        StackADT ordered = new Stack();

        while (!stack.isEmpty()) {
            int temp = stack.getElement();
            stack.remove();

            while (!ordered.isEmpty() && (int) ordered.getElement() < temp) {
                stack.add(ordered.getElement());
                ordered.remove();
            }
            ordered.add(temp);
        }
        return ordered;
    }
}
