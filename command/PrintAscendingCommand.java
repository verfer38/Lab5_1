package command;

import collection.CollectionManager;
import command.Command;

public class PrintAscendingCommand implements Command {
    @Override
    public void execute(CollectionManager collection, String[] args) {
        collection.getVehicles().stream()
                .sorted()
                .forEach(System.out::println);
    }

    @Override
    public String getDescription() {
        return "вывести элементы в порядке возрастания";
    }
}