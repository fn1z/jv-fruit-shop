package core.basesyntax.service;

import core.basesyntax.exception.FruitShopException;
import core.basesyntax.model.Operation;
import java.util.Map;

public class OperationsStrategyImpl implements OperationsStrategy {
    private final Map<Operation, OperationHandler> handlers;

    public OperationsStrategyImpl(Map<Operation,OperationHandler> handlers) {
        this.handlers = handlers;
    }

    @Override
    public OperationHandler getHandler(Operation operation) {
        OperationHandler handler = handlers.get(operation);
        if (handler == null) {
            throw new FruitShopException("No handler for operation: " + operation);
        }
        return handler;
    }
}
