package member.comparators;

import member.Member;

import java.util.Comparator;

public class ChildNumberComparator implements Comparator<Member> {
    @Override
    public int compare(Member o1, Member o2) {
        return o1.getChildren().size()> (o2.getChildren().size()) ? 1 : 0;
    }
}