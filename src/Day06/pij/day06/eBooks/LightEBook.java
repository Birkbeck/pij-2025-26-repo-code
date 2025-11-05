package pij.day06.eBooks;

/**
 * A LightEBook is an EBook that additionally provides facilities
 * to set the light level.
 */
public class LightEBook extends EBook {
    /** The light level of the LightEBook. */
    private int lightLevel = 100;

    /**
     * Sets the light level to the value specified by the parameter.
     *
     * @param newLevel the new light level to set
     */
    public void setLight(int newLevel) {
        this.lightLevel = newLevel;
    }
}
