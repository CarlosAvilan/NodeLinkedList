package org.uade.structure.algorithms;

//Pasar de una pila a otra en orden inverso

import org.uade.structure.definition.StackADT;
import org.uade.structure.implementation.*;
import org.uade.util.StackUtil;

public class ReverseStack {
    public static void main(String[] args) {
        StackADT original = new Stack();
        original.add(9);
        original.add(12);
        original.add(8);
        original.add(4);
        StackUtil.print(original);

        System.out.println("---");

        StackADT reversed = new Stack();
        while (!original.isEmpty()) {
            int element = original.getElement();
            original.remove();
            reversed.add(element);
        }
        StackUtil.print(reversed);
    }
}
