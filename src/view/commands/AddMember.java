package view.commands;

import view.ConsoleUI;

public class AddMember extends Command{

    public AddMember(ConsoleUI consoleUI) {
        super("Добавить члена", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().addMember();
    }
}
