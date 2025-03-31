package org.uade.util;

import org.uade.structure.implementation.Stack;

public class StackUtil {
    public static Stack copy(Stack stack) {
        Stack newStack = new Stack();
        Stack temp = new Stack();

        while (!stack.isEmpty()) {
            temp.add(stack.getElement());
            stack.remove();
        }
        while (!temp.isEmpty()) {
            stack.add(temp.getElement());
            newStack.add(stack.getElement());
            temp.remove();
        }

        return newStack;
    }
}