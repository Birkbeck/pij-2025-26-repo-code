public class SpySolutionTester {
    public static void main(String[] args) {
        SpySolution alice = new SpySolution(5);
        SpySolution bob = new SpySolution(6);
        System.out.println("There are " + SpySolution.getNumberOfActiveSpies() + " active spies!");
        bob.retire();
        System.out.println("There are " + SpySolution.getNumberOfActiveSpies() + " active spies!");
    }
}
