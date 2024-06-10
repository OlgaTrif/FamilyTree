package model.member;

import model.family_tree.FamilyTreeItem;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Member implements Serializable, FamilyTreeItem<Member> {
    private Integer id;
    private String name;
    private String surname;
    private Sex sex;
    private List<Member> children;
    private List<Member> parents;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;

    private static final String NO = "нет";

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
        this(name, surname, sex, birth, null, null, father, mother);
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
        Period between;
        if (dateOfDeath == null) {
            between = Period.between(dateOfBirth, LocalDate.now());
        } else {
            between = Period.between(dateOfBirth, dateOfDeath);
        }
        return between.getYears();
    }

    public String getMemberInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(getId());
        sb.append("; имя: ");
        sb.append(getName());
        sb.append("; фамилия: ");
        sb.append(getSurname());
        sb.append("; пол: ");
        sb.append(getSex());
        sb.append("; возраст: ");
        sb.append(getAge(getDateOfBirth(), getDateOfDeath()));
        sb.append("; родители: ");
        sb.append(getParentsStr());
        sb.append("; дети: ");
        sb.append(getChildrenStr());
        return sb.toString();
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

    public String getChildrenStr() {
        if (getChildren().isEmpty()) {
            return NO;
        } else return getChildren().toString();
    }

    public void setChildren(List<Member> children) {
        this.children = children;
    }

    public List<Member> getParents() {
        return parents;
    }

    public String getParentsStr() {
        if (this.getParents().isEmpty()) {
            return NO;
        } else {
            return getParentsNames();
        }
    }

    public String getParentsNames(){
        StringBuilder sb = new StringBuilder();
        for (Member mem : this.getParents()) {
            sb.append(mem.getName());
            sb.append(",");
        }
        return sb.toString();
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

    @Override
    public int compareTo(Member m) {
        return name.compareTo(m.name);
    }
}
