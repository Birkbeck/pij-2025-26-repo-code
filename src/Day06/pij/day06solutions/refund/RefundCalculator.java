package pij.day06solutions.refund;

/**
 * Provides a method to calculate the refund in pence as a function
 * of the original ticket price and the delay of the train service.
 */
public class RefundCalculator {

    /** Constants for different minimum delays for corresponding refunds. */
    private static final int DELAY_MINS_1 = 15;
    private static final int DELAY_MINS_2 = 30;
    private static final int DELAY_MINS_3 = 60;

    /** Constants for different refund percentages depending on the delay. */
    private static final int REFUND_PERCENTAGE_0 = 0;
    private static final int REFUND_PERCENTAGE_1 = 15;
    private static final int REFUND_PERCENTAGE_2 = 30;
    private static final int REFUND_PERCENTAGE_3 = 100;

    /**
     * Calculates the refund in pence given the original ticket price
     * and the delay.
     *
     * @param priceInPence the original price of the ticket in pence
     * @param delayInMinutes the delay of the train service in minutes
     * @return the refund awarded in pence
     */
    public static int getRefundInPence(int priceInPence, int delayInMinutes) {
        if (priceInPence <= 0) { // no refund if the customer
            return 0;            // did not pay for the ticket
        }
        int percentage = delayToPercentage(delayInMinutes);
        int refundInPenceTimesHundred = priceInPence * percentage;
        int refundInPence = refundInPenceTimesHundred / 100;
        if (refundInPenceTimesHundred % 100 != 0) {
            // round up, so instead of 123.2 pence, we refund 124 pence
            refundInPence++;
        }
        return refundInPence;
    }

    /**
     * Converts the delay to a percentage of the price.
     *
     * @param delayInMinutes the delay of the train service in minutes
     * @return the percentage of the ticket price for the refund
     */
    private static int delayToPercentage(int delayInMinutes) {
        if (delayInMinutes < DELAY_MINS_1) {
            return REFUND_PERCENTAGE_0;
        }
        if (delayInMinutes < DELAY_MINS_2) {
            return REFUND_PERCENTAGE_1;
        }
        if (delayInMinutes < DELAY_MINS_3) {
            return REFUND_PERCENTAGE_2;
        }
        return REFUND_PERCENTAGE_3;
    }
}
