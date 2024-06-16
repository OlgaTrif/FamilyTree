package model.service;

import model.family_tree.FamilyTree;
import model.reader.TreeReader;
import model.reader.TreeReaderable;
import model.writer.TreeWriter;
import model.writer.TreeWriterable;
import model.member.Member;
import model.member.Sex;

import java.time.LocalDate;

public class Service {
    FamilyTree<Member> familyTree;
    private static final String filePath = "src/tree.txt";

    public Service() {
        try {
            FamilyTree<Member> tree = load();
            setFamilyTree(tree);
        } catch (Exception e) {
            familyTree = new FamilyTree<>();
        }
    }

    public void addMember(String name, String surname, Sex sex, LocalDate birth) {
        Member member = new Member(name, surname, sex, birth);
        familyTree.addMember(member);
        save(familyTree);
    }

    public void addMember(String name, String surname, Sex sex, LocalDate birth, LocalDate death,
                          Member child, Member father, Member mother) {
        Member member = new Member(name, surname, sex, birth, death, child, father, mother);
        familyTree.addMember(member);
        save(familyTree);
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
        save(familyTree);
    }

    public void sortTreeByNameDesc(){
        familyTree.sortByNameDesc();
        save(familyTree);
    }

    public void sortTreeByBirthDate(){
        familyTree.sortByBirthDay();
        save(familyTree);
    }

    public void sortTreeByChildNumber(){
        familyTree.sortByChildNumer();
        save(familyTree);
    }

    public FamilyTree<Member> getFamilyTree(){
        return familyTree;
    }

    public Member getMemberById(Integer id){
        return (Member) familyTree.getMemberById(id);
    }

    public void setFamilyTree(FamilyTree<Member> tree) {
        familyTree = tree;
        save(familyTree);
    }

    public void addRelation(Integer childId, Integer fatherId, Integer motherId) {
        familyTree.addRelation(childId, fatherId, motherId);
        save(familyTree);
    }

    private static void save(FamilyTree<Member> tree){
        TreeWriterable writer = new TreeWriter();
        writer.write(tree, filePath);
    }

    private static FamilyTree<Member> load(){
        TreeReaderable reader = new TreeReader();
        try {
            return (FamilyTree) reader.read(filePath);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
