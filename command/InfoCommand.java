package command;

import collection.CollectionManager;
import command.Command;

public class InfoCommand implements Command {
    @Override
    public void execute(CollectionManager collection, String[] args) {
        System.out.println("Тип коллекции: " + collection.getCollectionType());
        System.out.println("Дата инициализации: " + collection.getInitializationDate());
        System.out.println("Количество элементов: " + collection.getSize());
    }

    @Override
    public String getDescription() {
        return "вывести информацию о коллекции";
    }
}