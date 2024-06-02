package service;

import family_tree.FamilyTree;
import member.Member;
import member.Sex;

import java.time.LocalDate;

public class Service {
    FamilyTree familyTree;

    public Service() {
        familyTree = new FamilyTree();
    }

    public void addMember(String name, String surname, Sex sex, LocalDate birthDate) {
        Member member = new Member(name, surname, sex, birthDate);
        familyTree.addMember(member);
    }

    public String getMembersListInfo() {
        StringBuilder members = new StringBuilder();
        for (Member mem : familyTree) {
            members.append(mem.getMemberInfo());
            members.append("\n");
        }
        return members.toString();
    }

    public void sortTreeByName(){
        familyTree.sortByName();
    }

    public void sortTreeByNameDesc(){
        familyTree.sortByNameDesc();
    }

    public void sortTreeByBirthDate(){
        familyTree.sortByBirthDay();
    }

    public void sortTreeByChildNumber(){
        familyTree.sortByChildNumer();
    }
}
