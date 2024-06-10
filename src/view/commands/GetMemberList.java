package view.commands;

import view.ConsoleUI;

public class GetMemberList extends Command{

        public GetMemberList(ConsoleUI consoleUI) {
            super("Вывести список всех членов", consoleUI);
        }

        @Override
        public void execute(){
            getConsoleUI().getMemberList();
        }
}
