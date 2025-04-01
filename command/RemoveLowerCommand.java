package command;

import collection.CollectionManager;
import model.Vehicle;
import util.InputReader;

public class RemoveLowerCommand implements Command {
    @Override
    public void execute(CollectionManager collection, String[] args) {
        Vehicle reference = InputReader.readVehicle();
        int count = collection.removeLower(reference);
        System.out.println("Удалено элементов: " + count);
    }

    @Override
    public String getDescription() {
        return "удалить элементы, меньшие заданного";
    }
}