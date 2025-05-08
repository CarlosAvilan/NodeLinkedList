package org.uade.structure.algorithms;

import org.uade.structure.definition.PriorityQueueADT;
import org.uade.util.PriorityQueueUtil;

public class Atender {
    public static void incrementarPrioridad(PriorityQueueADT prioridad) {
        PriorityQueueADT temp = PriorityQueueUtil.getNewPriorityQueue(prioridad);
        boolean encontrado = false;
        int pacienteBuscado = -1;
        int prioridadBuscada = -1;

        while (!prioridad.isEmpty()) {
            int paciente = prioridad.getElement();
            int prioridadPaciente = prioridad.getPriority();

            if (prioridadPaciente == 1 && !encontrado) {
                pacienteBuscado = paciente;
                prioridadBuscada = prioridadPaciente;
                prioridad.remove();
                encontrado = true;
            } else {
                prioridad.remove();
                temp.add(paciente, prioridadPaciente);
            }
        }

        if (encontrado) {
            int aumentoPrioridad = prioridadBuscada + 1;
            temp.add(pacienteBuscado, aumentoPrioridad);
        }

        while (!temp.isEmpty()) {
            int paciente = temp.getElement();
            int prioridadPaciente = temp.getPriority();
            temp.remove();
            prioridad.add(paciente, prioridadPaciente);
        }
    }
}
