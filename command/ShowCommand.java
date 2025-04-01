package command;

import collection.CollectionManager;
import command.Command;

public class ShowCommand implements Command {
    @Override
    public void execute(CollectionManager collection, String[] args) {
        if (collection.getVehicles().isEmpty()) {
            System.out.println("Коллекция пуста.");
            return;
        }
        collection.getVehicles().forEach(System.out::println);
    }

    @Override
    public String getDescription() {
        return "показать все элементы";
    }
}