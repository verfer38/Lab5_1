package command;

import collection.CollectionManager;
import model.Vehicle;
import util.InputReader;

public class AddIfMaxCommand implements Command {
    @Override
    public void execute(CollectionManager collection, String[] args) {
        Vehicle newVehicle = InputReader.readVehicle();
        Vehicle maxVehicle = collection.getMax();
        if (maxVehicle == null || newVehicle.compareTo(maxVehicle) > 0) {
            collection.add(newVehicle);
            System.out.println("Элемент добавлен.");
        } else {
            System.out.println("Элемент не является максимальным.");
        }
    }

    @Override
    public String getDescription() {
        return "добавить элемент, если он максимальный";
    }
}