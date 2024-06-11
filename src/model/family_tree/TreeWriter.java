package model.family_tree;

import model.handler.FileHandler;
import model.handler.Writable;

public abstract class TreeWriter implements Writable{
    public static void save(FamilyTree tree, String filePath){
        Writable writable = new FileHandler();
        writable.save(tree, filePath);
    }
}
