package core.basesyntax.dao;

import core.basesyntax.exception.FruitShopException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String fileName) {
        if (fileName == null || fileName.isBlank()) {
            throw new FruitShopException("Input file name is null or blank");
        }
        try {
            return Files.readAllLines(Path.of(fileName));
        } catch (Exception e) {
            throw new FruitShopException("Can't read file: " + fileName, e);
        }
    }
}
