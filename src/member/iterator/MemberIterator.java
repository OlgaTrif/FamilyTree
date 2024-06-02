package member.iterator;

import member.Member;

import java.util.Iterator;
import java.util.List;

public class MemberIterator implements Iterator<Member> {

    private int memId;
    private List<Member> membersList;

    public MemberIterator(List<Member> membersList) {
        this.membersList = membersList;
    }

    @Override
    public boolean hasNext() {
        return getMembersList().size() > memId;
    }

    @Override
    public Member next() {
        return getMembersList().get(memId++);
    }

    private List<Member> getMembersList() {
        return membersList;
    }
}