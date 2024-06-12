package model.family_tree;

import model.member.Member;
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
        return new MemberIterator<>(membersList);
    }

    public void sortByName(){
        Collections.sort(membersList);
    }

    public void sortByNameDesc(){
        Collections.sort(membersList, Collections.reverseOrder());
    }

    public void sortByBirthDay(){
        Collections.sort(membersList, new BirthDayComparator<>());
    }

    public void sortByChildNumer(){
        Collections.sort(membersList, new ChildNumberComparator<>());
    }

    public E getMemberByName(String name){
        return membersList.stream().filter(m -> m.getName().equals(name)).toList().getFirst();
    }

    public E getMemberById(Integer id){
        return membersList.stream().filter(m -> Objects.equals(m.getId(), id)).toList().getFirst();
    }

    public void addRelation(Member child, Member father, Member mother) {
        father.addChildren(child);
        mother.addChildren(child);
        child.addParent(father);
        child.addParent(mother);
    }
}
