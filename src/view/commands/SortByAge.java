package view.commands;

import view.ConsoleUI;

public class SortByAge extends Command{

    public SortByAge(ConsoleUI consoleUI) {
        super("Сортировать список по возрасту", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().sortByAge();
    }
}
