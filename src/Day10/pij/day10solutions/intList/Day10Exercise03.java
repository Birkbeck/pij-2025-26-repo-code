package pij.day10solutions.intList;

import java.util.ArrayList;
import java.util.List;

public class Day10Exercise03 {
    public void launch(int userInput) {
        List<Integer> intList = new ArrayList<Integer>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        intList.add(5);
        intList.add(6);
        try {
            intList.remove(0);
            System.out.println(intList.get(userInput));
            intList.remove(0);
            System.out.println(intList.get(userInput));
            intList.remove(0);
            System.out.println(intList.get(userInput));
            intList.remove(0);
            System.out.println(intList.get(userInput));
            intList.remove(0);
            System.out.println(intList.get(userInput));
            intList.remove(0);
            System.out.println(intList.get(userInput));
            intList.remove(0);
            System.out.println(intList.get(userInput));
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Day10Exercise03 launcher = new Day10Exercise03();
        //launcher.launch(0); // 1, 2, ..., 20, 21, 24, 25, 26
        //launcher.launch(2); // 1, 2, ..., 16, 17, 24, 25, 26
        //launcher.launch(4); // 1, 2, ..., 12, 13, 24, 25, 26
        //launcher.launch(6); // 1, 2, ..., 10, 11, 24, 25, 26
    }
}
