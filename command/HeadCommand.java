package command;

import collection.CollectionManager;
import command.Command;

public class HeadCommand implements Command {
    @Override
    public void execute(CollectionManager collection, String[] args) {
        if (collection.getVehicles().isEmpty()) {
            System.out.println("Коллекция пуста.");
            return;
        }
        System.out.println(collection.getVehicles().getFirst());
    }

    @Override
    public String getDescription() {
        return "вывести первый элемент коллекции";
    }
}