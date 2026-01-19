package pij.day12solutions.cashRegister.v07;

// This is the version of CashRegister based on v06, but additionally
// allowing all the tests in v07/CashRegisterTest to pass.

import java.util.ArrayList;
import java.util.List;

/**
 * A CashRegister can add items to a sale, undo such additions, and
 * state how many items are on the current sake. It can also complete
 * a sale, be queried for how many sales have been finished, and be
 * queried for the amount spent on completed sales. All monetary
 * quantities are integer values in Pence.
 */
public class CashRegister {

    // adding the undo() feature requires our first significant change to the
    // way CashRegister represents its state, by changing the fields to use a
    // List<Integer> to which we can add items and from which we can remove
    // items (for undo())

    private List<Integer> itemsCurrentSale;

    /**
     * Initialises a new CashRegister without any prior items and sales.
     */
    public CashRegister() {
        // we add and remove only at one end of the list
        // => ArrayList should give us the desired performance
        itemsCurrentSale = new ArrayList<>();
    }

    /**
     * Adds an item to the current sale.
     *
     * @param priceInPence the item's price
     * @throws IllegalArgumentException if priceInPence is -1 or less
     */
    public void addItem(int priceInPence) {
        if (priceInPence <= -1) {
            throw new IllegalArgumentException("priceInPence must be 0 or greater!");
        }
        itemsCurrentSale.add(priceInPence);
    }

    /**
     * Adds all items in the method parameter to the current sale.
     *
     * @param pricesInPence contains the items to be added
     * @throws NullPointerException if pricesInPence is the null reference
     * @throws IllegalArgumentException if pricesInPence contains a value that
     *  is -1 or less
     */
    public void addItems(int[] pricesInPence) {
        for (int item : pricesInPence) {
            // do not duplicate the implementation of addItem(int),
            // but call the method to reuse it (its implementation
            // may change in the future!)
            // ... after the change to List<Integer> for the field:
            // good thing that we used a method call here instead of
            // spelling the modification to the field(s) out again!
            addItem(item);
        }
    }

    /**
     * Returns the number of items in the current sale.
     *
     * @return the number of items in the current sale.
     */
    public int numberOfItemsInCurrentSale() {
        return itemsCurrentSale.size();
    }

    /**
     * Returns the total amount in pence of the currently happening sale.
     *
     * @return the total amount in pence of the currently happening sale
     */
    public int getTotalAmountInPenceCurrentSale() {
        int result = 0;
        for (int item : itemsCurrentSale) {
            result += item;
        }
        return result;
    }

    /**
     * Removes the last added item from the current sale if there is such
     * an item. Also in case items were added via the addItems(int[])
     * method, only a single item is removed. Does not modify the object
     * state if there is no item to remove from the current sale. Does
     * not affect previous sales.
     *
     * @return whether an item was removed
     */
    public boolean undo() {
        if (itemsCurrentSale.isEmpty()) {
            return false;
        }
        itemsCurrentSale.removeLast();
        return true;
    }

    /**
     * Completes the current sale and starts a new sale.
     *
     * @return the amount from the completed sale
     */
    public int completeSale() {
        int result = getTotalAmountInPenceCurrentSale();
        itemsCurrentSale.clear();
        return result;
    }

    /**
     * Returns the number of sales completed so far.
     *
     * @return the number of sales completed so far
     */
    public int getNumberOfCompletedSales() {
        return 0; // TODO Auto-generated method stub
    }

    /**
     * Returns the total amount in pence of the completed sales.
     * Since the current sale can still be undone, it is not
     * considered by this method.
     *
     * @return the total amount in pence of the completed sales
     *  (but excludes the current incomplete sale)
     */
    public int getTotalAmountInPenceOfCompletedSales() {
        return 0; // TODO Auto-generated method stub
    }
}
