import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        Member tanya = new Member("Tanya", "Kruglova", Sex.Woman, LocalDate.of(1972,7,11));
        Member sergey = new Member("Sergey", "Khrisanov", Sex.Man, LocalDate.of(1962,1,27));

        familyTree.addMember(tanya);
        familyTree.addMember(sergey);

        System.out.println(tanya.getMemberInfo());
        System.out.println(sergey.getMemberInfo());
    }
}