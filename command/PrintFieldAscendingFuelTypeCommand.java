package command;

import collection.CollectionManager;
import command.Command;
import model.FuelType;
import model.Vehicle;

public class PrintFieldAscendingFuelTypeCommand implements Command {
    @Override
    public void execute(CollectionManager collection, String[] args) {
        collection.getVehicles().stream()
                .map(Vehicle::getFuelType)
                .sorted()
                .forEach(System.out::println);
    }

    @Override
    public String getDescription() {
        return "вывести значения fuelType в порядке возрастания";
    }
}