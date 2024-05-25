import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private Integer memberId;
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

    public Integer getMemberId() {
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
}
