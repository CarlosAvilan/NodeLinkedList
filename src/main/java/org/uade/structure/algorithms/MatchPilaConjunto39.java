package org.uade.structure.algorithms;

import java.util.Random;
import org.uade.structure.definition.*;
import org.uade.structure.implementation.*;
import org.uade.util.SetUtil;
import org.uade.util.StackUtil;


public class MatchPilaConjunto39 {

    public static void main(String[] args) {
        StackADT stack = new Stack();
        SetADT set = new Set();
        Random rand = new Random();
        int size = rand.nextInt(7) + 1;


        for (int i = 0; i < size; i++) {
            int numero = rand.nextInt(8) + 1;
            stack.add(numero);
        }

        while (SetUtil.count(set) < size) {
            int numero = rand.nextInt(8) + 1;
            set.add(numero);
        }

        StackADT tempStack = StackUtil.copy(stack);
        SetADT tempSet = SetUtil.copy(set);
        SetADT resultSet = new Set();

        while (!tempStack.isEmpty()) {
            int element = tempStack.getElement();
            tempStack.remove();
            resultSet.add(element);
        }

        boolean match = true;

        if (SetUtil.count(resultSet) != SetUtil.count(tempSet)) {
            match = false;
        } else {
            while (!tempSet.isEmpty()) {
                int numero = tempSet.choose();
                tempSet.remove(numero);
                if (!resultSet.exist(numero)) {
                    match = false;
                }
            }
        }
        if (match) {
            System.out.println("Son iguales");
        } else {
            System.out.println("No son iguales");
        }

        StackUtil.print(stack);
        System.out.println("----");
        SetUtil.print(set);
    }
}
