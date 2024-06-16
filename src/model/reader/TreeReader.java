package model.reader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TreeReader implements TreeReaderable{
    @Override
    public Object read(String filePath) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream((new FileInputStream(filePath)))) {
            return objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
