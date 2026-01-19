package pij.day12solutions.cashRegister.v01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Uncomment the next line to see (some of) the new test(s) fail.
//import pij.day12.cashRegister.CashRegister;

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

}
