package model.writer;

import java.io.Serializable;

public interface TreeWriterable {
    boolean write(Serializable serializable, String filePath);
}
