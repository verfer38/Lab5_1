import collection.CollectionManager;
import collection.CsvProcessor;
import command.CommandExecutor;
import model.Vehicle;

import java.io.IOException;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        String filename = System.getenv("COLLECTION_FILE");
        if (filename == null) {
            System.err.println("Переменная окружения COLLECTION_FILE не задана.");
            return;
        }

        try {
            // Загрузка данных из CSV
            ArrayDeque<Vehicle> loadedVehicles = CsvProcessor.readFromCsv(filename);

            // Инициализация коллекции
            CollectionManager collection = new CollectionManager();
            collection.initialize(loadedVehicles);

            // Создание CommandExecutor с передачей коллекции
            CommandExecutor executor = new CommandExecutor(collection);

            // Запуск интерактивного режима
            System.out.println("Программа запущена. Введите команду (help для справки):");
            executor.startInteractiveMode();
        } catch (IOException e) {
            System.err.println("Ошибка загрузки файла: " + e.getMessage());
        }
    }
}