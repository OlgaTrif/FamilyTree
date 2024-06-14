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
    private final Scanner scanner;
    private final FamilyTreePresenter presenter;
    private boolean work;
    private final MainMenu mainMenu;
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
            int choice = Integer.parseInt(choiceStr);
            if (mainMenu.size() < choice) {
                System.out.println("Ошибка: Проверьте номер команды");
                break;
            }
            mainMenu.execute(choice);
        }
    }

    public void endProgram() {
        work = false;
        save(presenter.getFamilyTree());
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
        save(presenter.getFamilyTree());
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
    
    public Integer convertInputStrToInteger(){
        String memberStr = scanner.nextLine();
        return Integer.parseInt(memberStr);
    }

    private static FamilyTree load(){
        Writable writable = new FileHandler();
        try {
            return (FamilyTree) writable.read(ConsoleUI.filePath);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void save(FamilyTree tree){
        Writable writable = new FileHandler();
        writable.save(tree, ConsoleUI.filePath);
    }

    private void loadFamilyTree(){
        //save(presenter.getFamilyTree(), filePath);
        FamilyTree<Member> tree = load();
        presenter.setFamilyTree(tree);
    }

    public void addRelationship() {
        getMemberList();
        System.out.println("Введите id ребёнка из списка");
        Integer childId = convertInputStrToInteger();
        System.out.println("Введите id отца из списка");
        Integer fatherId = convertInputStrToInteger();
        System.out.println("Введите id матери из списка");
        Integer motherId = convertInputStrToInteger();
        presenter.addRelation(childId, fatherId, motherId);
        save(presenter.getFamilyTree());
    }
}
