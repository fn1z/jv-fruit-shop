package core.basesyntax.service.operation;

import core.basesyntax.exception.FruitShopException;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.storage.Storage;

public class PurchaseOperation implements OperationHandler {
    private final Storage storage;

    public PurchaseOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        int available = storage.get(transaction.getFruit());
        int qty = transaction.getQuantity();
        if (available < qty) {
            throw new FruitShopException("Not enough fruits for purchase: "
                    + transaction.getFruit());
        }
        storage.decrease(transaction.getFruit(), qty);
    }
}
