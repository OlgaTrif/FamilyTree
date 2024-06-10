package model.member.comparators;

import model.family_tree.FamilyTreeItem;

import java.util.Comparator;

public class BirthDayComparator<T extends FamilyTreeItem> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
    }
}

