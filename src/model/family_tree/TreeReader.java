package model.family_tree;

import model.handler.FileHandler;
import model.handler.Writable;

public abstract class TreeReader implements  Writable{
    public static FamilyTree load(String filePath){
        Writable writable = new FileHandler();
        return (FamilyTree) writable.read(filePath);
    }
}
