package pij.day08.phonePolymorphism;

import pij.day06solutions.phones.MobilePhone;
import pij.day06solutions.phones.OldPhone;

public class SpecialTester extends SimpleTester {
    public void test(OldPhone p) {
        System.out.println("special test old");
    }
    public void test(MobilePhone m) {
        System.out.println("special test mobile");
    }
    public void ring(MobilePhone m) {
        System.out.println("special ring mobile");
    }
}
