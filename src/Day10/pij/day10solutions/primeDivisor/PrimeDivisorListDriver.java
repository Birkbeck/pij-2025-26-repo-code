package pij.day10solutions.primeDivisor;

public class PrimeDivisorListDriver {
    public static void main(String[] args) {
        PrimeDivisorList list = new PrimeDivisorList();
        list.add(3);
        list.add(2);
        list.add(7);
        list.add(3);
        list.add(11);
        list.remove(4);
        System.out.println(list);
        //list.add(null); // NullPointerException
        //list.add(15); // IllegalArgumentException
    }
}
