package presenter;

import model.family_tree.FamilyTree;
import model.handler.FileHandler;
import model.handler.Writable;
import model.member.Member;
import model.member.Sex;
import model.service.Service;
import view.FamilyTreeView;

import java.time.LocalDate;

public class FamilyTreePresenter {
    private final FamilyTreeView view;
    private final Service service;

    public FamilyTreePresenter(FamilyTreeView view) {
        this.view = view;
        service = new Service();
    }

    public void addMember(String name, String surname, Sex sex, LocalDate dateOfBirth) {
        service.addMember(name, surname, sex, dateOfBirth);
        getMemberListInfo();
    }

    public void addMember(String name, String surname, Sex sex, LocalDate dateOfBirth, LocalDate dateOfDeath,
                          Member child, Member father, Member mother) {
        service.addMember(name, surname, sex, dateOfBirth, dateOfDeath, child, father, mother);
        getMemberListInfo();
    }

    public void getMemberListInfo() {
        view.printAnswer(service.getMembersListInfo());
    }

    public void sortByAge() {
        service.sortTreeByBirthDate();
        getMemberListInfo();
    }

    public void sortByName() {
        service.sortTreeByName();
        getMemberListInfo();
    }

    public Member getMemberByName(String name){
        return service.getMemberByName(name);
    }

    public FamilyTree getFamilyTree(){
        return service.getFamilyTree();
    }

    public void setFamilyTree(FamilyTree tree){
        service.setFamilyTree(tree);
    }
}
