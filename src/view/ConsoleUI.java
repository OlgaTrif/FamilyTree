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
    private static final String filePath = "src/tree.txt";

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new FamilyTreePresenter(this);
        work = true;
        mainMenu = new MainMenu(this);
    }

    @Override
    public void start() {
        loadFamilyTree();
        while (work) {
            System.out.println("Добро пожаловать!\n");
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
        }
    }

    public void endProgram() {
        work = false;
        save(presenter.getFamilyTree(), filePath);
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
        presenter.addMember(name, surname, sex, dateOfBirth);
        save(presenter.getFamilyTree(), filePath);
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
        Member member = presenter.getMemberById(Integer.parseInt(memberStr));
        if (member == (null)) {
            System.out.println("Член семьи не найден в древе. Добавьте его");
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

    private void loadFamilyTree(){
        //save(presenter.getFamilyTree(), filePath);
        FamilyTree tree = load(filePath);
        presenter.setFamilyTree(tree);
    }

    public void addRelationship() {
        getMemberList();
        System.out.println("Введите id ребёнка из списка");
        Member child = findMemberOrWarnIfNotFound();
        System.out.println("Введите id отца из списка");
        Member father = findMemberOrWarnIfNotFound();
        System.out.println("Введите id матери из списка");
        Member mother = findMemberOrWarnIfNotFound();
        presenter.addRelation(child, father, mother);
        save(presenter.getFamilyTree(), filePath);
    }
}
