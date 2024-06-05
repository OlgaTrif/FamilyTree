package family_tree;

import member.Member;

import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeItem<T> extends Comparable<T>{
    LocalDate getDateOfBirth();
    String getName();
    void setId(Integer i);
    List<Member> getChildren();
    String getMemberInfo();
}
