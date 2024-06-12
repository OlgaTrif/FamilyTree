package view;

import model.family_tree.FamilyTree;
import model.handler.FileHandler;
import model.handler.Writable;
import model.member.Member;
import model.member.Sex;
import presenter.FamilyTreePresenter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConsoleUI implements FamilyTreeView{
    private Scanner scanner;
    private FamilyTreePresenter presenter;
    private boolean work;
    private MainMenu mainMenu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new FamilyTreePresenter(this);
        work = true;
        mainMenu = new MainMenu(this);
    }

    @Override
    public void start() {
        String filePath = "src/tree.txt";
        save(presenter.getFamilyTree(), filePath);
        presenter.setFamilyTree(load(filePath));
        while (work) {
            System.out.println("Добро пожаловать!\n");
            presenter.getMemberListInfo();
            //вывести имеющееся дерево
            System.out.println(mainMenu.menu());
            String choiceStr = scanner.nextLine();
            if (choiceStr.isEmpty()) {
                System.out.println("Ошибка: Введена пустая команда");
                break;
            }
            if (choiceStr.length() > 1) {
                System.out.println("Ошибка: Введен недопустимый символ");
                break;
            }
            int choise = Integer.parseInt(choiceStr);
            if (mainMenu.size() < choise) {
                System.out.println("Ошибка: Проверьте номер команды");
                break;
            }
            mainMenu.execute(choise);
            //сохранить изменения
            save(presenter.getFamilyTree(), filePath);
        }
    }

    public void endProgram() {
        work = false;
        System.out.println("До новых встреч!");
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }

    public void addMember(){
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        System.out.println("Введите фамилию");
        String surname = scanner.nextLine();
        System.out.println("Укажите пол (M или W)");
        Sex sex = Sex.valueOf(scanner.nextLine());
        System.out.println("Укажите дату рождения (ДД.ММ.ГГГГ)");
        String dateB = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate dateOfBirth = LocalDate.parse(dateB, formatter);
        System.out.println("Укажите дату смерти (ДД.ММ.ГГГГ). Если её нет, оставьте поле пустым");
        String dateD = scanner.nextLine();
        LocalDate dateOfDeath;
        if ("".equals(dateD)){
            dateOfDeath = null;
        } else {
            dateOfDeath = LocalDate.parse(dateB, formatter);
        }
        System.out.println("Введите имя ребёнка. Если нет, оставьте поле пустым");
        Member child = findMemberOrWarnIfNotFound();
        System.out.println("Введите имя отца. Если нет, оставьте поле пустым");
        Member father = findMemberOrWarnIfNotFound();
        System.out.println("Введите имя матери. Если нет, оставьте поле пустым");
        Member mother = findMemberOrWarnIfNotFound();
        presenter.addMember(name, surname, sex, dateOfBirth, dateOfDeath, child, father, mother);
    }

    public void getMemberList(){
        presenter.getMemberListInfo();
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }
    
    public Member findMemberOrWarnIfNotFound(){
        String memberStr = scanner.nextLine();
        Member member = memberStr != "" ? presenter.getMemberByName(memberStr) : null;
        if (member == (null)) {
            System.out.println("Член семьи не найден в древе. Добавьте его позже");
        }
        return member;
    }

    private static FamilyTree load(String filePath){
        Writable writable = new FileHandler();
        try {
            return (FamilyTree) writable.read(filePath);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void save(FamilyTree tree, String filePath){
        Writable writable = new FileHandler();
        writable.save(tree, filePath);
    }
}
