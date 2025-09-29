package core.basesyntax.dao;

import core.basesyntax.exception.FruitShopException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String data, String fileName) {
        try {
            Files.writeString(Path.of(fileName), data);
        } catch (IOException e) {
            throw new FruitShopException("Can't write file: " + fileName, e);
        }
    }
}
