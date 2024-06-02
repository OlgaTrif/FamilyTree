package family_tree;

import member.comparators.BirthDayComparator;
import member.Member;
import member.comparators.ChildNumberComparator;
import member.comparators.MemberComparator;
import member.iterator.MemberIterator;

import java.util.*;

public class FamilyTree implements Iterable<Member>{
    private int memberId;
    private List<Member> membersList;

    public FamilyTree() {
        this.setMembersList(new ArrayList<>());
    }

    //добавить члена семьи
    public void addMember(Member member) {
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

    public List<Member> getMembersList() {
        return membersList;
    }

    public void setMembersList(List<Member> membersList) {
        this.membersList = membersList;
    }

    @Override
    public Iterator<Member> iterator() {
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
