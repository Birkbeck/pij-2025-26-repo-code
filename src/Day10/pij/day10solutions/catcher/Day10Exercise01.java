package pij.day10solutions.catcher;

public class Day10Exercise01 {
    // uncomment the following method to see whether the compiler is ok with it
    /*
    public static <E> void addElement(java.util.List<E> list, E newElement) {
        try {
            list.add(newElement);
        } catch (Exception e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
     */

    // The compiler is NOT okay with the method. The reason is that the
    // compiler knows that NullPointerException is a subclass of Exception.
    // However, if some Throwable is thrown in the try block, the first
    // exception handler that is tried is the first one in the program text,
    // the one for type Exception. If the Throwable is a NullPointerException,
    // the first exception handler is applicable because NullPointerException
    // is a subclass of Exception, and the second exception handler is never
    // asked. So the second exception handler is "unreachable code". The most
    // likely explanation is that this was not intended by the programmer, and
    // the compiler rejects the class. The programmer probably intended the
    // following (which is still dubious since we /should not/ catch Exception
    // nor NullPointerException, but at least the compiler accepts it):

    public static <E> void addElement(java.util.List<E> list, E newElement) {
        try {
            list.add(newElement);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
