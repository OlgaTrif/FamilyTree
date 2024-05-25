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
        this.setName(name);
        this.setSurname(surname);
        this.setSex(sex);
        this.setDateOfBirth(birth);
        this.setDateOfDeath(death);

        setChildren(new ArrayList<>());
        if (child != null) {
            getChildren().add(child);
        }

        setParents(new ArrayList<>());
        if (father != null) {
            getParents().add(father);
        }
        if (mother != null) {
            getParents().add(mother);
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
        return !getParents().isEmpty();
    }

    //это его или её родитель
    public boolean isHisOrHerParent(Member parent) {
        return getParents().contains(parent);
    }

    //есть ребёнок
    public boolean hasChildren(Member child) {
        return !getChildren().isEmpty();
    }

    //это его или её ребёнок
    public boolean isHisOrHerChild(Member child) {
        return getChildren().contains(child);
    }

    //возраст
    public Integer getAge(LocalDate dateOfBirth, LocalDate dateOfDeath) {
        Period between = Period.between(dateOfBirth, dateOfDeath);
        return between.getYears();
    }

    @Override
    public String toString(){
        return "Member{" +
                "name" + name +
                ", surname"+ getSurname() +
                ", sex" + getSex() +
                ", dateOfBirth" + getDateOfBirth() +
                ", dateOfDeath" + getDateOfDeath() +
                ", parents = (" + getParents() + ")" +
                ", children = (" + getChildren() + ")" +
                "}";
    }

    public void setId(Integer id){
        this.id = id;
    }
    public Integer getId(){
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    };

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public List<Member> getChildren() {
        return children;
    }

    public void setChildren(List<Member> children) {
        this.children = children;
    }

    public List<Member> getParents() {
        return parents;
    }

    public void setParents(List<Member> parents) {
        this.parents = parents;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }
}
