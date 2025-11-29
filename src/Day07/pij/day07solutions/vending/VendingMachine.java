package pij.day07solutions.vending;

// Ex 10
public class VendingMachine {
    private int price;

    public VendingMachine(int price) {
        this.price = price;
    }

    public Sale buy(int money) {
        Sale result = new Sale();
        if (money < price) {
            result.sold = false;
            result.change = money;
        } else {
            result.sold = true;
            result.change = price - money;
        }
        return result;
    }
}
