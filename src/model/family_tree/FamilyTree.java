package model.family_tree;

import model.member.comparators.BirthDayComparator;
import model.member.comparators.ChildNumberComparator;
import model.member.iterator.MemberIterator;

import java.io.Serializable;
import java.util.*;

public class FamilyTree<E extends FamilyTreeItem<E>> implements Serializable, Iterable<E>{
    private int memberId;
    private List<E> membersList;

    public FamilyTree() {
        this.setMembersList(new ArrayList<>());
    }

    //добавить члена семьи
    public void addMember(E member) {
        if (member != null && !getMembersList().contains(member)) {
            getMembersList().add(member);
            //увеличиваем id и сохраняем
            setMemberId(getMemberId() + 1);
            //устанавливаем члену семьи его id
            member.setId(getMemberId());
        }
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public List<E> getMembersList() {
        return membersList;
    }

    public void setMembersList(List<E> membersList) {
        this.membersList = membersList;
    }

    @Override
    public Iterator<E> iterator() {
        return new MemberIterator(membersList);
    }

    public void sortByName(){
        Collections.sort(membersList);
    }

    public void sortByNameDesc(){
        Collections.sort(membersList, Collections.reverseOrder());
    }

    public void sortByBirthDay(){
        Collections.sort(membersList, new BirthDayComparator());
    }

    public void sortByChildNumer(){
        Collections.sort(membersList, new ChildNumberComparator());
    }
}
