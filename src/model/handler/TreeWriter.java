package model.handler;

import java.io.Serializable;

public interface TreeWriter{
    boolean write(Serializable serializable, String filePath);
}
