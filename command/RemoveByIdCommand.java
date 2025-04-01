package command;

import collection.CollectionManager;
import command.Command;

public class RemoveByIdCommand implements Command {
    @Override
    public void execute(CollectionManager collection, String[] args) {
        if (args.length < 1) {
            System.out.println("Укажите ID элемента.");
            return;
        }
        try {
            long id = Long.parseLong(args[0]);
            if (collection.removeById(id)) {
                System.out.println("Элемент удален.");
            } else {
                System.out.println("Элемент с ID " + id + " не найден.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Некорректный ID.");
        }
    }

    @Override
    public String getDescription() {
        return "удалить элемент по ID";
    }
}