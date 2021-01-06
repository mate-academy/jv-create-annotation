package core.basesyntax.model;

import java.util.Objects;

public class Fruit {
    private String name;
    private int quantity;

    public Fruit(String name, int quantity) {
        Objects.requireNonNull(name);
        checkForNegativeQuantity(quantity);
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Objects.requireNonNull(name);
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        checkForNegativeQuantity(quantity);
        this.quantity = quantity;
    }

    private void checkForNegativeQuantity(int quantity) {
        if (quantity < 0) {
            throw new RuntimeException("Value is negative");
        }
    }

    @Override
    public String toString() {
        return "Bet = [" + name + " " + quantity + "]";
    }
}
