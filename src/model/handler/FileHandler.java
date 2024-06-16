package model.handler;

import java.io.*;

public class FileHandler implements TreeReader, TreeWriter {
    @Override
    public boolean write(Serializable serializable, String filePath){
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))){
            objectOutputStream.writeObject(serializable);
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    };

    @Override
    public Object read(String filePath) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream((new FileInputStream(filePath)))) {
            return objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
