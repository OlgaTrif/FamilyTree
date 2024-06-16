package view.commands;

import view.ConsoleUI;

public class RemoveMember extends Command{

    public RemoveMember(ConsoleUI consoleUI) {
        super("Удалить члена", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().removeMemeber();
    }
}
