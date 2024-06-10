package model.member.comparators;

import model.family_tree.FamilyTreeItem;

import java.util.Comparator;

public class MemberComparator<T extends FamilyTreeItem> implements Comparator<T>{
    @Override
    public int compare(T o1, T o2) {
        return o1.compareTo(o2);
    }
}
