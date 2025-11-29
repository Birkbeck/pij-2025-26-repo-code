package pij.day07solutions.ark;

public abstract class AbstractAnimal implements Animal {
    private final String name;

    public AbstractAnimal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
