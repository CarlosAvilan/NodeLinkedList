package org;


//import org.uade.structure.implementation.LinkedList;//

import org.uade.structure.implementation.Stack;


public class Main {
    public static void main(String[] args) {

        Stack stack = new Stack();
        System.out.println(stack.isEmpty());

        stack.add(7);
        System.out.println(stack.getElement());
        stack.add(4);
        stack.add(12);
        System.out.println(stack);
        stack.remove();
        System.out.println(stack);


        /*
        LinkedList list = new LinkedList();
        System.out.println(list.isEmpty());
        System.out.println(list.size());

        list.add(10);
        list.add(20);
        list.add(34);
        list.add(8);
        list.add(3);
        System.out.println(list);

        list.insert(3, 15);
        System.out.println(list);

        System.out.println(list.get(1));
        System.out.println(list.get(3));
        System.out.println(list.get(4));

        list.remove(1);
        System.out.println(list);

        System.out.println(list.size());
        System.out.println(list.isEmpty());
        */
        }
    }
