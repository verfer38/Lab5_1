package command;

import collection.CollectionManager;
import command.Command;

public class ClearCommand implements Command {
    @Override
    public void execute(CollectionManager collection, String[] args) {
        collection.clear();
        System.out.println("Коллекция очищена.");
    }

    @Override
    public String getDescription() {
        return "очистить коллекцию";
    }
}