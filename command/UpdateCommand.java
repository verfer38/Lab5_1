package command;
import collection.CollectionManager;
import model.Vehicle;
import util.InputReader;

public class UpdateCommand implements Command {
    @Override
    public void execute(CollectionManager collection, String[] args) {
        if (args.length < 1) {
            System.out.println("Укажите ID элемента.");
            return;
        }
        try {
            long id = Long.parseLong(args[0]);
            Vehicle oldVehicle = collection.getById(id);
            if (oldVehicle == null) {
                System.out.println("Элемент с ID " + id + " не найден.");
                return;
            }
            Vehicle newVehicle = InputReader.readVehicle();
            newVehicle.setId(oldVehicle.getId());
            newVehicle.setCreationDate(oldVehicle.getCreationDate());
            collection.update(oldVehicle, newVehicle);
            System.out.println("Элемент обновлен.");
        } catch (NumberFormatException e) {
            System.out.println("Некорректный ID.");
        }
    }

    @Override
    public String getDescription() {
        return "обновить элемент по ID";
    }
}
