package member.comparators;

import family_tree.FamilyTreeItem;
import member.Member;

import java.util.Comparator;

public class MemberComparator<T extends FamilyTreeItem> implements Comparator<T>{
    @Override
    public int compare(T o1, T o2) {
        return o1.compareTo(o2);
    }
}
