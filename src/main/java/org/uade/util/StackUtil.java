package org.uade.util;
import org.uade.structure.definition.StackADT;
import org.uade.structure.implementation.Stack;
import org.uade.structure.implementation.StaticStack;
import org.uade.structure.exception.EmptyADTException;

public class StackUtil {
    public static StackADT copy(StackADT stack) {
        StackADT newStack = getNewStack(stack);
        StackADT temp = getNewStack(stack);

        while (!stack.isEmpty()) {
            temp.add(stack.getElement());
            stack.remove();
        }
        while (!temp.isEmpty()) {
            stack.add(temp.getElement());
            newStack.add(temp.getElement());
            temp.remove();
        }

        return newStack;
    }


    public static void print(StackADT stack) {
        if (stack.isEmpty()) {
            throw new EmptyADTException("La pila está vacía");
        }

        StackADT myStack = copy(stack);
        while (!myStack.isEmpty()) {
            System.out.println(myStack.getElement());
            myStack.remove();
        }
    }

    public static StackADT getNewStack(StackADT stack) {
        if (stack instanceof Stack) {
            return new Stack();
        } else {
            return new StaticStack();
        }
    }

}