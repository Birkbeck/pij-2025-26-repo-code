package pij.day06solutions.phones;

/**
 * An OldPhone models a classic telephone from the mid-20th century.
 * It can make a phone call, and that's all it can do!
 */
public class OldPhone {

    /** OldPhones for which no brand is chosen shall have this brand. */
    public static final String NO_BRAND = "No Name";

    /** The brand of this OldPhone. */
    private String brand;

    /**
     * Constructs an OldPhone without a brand.
     */
    public OldPhone() {
        this(OldPhone.NO_BRAND);
    }

    /**
     * Constructs an OldPhone with a given brand.
     *
     * @param brand the brand of this OldPhone
     */
    public OldPhone(String brand) {
        this.brand = brand;
    }

    /**
     * @return the brand of this OldPhone
     */
    public String getBrand() {
        return this.brand;
    }

    /**
     * Make a (simulated) phone call to a given number.
     *
     * @param number the number to call
     */
    public void call(String number) {
        System.out.println("Calling " + number + "...");
    }
}
