package command;

import collection.CollectionManager;
import command.Command;
import model.Vehicle;
import util.InputReader;

public class AddCommand implements Command {
    @Override
    public void execute(CollectionManager collection, String[] args) {
        Vehicle vehicle = InputReader.readVehicle();
        collection.add(vehicle);
        System.out.println("Элемент добавлен.");
    }

    @Override
    public String getDescription() {
        return "добавить новый элемент";
    }
}