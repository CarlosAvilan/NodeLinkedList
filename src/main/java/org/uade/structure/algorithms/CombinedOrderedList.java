package org.uade.structure.algorithms;

import org.uade.structure.implementation.LinkedList;

public class CombinedOrderedList {

    public static void main(String[] args) {
        LinkedList listA = new LinkedList();
        listA.add(10);
        listA.add(15);
        listA.add(20);
        LinkedList listB = new LinkedList();
        listB.add(1);
        listB.add(7);
        listB.add(14);
        listB.add(30);

        LinkedList mergedList = combinedOrderedList(listA, listB);
        System.out.println(mergedList);
    }

    public static LinkedList combinedOrderedList(LinkedList listA, LinkedList listB) {

        LinkedList listC = new LinkedList();

        int indexA = 0;
        int indexB = 0;

        while (indexA < listA.size() && indexB < listB.size()) {
            if (listA.get(indexA) <= listB.get(indexB)) {
                listC.add(listA.get(indexA));
                indexA++;
            } else {
                listC.add(listB.get(indexB));
                indexB++;
            }
        }

        while (indexA < listA.size()) {
            listC.add(listA.get(indexA));
            indexA++;
        }

        while (indexB < listB.size()) {
            listC.add(listB.get(indexB));
            indexB++;
        }

        return listC;
    }
}
