package view.commands;

import view.ConsoleUI;

public class EndProgram extends Command{

    public EndProgram(ConsoleUI consoleUI) {
        super("Закончить работу", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().endProgram();
    }
}
