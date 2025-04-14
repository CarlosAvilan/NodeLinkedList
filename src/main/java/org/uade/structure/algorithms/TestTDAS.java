package org.uade.structure.algorithms;

import org.uade.structure.definition.*;
import org.uade.structure.implementation.*;
import org.uade.util.*;
import org.uade.structure.exception.*;

public class TestTDAS {

    public static void main(String[] args) {

        /*
        LinkedListADT lista = new StaticLinkedList();
        System.out.println(lista.isEmpty());
        lista.add(1);
        lista.add(21);
        lista.add(8);
        System.out.println(lista.size());
        LinkedListUtil.print(lista);
        System.out.println(lista.isEmpty());
        System.out.println("---");

        lista.insert(1, 80);
        int value = lista.get(2);
        LinkedListUtil.print(lista);
        System.out.println(value);
        int valueDos = lista.get(0);
        lista.remove(2);
        System.out.println(valueDos);
        LinkedListUtil.print(lista);
        System.out.println("---");

        lista.insert(0, 120);
        LinkedListUtil.print(lista);
        System.out.println(lista.size());
        int valueTres = lista.get(3);
        System.out.println(valueTres);
        System.out.println("Fin");
        */



        /*
        StackADT pila = new Stack();
        pila.add(34);
        pila.add(23);
        StackUtil.print(pila);
        System.out.println("---");

        System.out.println(pila.isEmpty());
        pila.remove();
        StackUtil.print(pila);
        pila.remove();
        System.out.println(pila.isEmpty());
        System.out.println("---");

        pila.add(10);
        pila.add(19);
        pila.add(28);
        pila.add(31);
        StackUtil.print(pila);
        int value = pila.getElement();
        System.out.println(value);
        System.out.println("Fin");
        */


        /*
        QueueADT cola = new StaticQueue();
        System.out.println(cola.isEmpty());

        cola.add(18);
        int value = cola.getElement();
        System.out.println(value);
        cola.remove();
        cola.add(1);
        int valueDos = cola.getElement();
        System.out.println(valueDos);
        cola.add(22);
        cola.add(33);
        QueueUtil.print(cola);

        System.out.println("---");

        cola.add(11);
        cola.remove();
        cola.add(8);
        QueueUtil.print(cola);
        int contador = QueueUtil.count(cola);
        System.out.println(contador);
        System.out.println("---");

        cola.add(9);
        QueueADT copiaCola = QueueUtil.copy(cola);
        QueueUtil.print(copiaCola);
        System.out.println("Fin");
        */


        PriorityQueueADT prioridad = new PriorityQueue();
        System.out.println(prioridad.isEmpty());

        prioridad.add(10, 4);
        prioridad.add(20, 5);
        prioridad.add(8, 3);
        prioridad.add(4, 2);
        prioridad.add(6, 7);

        PriorityQueueUtil.print(prioridad);
        int contador = PriorityQueueUtil.count(prioridad);
        System.out.println(contador);
        System.out.println("---");

        prioridad.remove();
        int contadorDos = PriorityQueueUtil.count(prioridad);
        System.out.println(contadorDos);
        PriorityQueueUtil.print(prioridad);

        System.out.println("---");
        prioridad.add(18, 1);
        prioridad.add(29, 10);
        PriorityQueueUtil.print(prioridad);

        System.out.println("---");
        PriorityQueueADT copia = PriorityQueueUtil.copy(prioridad);
        PriorityQueueUtil.print(copia);

        System.out.println("---");
        int prior = prioridad.getPriority();
        int value = prioridad.getElement();
        System.out.println("Prioridad: " + prior);
        System.out.println("Value: " + value);
        System.out.println("---");

        prioridad.remove();
        int priorDos = prioridad.getPriority();
        int valueDos = prioridad.getElement();
        System.out.println("Prioridad: " + priorDos);
        System.out.println("Value: " + valueDos);
        System.out.println("---");

        prioridad.add(11, 20);
        int valueTres = prioridad.getElement();
        int priorTres = prioridad.getPriority();
        System.out.println("Prioridad: " + priorTres);
        System.out.println("Value: " + valueTres);
        PriorityQueueUtil.print(prioridad);
        System.out.println("Fin");

    }
}
