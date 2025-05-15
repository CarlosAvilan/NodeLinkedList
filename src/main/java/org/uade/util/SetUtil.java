
package org.uade.util;

import org.uade.structure.definition.SetADT;
import org.uade.structure.exception.EmptyADTException;
import org.uade.structure.implementation.StaticSet;
import org.uade.structure.implementation.Set;

public class SetUtil {

    public static SetADT copy(SetADT set) {
        SetADT temp = getNewSet(set);
        SetADT copia = getNewSet(set);
        while (!set.isEmpty()) {
            int numero = set.choose();
            temp.add(numero);
            copia.add(numero);
            set.remove(numero);
        }

        while (!temp.isEmpty()) {
            int numero = temp.choose();
            set.add(numero);
            temp.remove(numero);
        }
        return copia;
    }

    public static void print(SetADT set) {
        if (set.isEmpty()) {
            throw new EmptyADTException("El conjunto está vacío");
        }

        SetADT temp = copy(set);

        while (!temp.isEmpty()) {
            int numero = temp.choose();
            System.out.println(numero);
            temp.remove(numero);
        }
    }

    public static int count(SetADT set) {
        SetADT temp = copy(set);
        int count = 0;

        while (!temp.isEmpty()) {
            int numero = temp.choose();
            count++;
            temp.remove(numero);
        }
        return count;
    }

    public static SetADT getNewSet(SetADT set) {
        if (set instanceof Set) {
            return new Set();
        } else {
            return new StaticSet();
        }
    }
}

