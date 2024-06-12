package view.commands;

import view.ConsoleUI;

public class AddRelationships extends Command{

    public AddRelationships(ConsoleUI consoleUI) {
        super("Добавить родственную связь", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().addRelationship();
    }
}
