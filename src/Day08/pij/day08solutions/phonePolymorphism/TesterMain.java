package pij.day08solutions.phonePolymorphism;

import pij.day06solutions.phones.MobilePhone;
import pij.day06solutions.phones.OldPhone;
import pij.day08.phonePolymorphism.SimpleTester;
import pij.day08.phonePolymorphism.SpecialTester;

// Ex 3
public class TesterMain {
    public static void main(String[] args) {
        OldPhone old = new OldPhone("ACME classic");
        MobilePhone mobile = new MobilePhone("ACME");
        OldPhone mobileAsOld = mobile;

        SimpleTester simple = new SimpleTester();
        SpecialTester special = new SpecialTester();
        SimpleTester specialAsSimple = special;

        // The compiler sees the type SimpleTester for simple and the type
        // OldPhone for old. It irrevocably selects the method signature
        // test(OldPhone) to be used for the following method call.
        // The JVM looks at the object behind the reference simple. It sees
        // an object of class SimpleTester. It checks class SimpleTester
        // whether it has an implementation for the method test(OldPhone).
        // The answer is 'yes', so the JVM runs this method.
        simple.test(old); // prints: simple test old

        // The compiler sees the type SimpleTester for simple and the type
        // MobilePhone for mobile. It irrevocably selects the method signature
        // test(OldPhone) to be used for the following method call (with
        // implicit upcast of the MobilePhone reference).
        // The JVM looks at the object behind the reference simple. It sees
        // an object of class SimpleTester. It checks class SimpleTester
        // whether it has an implementation for the method test(OldPhone).
        // The answer is 'yes', so the JVM runs this method.
        simple.test(mobile); // prints: simple test old

        // The compiler sees the type SimpleTester for simple and the type
        // OldPhone for mobileAsOld. It irrevocably selects the method signature
        // test(OldPhone) to be used for the following method call.
        // The JVM looks at the object behind the reference simple. It sees
        // an object of class SimpleTester. It checks class SimpleTester
        // whether it has an implementation for the method test(OldPhone).
        // The answer is 'yes', so the JVM runs this method.
        simple.test(mobileAsOld); // prints: simple test old
        System.out.println();

        // The compiler sees the type SpecialTester for special and the type
        // OldPhone for old. It irrevocably selects the method signature
        // test(OldPhone) to be used for the following method call.
        // The JVM looks at the object behind the reference special. It sees
        // an object of class SpecialTester. It checks class SpecialTester
        // whether it has an implementation for the method test(OldPhone).
        // The answer is 'yes', so the JVM runs this method.
        special.test(old); // prints: special test old

        // The compiler sees the type SpecialTester for special and the type
        // MobilePhone for mobile. It irrevocably selects the method signature
        // test(MobilePhone) to be used for the following method call.
        // The JVM looks at the object behind the reference special. It sees
        // an object of class SpecialTester. It checks class SpecialTester
        // whether it has an implementation for the method test(MobilePhone).
        // The answer is 'yes', so the JVM runs this method.
        special.test(mobile); // prints: special test mobile

        // The compiler sees the type SpecialTester for special and the type
        // OldPhone for mobileAsOld. It irrevocably selects the method signature
        // test(OldPhone) to be used for the following method call.
        // The JVM looks at the object behind the reference special. It sees
        // an object of class SpecialTester. It checks class SpecialTester
        // whether it has an implementation for the method test(OldPhone).
        // The answer is 'yes', so the JVM runs this method.
        special.test(mobileAsOld); // prints: special test old
        System.out.println();

        // The compiler sees the type SimpleTester for specialAsSimple and the type
        // OldPhone for old. It irrevocably selects the method signature
        // test(OldPhone) to be used for the following method call.
        // The JVM looks at the object behind the reference simple. It sees
        // an object of class SpecialTester. It checks class SpecialTester
        // whether it has an implementation for the method test(OldPhone).
        // The answer is 'yes', so the JVM runs this method.
        specialAsSimple.test(old); // prints: special test old


        // The compiler sees the type SimpleTester for specialAsSimple and the type
        // MobilePhone for mobile. It irrevocably selects the method signature
        // test(OldPhone) to be used for the following method call (with
        // implicit upcast of the MobilePhone reference).
        // The JVM looks at the object behind the reference simple. It sees
        // an object of class SpecialTester. It checks class SpecialTester
        // whether it has an implementation for the method test(OldPhone).
        // The answer is 'yes', so the JVM runs this method.
        specialAsSimple.test(mobile); // prints: special test old

        // The compiler sees the type SimpleTester for specialAsSimple and the type
        // OldPhone for mobileAsOld. It irrevocably selects the method signature
        // test(OldPhone) to be used for the following method call.
        // The JVM looks at the object behind the reference specialAsSimple. It sees
        // an object of class SpecialTester. It checks class SpecialTester
        // whether it has an implementation for the method test(OldPhone).
        // The answer is 'yes', so the JVM runs this method.
        specialAsSimple.test(mobileAsOld); // prints: special test old
        System.out.println();

        // The compiler sees the type SimpleTester for simple and the type
        // OldPhone for old. It irrevocably selects the method signature
        // ring(OldPhone) to be used for the following method call.
        // The JVM looks at the object behind the reference simple. It sees
        // an object of class SimpleTester. It checks class SimpleTester
        // whether it has an implementation for the method ring(OldPhone).
        // The answer is 'yes', so the JVM runs this method.
        simple.ring(old); // prints: simple ring old

        // The compiler sees the type SimpleTester for simple and the type
        // MobilePhone for mobile. It irrevocably selects the method signature
        // ring(OldPhone) to be used for the following method call (with
        // implicit upcast of the MobilePhone reference).
        // The JVM looks at the object behind the reference simple. It sees
        // an object of class SimpleTester. It checks class SimpleTester
        // whether it has an implementation for the method ring(OldPhone).
        // The answer is 'yes', so the JVM runs this method.
        simple.ring(mobile); // prints: simple ring old

        // The compiler sees the type SimpleTester for simple and the type
        // OldPhone for mobileAsOld. It irrevocably selects the method signature
        // ring(OldPhone) to be used for the following method call.
        // The JVM looks at the object behind the reference simple. It sees
        // an object of class SimpleTester. It checks class SimpleTester
        // whether it has an implementation for the method ring(OldPhone).
        // The answer is 'yes', so the JVM runs this method.
        simple.ring(mobileAsOld); // prints: simple ring old
        System.out.println();

        // The compiler sees the type SpecialTester for special and the type
        // OldPhone for old. It irrevocably selects the method signature
        // ring(OldPhone) (inherited from SimpleTester) to be used for the
        // following method call.
        // The JVM looks at the object behind the reference special. It sees
        // an object of class SpecialTester. It checks class SpecialTester
        // whether it has an implementation for the method ring(OldPhone).
        // The answer is 'no', so the JVM checks its superclass SimpleTester
        // whether it has an implementation for the method ring(OldPhone).
        // The answer is 'yes', so the JVM runs this method.
        special.ring(old); // prints: simple ring old


        // The compiler sees the type SpecialTester for special and the type
        // MobilePhone for mobile. It irrevocably selects the method signature
        // ring(MobilePhone) to be used for the following method call.
        // The JVM looks at the object behind the reference special. It sees
        // an object of class SpecialTester. It checks class SpecialTester
        // whether it has an implementation for the method ring(MobilePhone).
        // The answer is 'yes', so the JVM runs this method.
        special.ring(mobile); // prints: special ring mobile

        // The compiler sees the type SpecialTester for special and the type
        // OldPhone for mobileAsOld. It irrevocably selects the method signature
        // ring(OldPhone) (inherited from SimpleTester) to be used for the
        // following method call.
        // The JVM looks at the object behind the reference special. It sees
        // an object of class SpecialTester. It checks class SpecialTester
        // whether it has an implementation for the method ring(OldPhone).
        // The answer is 'no', so the JVM checks its superclass SimpleTester
        // whether it has an implementation for the method ring(OldPhone).
        // The answer is 'yes', so the JVM runs this method.
        special.ring(mobileAsOld); // prints: simple ring old
        System.out.println();

        // The compiler sees the type SimpleTester for specialAsSimple and the type
        // OldPhone for old. It irrevocably selects the method signature
        // ring(OldPhone) to be used for the following method call.
        // The JVM looks at the object behind the reference simple. It sees
        // an object of class SpecialTester. It checks class SpecialTester
        // whether it has an implementation for the method ring(OldPhone).
        // The answer is 'no', so the JVM checks its superclass SimpleTester
        // whether it has an implementation for the method ring(OldPhone).
        // The answer is 'yes', so the JVM runs this method.
        specialAsSimple.ring(old); // prints: simple ring old

        // The compiler sees the type SimpleTester for specialAsSimple and the type
        // MobilePhone for mobile. It irrevocably selects the method signature
        // ring(OldPhone) to be used for the following method call (with
        // implicit upcast of the MobilePhone reference).
        // The JVM looks at the object behind the reference specialAsSimple. It sees
        // an object of class SpecialTester. It checks class SpecialTester
        // whether it has an implementation for the method ring(OldPhone).
        // The answer is 'no', so the JVM checks its superclass SimpleTester
        // whether it has an implementation for the method ring(OldPhone).
        // The answer is 'yes', so the JVM runs this method.
        specialAsSimple.ring(mobile); // prints: simple ring old

        // The compiler sees the type SimpleTester for specialAsSimple and the type
        // OldPhone for mobileAsOld. It irrevocably selects the method signature
        // ring(OldPhone) to be used for the following method call.
        // The JVM looks at the object behind the reference specialAsSimple. It sees
        // an object of class SpecialTester. It checks class SpecialTester
        // whether it has an implementation for the method ring(OldPhone).
        // The answer is 'no', so the JVM checks its superclass SimpleTester
        // whether it has an implementation for the method ring(OldPhone).
        // The answer is 'yes', so the JVM runs this method.
        specialAsSimple.ring(mobileAsOld); // prints: simple ring old
    }
}
