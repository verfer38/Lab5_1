package command;

import collection.CollectionManager;
import command.Command;

public class ExitCommand implements Command {
    @Override
    public void execute(CollectionManager collection, String[] args) {
        System.out.println("Завершение программы.");
        System.exit(0);
    }

    @Override
    public String getDescription() {
        return "выход из программы";
    }
}