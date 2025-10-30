package pij.day06solutions.phones;

/**
 * A SmartPhone models a 2020s-style portable telephone with significant
 * computing power and apps to browse the web or find its position on the
 * planet's surface.
 */
public class SmartPhone extends MobilePhone {

    /**
     * Constructs a SmartPhone without a brand.
     */
    public SmartPhone() {
        super(); // do nothing here
    }

    /**
     * Constructs a SmartPhone with a given brand.
     *
     * @param brand the brand of this SmartPhone
     */
    public SmartPhone(String brand) {
        super(brand);
    }

    /**
     * Makes cheaper calls to international numbers via the internet. Does not
     * record the numbers of international calls in the call log.
     *
     * @param number the number to call
     */
    @Override
    public void call(String number) {
        final String INTERNATIONAL_PREFIX = "00";
        if (number.startsWith(INTERNATIONAL_PREFIX)) {
            // Note: this approach avoids the fees for the international call,
            // but it does not record the number among the most recently called
            // numbers (which may or may not be intended)
            System.out.println("Calling " + number + " through the internet to save money");
        } else {
            super.call(number);
        }
    }

    /**
     * Visits a web address.
     *
     * @param address the web address to visit
     */
    public void browseWeb(String address) {
        System.out.println("Browsing " + address + "...");
    }

    /**
     * Prints the position of this SmartPhone.
     */
    public void findPosition() {
        System.out.println("Coordinates TO DO");
    }
}
