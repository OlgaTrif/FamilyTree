package member.comparators;

import member.Member;

import java.util.Comparator;

public class BirthDayComparator implements Comparator<Member> {
    @Override
    public int compare(Member o1, Member o2) {
        return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
    }
}

