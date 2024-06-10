package model.family_tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeItem<T> extends Serializable, Comparable<T>{
    LocalDate getDateOfBirth();
    String getName();
    void setId(Integer i);
    Integer getId();
    List<T> getChildren();
    String getMemberInfo();
}
