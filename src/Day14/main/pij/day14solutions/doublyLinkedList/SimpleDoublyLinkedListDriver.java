package pij.day14solutions.doublyLinkedList;

import pij.day14.list.SimpleList;

/**
 * Driver class for interface SimpleList and class SimpleLinkedList.
 */
public class SimpleDoublyLinkedListDriver {


    private static SimpleDoublyLinkedList<Integer> makeTestData() {
        SimpleDoublyLinkedList<Integer> result = new SimpleDoublyLinkedList<>();
        result.add(0, 100);
        result.add(1, 101);
        result.add(2, 102);
        result.add(3, 103);
        return result;
    }

    public static void main(String[] args) {
        SimpleList<Integer> simpleList = new SimpleDoublyLinkedList<>();
        pij.day14solutions.list.SimpleListDriver.driveInteger(simpleList);

        SimpleDoublyLinkedList<Integer> myList = makeTestData();
        SimpleDoublyLinkedList<Integer> copy = new SimpleDoublyLinkedList<>(myList);
        System.out.println(myList);
        System.out.println(copy);
    }
}
