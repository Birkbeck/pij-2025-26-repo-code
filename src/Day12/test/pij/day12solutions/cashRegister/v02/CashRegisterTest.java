package pij.day12solutions.cashRegister.v02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

// Uncomment the next line with the import to see (some of) the new test(s)
// fail with the previous version of class CashRegister.
//import pij.day12solutions.cashRegister.v01.CashRegister;

class CashRegisterTest {
    @Test
    void testNumberOfItemsInCurrentSale_noItemsAdded() {
        CashRegister cashRegister = new CashRegister();
        int expected = 0;
        int actual = cashRegister.numberOfItemsInCurrentSale();
        assertEquals(expected, actual);
    }

    @Test
    void testNumberOfItemsInCurrentSale_oneItemPositiveValueAdded() {
        CashRegister cashRegister = new CashRegister();
        cashRegister.addItem(100);
        int expected = 1;
        int actual = cashRegister.numberOfItemsInCurrentSale();
        assertEquals(expected, actual);
    }

    @Test
    void testNumberOfItemsInCurrentSale_twoItemsPositiveValueAdded() {
        CashRegister cashRegister = new CashRegister();
        cashRegister.addItem(100);
        cashRegister.addItem(200);
        int expected = 2;
        int actual = cashRegister.numberOfItemsInCurrentSale();
        assertEquals(expected, actual);
    }

    @Test
    void testOneItemNegativeValueAdded() {
        CashRegister cashRegister = new CashRegister();
        assertThrows(IllegalArgumentException.class, () -> {
            cashRegister.addItem(-250);
        });
    }
}
