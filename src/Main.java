import family_tree.FamilyTree;
import handler.FileHandler;
import handler.Writable;
import member.Member;
import member.Sex;
import service.Service;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //String filePath = "src/tree.txt";
        FamilyTree familyTree = new FamilyTree();
        //Member tanya = new Member("Tanya", "Kruglova", Sex.Woman, LocalDate.of(1972,7,11));
        //Member sergey = new Member("Sergey", "Khrisanov", Sex.Man, LocalDate.of(1962,1,27));
        //Member oly = new Member("Olga", "Trifonova", Sex.Woman, LocalDate.of(1996,3,18), sergey, tanya);
        //familyTree.addMember(tanya);
        //familyTree.addMember(sergey);
        //familyTree.addMember(oly);
        //System.out.println(familyTree.getMembersListInfo());
        //familyTree.sortByName();
        //System.out.println(familyTree.getMembersListInfo());

        Service service = new Service();
        service.addMember("Tanya", "Kruglova", Sex.Woman, LocalDate.of(1972,7,11));
        service.addMember("Olga", "Trifonova", Sex.Woman, LocalDate.of(1996,3,18));
        service.addMember("Jan", "Ton", Sex.Man, LocalDate.of(1990,1,11));
        service.addMember("Sergey", "Khrisanov", Sex.Man, LocalDate.of(1962,1,27));
        System.out.println("Исходник:\n" + service.getMembersListInfo());
        service.sortTreeByName();
        System.out.println("Сорт по имени:\n" + service.getMembersListInfo());
        service.sortTreeByNameDesc();
        System.out.println("Сорт по имени в обратном:\n" + service.getMembersListInfo());
        service.sortTreeByBirthDate();
        System.out.println("Сорт по дате рождения:\n" + service.getMembersListInfo());
        service.sortTreeByChildNumber();
        System.out.println("Сорт по к-ву детей:\n" + service.getMembersListInfo());

        //save(familyTree, filePath);
        //load(filePath);
    }

    /*private static FamilyTree load(String filePath){
        Writable writable = new FileHandler();
        return (FamilyTree) writable.read(filePath);
    }

    private static void save(FamilyTree tree, String filePath){
        Writable writable = new FileHandler();
        writable.save(tree, filePath);
    }*/
}