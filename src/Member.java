import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Member {
    private Integer id;
    private String name;
    private String surname;
    private Sex sex;
    private List<Member> children;
    private List<Member> parents;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;

    public Member(String name, String surname, Sex sex, LocalDate birth, LocalDate death, Member child,
                   Member father, Member mother) {
        id = -1;
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.dateOfBirth = birth;
        this.dateOfDeath = death;

        children = new ArrayList<>();
        if (child != null) {
            children.add(child);
        }

        parents = new ArrayList<>();
        if (father != null) {
            parents.add(father);
        }
        if (mother != null) {
            parents.add(mother);
        }
    }

    public Member(String name, String surname, Sex sex, LocalDate birth) {
        this(name, surname, sex, birth, null, null, null, null);
    }

    public Member(String name, String surname, Sex sex, LocalDate birth, Member father, Member mother) {
        this(name, surname, sex, birth, null, father, mother, null);
    }

    //есть родители (хотя бы один)
    public boolean hasParent() {
        return !parents.isEmpty();
    }

    //это его или её родитель
    public boolean isHisOrHerParent(Member parent) {
        return parents.contains(parent);
    }

    //есть ребёнок
    public boolean hasChildren(Member child) {
        return !children.isEmpty();
    }

    //это его или её ребёнок
    public boolean isHisOrHerChild(Member child) {
        return children.contains(child);
    }

    //возраст
    public Integer getAge(LocalDate dateOfBirth, LocalDate dateOfDeath) {
        Period between = Period.between(dateOfBirth, dateOfDeath);
        return between.getYears();
    }
}
