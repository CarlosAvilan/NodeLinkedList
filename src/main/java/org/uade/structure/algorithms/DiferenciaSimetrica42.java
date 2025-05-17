package org.uade.structure.algorithms;

import org.uade.structure.definition.SetADT;
import org.uade.structure.implementation.Set;
import org.uade.util.SetUtil;

public class DiferenciaSimetrica42 {
    public static void main(String[] args) {

        SetADT conjunto1 = new Set();
        SetADT conjunto2 = new Set();

        conjunto1.add(7);
        conjunto1.add(2);
        conjunto1.add(5);
        conjunto1.add(11);

        conjunto2.add(18);
        conjunto2.add(7);
        conjunto2.add(2);
        conjunto2.add(4);

        SetADT resultado = diferenciaSim(conjunto1, conjunto2);
        System.out.println("El conjunto resultante es el siguiente:");
        SetUtil.print(resultado);
    }

    public static SetADT diferenciaSim(SetADT conjunto1, SetADT conjunto2) {
        SetADT resultado = new Set();

        SetADT copia1 = SetUtil.copy(conjunto1);
        SetADT copia2 = SetUtil.copy(conjunto2);

        while (!copia1.isEmpty()) {
            int element = copia1.choose();
            copia1.remove(element);
            if (!conjunto2.exist(element)) {
                resultado.add(element);
            }
        }

        while (!copia2.isEmpty()) {
            int element = copia2.choose();
            copia2.remove(element);
            if (!conjunto1.exist(element)) {
                resultado.add(element);
            }
        }
        return resultado;
    }
}
