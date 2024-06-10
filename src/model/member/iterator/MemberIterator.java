package model.member.iterator;

import java.util.Iterator;
import java.util.List;

public class MemberIterator<T> implements Iterator<T> {

    private int memId;
    private List<T> membersList;

    public MemberIterator(List<T> membersList) {
        this.membersList = membersList;
    }

    @Override
    public boolean hasNext() {
        return getMembersList().size() > memId;
    }

    @Override
    public T next() {
        return getMembersList().get(memId++);
    }

    private List<T> getMembersList() {
        return membersList;
    }
}