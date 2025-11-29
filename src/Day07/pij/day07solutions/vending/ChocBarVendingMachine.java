package pij.day07solutions.vending;

// Ex 10
public class ChocBarVendingMachine {

    private final VendingMachine vendingMachine;

    public ChocBarVendingMachine(int price) {
        this.vendingMachine = new VendingMachine(price);
    }

    public int getBar(int money) {
        Sale sale = this.vendingMachine.buy(money);
        if (sale.sold) {
            giveChocolateBar();
        }
        return sale.change;
    }

    private void giveChocolateBar() {
        System.out.println("Giving chocolate bar...");
    }
}
