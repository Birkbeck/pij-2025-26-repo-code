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
