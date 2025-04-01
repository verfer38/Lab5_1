package command;

import collection.CollectionManager;
import command.Command;

import java.util.Map;

public class HelpCommand implements Command {
    private final Map<String, Command> commands;

    public HelpCommand(Map<String, Command> commands) {
        this.commands = commands;
    }

    @Override
    public void execute(CollectionManager collection, String[] args) {
        System.out.println("Доступные команды:");
        commands.forEach((name, cmd) ->
                System.out.printf("%-20s %s%n", name, cmd.getDescription())
        );
    }

    @Override
    public String getDescription() {
        return "вывести справку по командам";
    }
}