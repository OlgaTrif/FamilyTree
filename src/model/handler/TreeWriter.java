package model.handler;

import java.io.Serializable;

public class TreeWriter implements  Writable{
    @Override
    public boolean save(Serializable serializable, String filePath) {
        return false;
    }

    @Override
    public Object read(String filePath) throws Exception {
        return null;
    }
}
