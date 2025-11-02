public class Integer2 {
    private int value;

    public Integer2() {
        // do nothing; value is set to 0 by default
    }

    public Integer2(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isEven() {
        return this.value % 2 == 0;
    }

    public boolean isOdd() {
        return ! isEven();
    }

    public void prettyPrint() {
        System.out.println(this.value);
    }

    public String toString() {
        return "" + this.value;
    }
}
