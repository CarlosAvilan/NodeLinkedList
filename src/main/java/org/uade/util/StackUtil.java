package org.uade.util;
import org.uade.structure.definition.StackADT;
import org.uade.structure.implementation.Stack;

public class StackUtil {
    public static StackADT copy(StackADT stack) {
        StackADT newStack = new Stack();
        StackADT temp = new Stack();

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

    public static void print(StackADT stack) {
        StackADT myStack = copy(stack);
        while (!myStack.isEmpty()) {
            System.out.println(myStack.getElement());
            myStack.remove();
        }
    }
}