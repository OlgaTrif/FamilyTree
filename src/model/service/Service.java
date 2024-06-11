package model.service;

import model.family_tree.FamilyTree;
import model.family_tree.TreeReader;
import model.family_tree.TreeWriter;
import model.handler.FileHandler;
import model.handler.Writable;
import model.member.Member;
import model.member.Sex;

import java.time.LocalDate;

public class Service {
    FamilyTree familyTree;

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
        for (Object obj : familyTree) {
            Member mem = (Member) obj;
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

    public FamilyTree getFamilyTree(){
        return familyTree;
    }

    public Member getMemberByName(String name){
        return (Member) familyTree.getMemberByName(name);
    }

    public FamilyTree loadTree(String filePath){
        return TreeReader.load(filePath);
    }

    public void saveTree(FamilyTree tree, String filePath){
        TreeWriter.save(tree, filePath);
    }
}
