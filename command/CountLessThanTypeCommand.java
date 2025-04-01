package command;

import collection.CollectionManager;
import command.Command;
import model.VehicleType;

public class CountLessThanTypeCommand implements Command {
    @Override
    public void execute(CollectionManager collection, String[] args) {
        if (args.length < 1) {
            System.out.println("Укажите тип.");
            return;
        }
        try {
            VehicleType type = VehicleType.valueOf(args[0].toUpperCase());
            long count = collection.countLessThanType(type);
            System.out.println("Количество элементов: " + count);
        } catch (IllegalArgumentException e) {
            System.out.println("Некорректный тип.");
        }
    }

    @Override
    public String getDescription() {
        return "вывести количество элементов с типом меньше заданного";
    }
}