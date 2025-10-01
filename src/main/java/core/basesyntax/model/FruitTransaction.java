package core.basesyntax.model;

import core.basesyntax.exception.FruitShopException;
import java.util.Objects;

public class FruitTransaction {
    private final Operation operation;
    private final String fruit;
    private final int quantity;

    public FruitTransaction(Operation operation, String fruit, int quantity) {
        this.operation = Objects.requireNonNull(operation, "operation is null");
        if (fruit == null || fruit.isBlank()) {
            throw new FruitShopException("fruit is null or blank");
        }
        if (quantity < 0) {
            throw new FruitShopException("quantity is negative: " + quantity);
        }
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "FruitTransaction{"
                + "operation=" + operation
                + ", fruit='" + fruit + '\''
                + ", quantity=" + quantity
                + '}';
    }
}
