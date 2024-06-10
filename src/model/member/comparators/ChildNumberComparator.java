package model.member.comparators;

import model.family_tree.FamilyTreeItem;

import java.util.Comparator;

public class ChildNumberComparator<T extends FamilyTreeItem> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getChildren().size()> (o2.getChildren().size()) ? 1 : 0;
    }
}