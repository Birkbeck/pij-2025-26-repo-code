package pij.day07solutions.vending;

// Ex 10
public class DrinkRefrigerator {

    private final VendingMachine vendingMachine;

    public DrinkRefrigerator(int price) {
        this.vendingMachine = new VendingMachine(price);
    }

    public int buyCan(int money) {
        Sale sale = this.vendingMachine.buy(money);
        if (sale.sold) {
            releaseCan();
        }
        return sale.change;
    }

    private void releaseCan() {
        System.out.println("Releasing can...");
    }
}
