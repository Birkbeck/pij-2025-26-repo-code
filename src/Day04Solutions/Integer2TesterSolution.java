public class Integer2TesterSolution {
    public static void main(String[] args) {
        Integer2 i2 = new Integer2();
        System.out.print("Enter a number: ");
        java.util.Scanner scan = new java.util.Scanner(System.in);
        int i = scan.nextInt();
        i2.setValue(i);
        System.out.print("The number you entered is ");
        if (i2.isEven()) {
            System.out.println("even.");
        } else if (i2.isOdd()) {
            System.out.println("odd.");
        } else {
            System.out.println("undefined!! Your code is buggy!");
        }
        int parsedInt = Integer.parseInt(i2.toString());
        if (parsedInt == i2.getValue()) {
            System.out.println("Your toString() method seems to work fine.");
        }

        Integer2 otherInteger2 = new Integer2(3);
        otherInteger2.prettyPrint(); // run this method, too
    }
}
