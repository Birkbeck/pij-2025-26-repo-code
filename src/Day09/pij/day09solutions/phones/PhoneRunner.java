package pij.day09solutions.phones;

import java.util.LinkedHashSet;
import java.util.Set;

// Exercises 5 - 7.
public class PhoneRunner {
    public static void main(String[] args) {
        final String brand = "ACME";

        OldPhone old1 = new OldPhone(brand);
        OldPhone old2 = new OldPhone(brand);

        MobilePhone mobile1 = new MobilePhone(brand);
        MobilePhone mobile2 = new MobilePhone(brand);

        SmartPhone smart1 = new SmartPhone(brand);
        SmartPhone smart2 = new SmartPhone(brand);

        Set<OldPhone> set = new LinkedHashSet<>();
        set.add(old1);
        set.add(mobile1);
        set.add(smart1);

        System.out.println("set.contains(old2): " + set.contains(old2));
        System.out.println("set.contains(mobile2): " + set.contains(mobile2));
        System.out.println("set.contains(smart2): " + set.contains(smart2));
    }
}
