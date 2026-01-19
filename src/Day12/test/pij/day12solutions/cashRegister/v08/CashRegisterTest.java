package pij.day12solutions.cashRegister.v08;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Uncomment the next line with the import to see (some of) the new test(s)
// fail with the previous version of class CashRegister.
//import pij.day12solutions.cashRegister.v07.CashRegister;

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

    @Test
    void testNumberOfItemsInCurrentSale_addItemsEmpty() {
        CashRegister cashRegister = new CashRegister();
        cashRegister.addItems(new int[0]);
        int expected = 0;
        int actual = cashRegister.numberOfItemsInCurrentSale();
        assertEquals(expected, actual);
    }

    @Test
    void testNumberOfItemsInCurrentSale_addItemsOnePositiveValue() {
        CashRegister cashRegister = new CashRegister();
        cashRegister.addItems(new int[] { 150 } );
        int expected = 1;
        int actual = cashRegister.numberOfItemsInCurrentSale();
        assertEquals(expected, actual);
    }

    @Test
    void testNumberOfItemsInCurrentSale_addItemsTwoPositiveValues() {
        CashRegister cashRegister = new CashRegister();
        cashRegister.addItems(new int[] { 150, 350 } );
        int expected = 2;
        int actual = cashRegister.numberOfItemsInCurrentSale();
        assertEquals(expected, actual);
    }

    @Test
    void testAddItemsTwoPositiveAndANegativeValue() {
        CashRegister cashRegister = new CashRegister();
        assertThrows(IllegalArgumentException.class, () -> {
            cashRegister.addItems(new int[] { 150, -200, 350 } );
        });
    }

    @Test
    void testAddItemsNull() {
        CashRegister cashRegister = new CashRegister();
        assertThrows(NullPointerException.class, () -> {
            cashRegister.addItems(null);
        });
    }

    @Test
    void testGetTotalAmountInPenceCurrentSale_noItemsAdded() {
        CashRegister cashRegister = new CashRegister();
        int expected = 0;
        int actual = cashRegister.getTotalAmountInPenceCurrentSale();
        assertEquals(expected, actual);
    }

    @Test
    void testGetTotalAmountInPenceCurrentSale_oneItemPositiveValueAdded() {
        CashRegister cashRegister = new CashRegister();
        cashRegister.addItem(100);
        int expected = 100;
        int actual = cashRegister.getTotalAmountInPenceCurrentSale();
        assertEquals(expected, actual);
    }

    @Test
    void testGetTotalAmountInPenceCurrentSale_twoItemsPositiveValueAdded() {
        CashRegister cashRegister = new CashRegister();
        cashRegister.addItem(100);
        cashRegister.addItem(200);
        int expected = 300;
        int actual = cashRegister.getTotalAmountInPenceCurrentSale();
        assertEquals(expected, actual);
    }

    @Test
    void testGetTotalAmountInPenceCurrentSale_addItemsEmpty() {
        CashRegister cashRegister = new CashRegister();
        cashRegister.addItems(new int[0]);
        int expected = 0;
        int actual = cashRegister.getTotalAmountInPenceCurrentSale();
        assertEquals(expected, actual);
    }

    @Test
    void testGetTotalAmountInPenceCurrentSale_addItemsOnePositiveValue() {
        CashRegister cashRegister = new CashRegister();
        cashRegister.addItems(new int[] { 150 } );
        int expected = 150;
        int actual = cashRegister.getTotalAmountInPenceCurrentSale();
        assertEquals(expected, actual);
    }

    @Test
    void testGetTotalAmountInPenceCurrentSale_addItemsTwoPositiveValues() {
        CashRegister cashRegister = new CashRegister();
        cashRegister.addItems(new int[] { 150, 350 } );
        int expected = 500;
        int actual = cashRegister.getTotalAmountInPenceCurrentSale();
        assertEquals(expected, actual);
    }

    @Test
    void testNumberOfItemsInCurrentSale_noItemsAdded_undo() {
        CashRegister cashRegister = new CashRegister();
        cashRegister.undo();
        int expected = 0;
        int actual = cashRegister.numberOfItemsInCurrentSale();
        assertEquals(expected, actual);
    }

    @Test
    void testNumberOfItemsInCurrentSale_oneItemPositiveValueAdded_undo() {
        CashRegister cashRegister = new CashRegister();
        cashRegister.addItem(100);
        cashRegister.undo();
        int expected = 0;
        int actual = cashRegister.numberOfItemsInCurrentSale();
        assertEquals(expected, actual);
    }

    @Test
    void testNumberOfItemsInCurrentSale_twoItemsPositiveValueAdded_undo() {
        CashRegister cashRegister = new CashRegister();
        cashRegister.addItem(100);
        cashRegister.addItem(200);
        cashRegister.undo();
        int expected = 1;
        int actual = cashRegister.numberOfItemsInCurrentSale();
        assertEquals(expected, actual);
    }

    @Test
    void testGetTotalAmountInPenceCurrentSale_addItemsEmpty_undo() {
        CashRegister cashRegister = new CashRegister();
        cashRegister.addItems(new int[0]);
        cashRegister.undo();
        int expected = 0;
        int actual = cashRegister.getTotalAmountInPenceCurrentSale();
        assertEquals(expected, actual);
    }

    @Test
    void testGetTotalAmountInPenceCurrentSale_addItemsOnePositiveValue_undo() {
        CashRegister cashRegister = new CashRegister();
        cashRegister.addItems(new int[] { 150 } );
        cashRegister.undo();
        int expected = 0;
        int actual = cashRegister.getTotalAmountInPenceCurrentSale();
        assertEquals(expected, actual);
    }

    @Test
    void testGetTotalAmountInPenceCurrentSale_addItemsTwoPositiveValues_undo() {
        CashRegister cashRegister = new CashRegister();
        cashRegister.addItems(new int[] { 150, 350 } );
        cashRegister.undo();
        int expected = 150;
        int actual = cashRegister.getTotalAmountInPenceCurrentSale();
        assertEquals(expected, actual);
    }

    @Test
    void testNumberOfItemsInCurrentSale_noItemsAdded_undo_result() {
        CashRegister cashRegister = new CashRegister();
        boolean actual = cashRegister.undo();
        assertFalse(actual);
    }

    @Test
    void testNumberOfItemsInCurrentSale_oneItemPositiveValueAdded_undo_result() {
        CashRegister cashRegister = new CashRegister();
        cashRegister.addItem(100);
        boolean actual = cashRegister.undo();
        assertTrue(actual);
    }

    @Test
    void testNumberOfItemsInCurrentSale_twoItemsPositiveValueAdded_undo_result() {
        CashRegister cashRegister = new CashRegister();
        cashRegister.addItem(100);
        cashRegister.addItem(200);
        boolean actual = cashRegister.undo();
        assertTrue(actual);
    }

    @Test
    void testNumberOfItemsInCurrentSale_noItemsAdded_completeSale() {
        CashRegister cashRegister = new CashRegister();
        cashRegister.completeSale();
        int expected = 0;
        int actual = cashRegister.numberOfItemsInCurrentSale();
        assertEquals(expected, actual);
    }

    @Test
    void testNumberOfItemsInCurrentSale_oneItemPositiveValueAdded_completeSale() {
        CashRegister cashRegister = new CashRegister();
        cashRegister.addItem(100);
        cashRegister.completeSale();
        int expected = 0;
        int actual = cashRegister.numberOfItemsInCurrentSale();
        assertEquals(expected, actual);
    }

    @Test
    void testNumberOfItemsInCurrentSale_twoItemsPositiveValueAdded_completeSale() {
        CashRegister cashRegister = new CashRegister();
        cashRegister.addItem(100);
        cashRegister.addItem(200);
        cashRegister.completeSale();
        int expected = 0;
        int actual = cashRegister.numberOfItemsInCurrentSale();
        assertEquals(expected, actual);
    }

    @Test
    void testGetTotalAmountInPenceCurrentSale_noItemsAdded_completeSale() {
        CashRegister cashRegister = new CashRegister();
        cashRegister.completeSale();
        int expected = 0;
        int actual = cashRegister.getTotalAmountInPenceCurrentSale();
        assertEquals(expected, actual);
    }

    @Test
    void testGetTotalAmountInPenceCurrentSale_oneItemPositiveValueAdded_completeSale() {
        CashRegister cashRegister = new CashRegister();
        cashRegister.addItem(100);
        cashRegister.completeSale();
        int expected = 0;
        int actual = cashRegister.getTotalAmountInPenceCurrentSale();
        assertEquals(expected, actual);
    }

    @Test
    void testGetTotalAmountInPenceCurrentSale_twoItemsPositiveValueAdded_completeSale() {
        CashRegister cashRegister = new CashRegister();
        cashRegister.addItem(100);
        cashRegister.addItem(200);
        cashRegister.completeSale();
        int expected = 0;
        int actual = cashRegister.getTotalAmountInPenceCurrentSale();
        assertEquals(expected, actual);
    }

    @Test
    void testNoItemsAdded_completeSale_result() {
        CashRegister cashRegister = new CashRegister();
        int expected = 0;
        int actual = cashRegister.completeSale();
        assertEquals(expected, actual);
    }

    @Test
    void testOneItemPositiveValueAdded_completeSale_result() {
        CashRegister cashRegister = new CashRegister();
        cashRegister.addItem(100);
        int expected = 100;
        int actual = cashRegister.completeSale();
        assertEquals(expected, actual);
    }

    @Test
    void testTwoItemsPositiveValueAdded_completeSale_result() {
        CashRegister cashRegister = new CashRegister();
        cashRegister.addItem(100);
        cashRegister.addItem(200);
        int expected = 300;
        int actual = cashRegister.completeSale();
        assertEquals(expected, actual);
    }

    @Test
    void testGetNumberOfCompletedSales_noItemsAdded_completeSale() {
        CashRegister cashRegister = new CashRegister();
        cashRegister.completeSale();
        int expected = 1;
        int actual = cashRegister.getNumberOfCompletedSales();
        assertEquals(expected, actual);
    }

    @Test
    void testGetNumberOfCompletedSales_oneItemPositiveValueAdded_completeSale() {
        CashRegister cashRegister = new CashRegister();
        cashRegister.addItem(100);
        cashRegister.completeSale();
        int expected = 1;
        int actual = cashRegister.getNumberOfCompletedSales();
        assertEquals(expected, actual);
    }

    @Test
    void testGetNumberOfCompletedSales_twoItemsPositiveValueAdded_completeSale() {
        CashRegister cashRegister = new CashRegister();
        cashRegister.addItem(100);
        cashRegister.addItem(200);
        cashRegister.completeSale();
        int expected = 1;
        int actual = cashRegister.getNumberOfCompletedSales();
        assertEquals(expected, actual);
    }

    @Test
    void testGetNumberOfCompletedSales_twoItemsPositiveValueAdded_completeSaleTwice() {
        CashRegister cashRegister = new CashRegister();
        cashRegister.addItem(100);
        cashRegister.addItem(200);
        cashRegister.completeSale();
        cashRegister.completeSale();
        int expected = 2;
        int actual = cashRegister.getNumberOfCompletedSales();
        assertEquals(expected, actual);
    }
}
