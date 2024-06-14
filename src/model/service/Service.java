package model.service;

import model.family_tree.FamilyTree;
import model.member.Member;
import model.member.Sex;

import java.time.LocalDate;

public class Service {
    FamilyTree<Member> familyTree;

    public Service() {
        familyTree = new FamilyTree<>();
    }

    public void addMember(String name, String surname, Sex sex, LocalDate birth) {
        Member member = new Member(name, surname, sex, birth);
        familyTree.addMember(member);
    }

    public void addMember(String name, String surname, Sex sex, LocalDate birth, LocalDate death,
                          Member child, Member father, Member mother) {
        Member member = new Member(name, surname, sex, birth, death, child, father, mother);
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

    public FamilyTree<Member> getFamilyTree(){
        return familyTree;
    }

    public Member getMemberById(Integer id){
        return (Member) familyTree.getMemberById(id);
    }

    public void setFamilyTree(FamilyTree<Member> tree) {
        familyTree = tree;
    }

    public void addRelation(Integer childId, Integer fatherId, Integer motherId) {
        familyTree.addRelation(childId, fatherId, motherId);
    }
}
