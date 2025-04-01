package command;
import collection.CollectionManager;

import collection.CsvProcessor;

import command.Command;

public class SaveCommand implements Command {
    @Override
    public void execute(CollectionManager collection, String[] args) {
        try {
            CsvProcessor.saveToCsv(System.getenv("COLLECTION_FILE"), collection.getVehicles());
            System.out.println("Коллекция сохранена.");
        } catch (Exception e) {
            System.out.println("Ошибка сохранения: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public String getDescription() {
        return "сохранить коллекцию в файл";

    }

}