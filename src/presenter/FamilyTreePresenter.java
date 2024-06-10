package presenter;

import model.member.Sex;
import model.service.Service;
import view.FamilyTreeView;

import java.time.LocalDate;

public class FamilyTreePresenter {
    private FamilyTreeView view;
    private Service service;

    public FamilyTreePresenter(FamilyTreeView view) {
        this.view = view;
        service = new Service();
    }

    public void addMember(String name, String surname, Sex sex, LocalDate dateOfBirth) {
        service.addMember(name, surname, sex, dateOfBirth);
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
}
