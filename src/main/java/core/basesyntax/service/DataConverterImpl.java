package core.basesyntax.service;

import core.basesyntax.exception.FruitShopException;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String COMMA = ",";

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> rawLines) {
        if (rawLines == null) {
            throw new FruitShopException("Input lines are null");
        }
        List<FruitTransaction> result = new ArrayList<>();
        if (rawLines.isEmpty()) {
            return result;
        }

        int start = 0;
        if (rawLines.get(0).toLowerCase().startsWith("type")) {
            start = 1;
        }

        for (int i = start; i < rawLines.size(); i++) {
            String line = rawLines.get(i).trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] parts = line.split(COMMA);
            if (parts.length != 3) {
                throw new FruitShopException("Invalid record format (expected 3 values): " + line);
            }
            String opCode = parts[0].trim();
            String fruit = parts[1].trim();
            String qtyStr = parts[2].trim();
            try {
                Operation op = Operation.fromCode(opCode);
                if (fruit == null || fruit.isBlank()) {
                    throw new FruitShopException("Fruit name is empty in line: " + line);
                }
                int qty = Integer.parseInt(qtyStr);
                if (qty < 0) {
                    throw new FruitShopException("Negative quantity in line: " + line);
                }
                result.add(new FruitTransaction(op, fruit, qty));
            } catch (NumberFormatException nfe) {
                throw new FruitShopException("Invalid quantity number in line: " + line, nfe);
            } catch (RuntimeException e) {
                throw new FruitShopException("Can't parse line: " + line, e);
            }
        }
        return result;
    }
}
