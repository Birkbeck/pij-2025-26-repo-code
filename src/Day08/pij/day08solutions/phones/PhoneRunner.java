package pij.day08solutions.phones;

import pij.day06solutions.phones.MobilePhone;
import pij.day06solutions.phones.OldPhone;
import pij.day06solutions.phones.SmartPhone;

public class PhoneRunner {

    public static void testPhone(OldPhone phone) {
        phone.getBrand();
        phone.call("123");
        SmartPhone smart = (SmartPhone) phone; // beware, phone might not be a SmartPhone
        smart.playGame("Super Mario Land");
        smart.call("3");
        smart.browseWeb("def");
        smart.findPosition();
        smart.getBrand();
        smart.printLastNumbers();
    }

    public static void main(String[] args) {
        SmartPhone myPhone = new SmartPhone("ACME"); // Ex 2.1
        //MobilePhone myPhone = new SmartPhone("ACME"); // Ex 2.2
        myPhone.playGame("Tetris");
        myPhone.call("1234");
        myPhone.browseWeb("abc"); // does not work if myPhone is declared
        myPhone.findPosition();   // with type MobilePhone
        myPhone.getBrand();
        myPhone.printLastNumbers();
        testPhone(myPhone);

        MobilePhone mobilePhone = new MobilePhone("ACME");
        testPhone(mobilePhone); // Ex 2.5: throws ClassCastException
    }
}
