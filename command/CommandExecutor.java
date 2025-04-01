package command;

import collection.CollectionManager;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandExecutor {
    private final Map<String, Command> commands = new HashMap<>();
    private final CollectionManager collection;

    public CommandExecutor(CollectionManager collection) {
        this.collection = collection;
        registerCommands();
    }

    private void registerCommands() {
        commands.put("help", new HelpCommand(commands));
        commands.put("add", new AddCommand());
        commands.put("show", new ShowCommand());
        commands.put("update", new UpdateCommand());
        commands.put("remove_by_id", new RemoveByIdCommand());
        commands.put("clear", new ClearCommand());
        commands.put("save", new SaveCommand());
        commands.put("execute_script", new ExecuteScriptCommand(this));
        commands.put("exit", new ExitCommand());
        commands.put("head", new HeadCommand());
        commands.put("add_if_max", new AddIfMaxCommand());
        commands.put("remove_lower", new RemoveLowerCommand());
        commands.put("count_less_than_type", new CountLessThanTypeCommand());
        commands.put("print_ascending", new PrintAscendingCommand());
        commands.put("print_field_ascending_fuel_type", new PrintFieldAscendingFuelTypeCommand());
    }

    public void executeCommand(String input) {
        String[] parts = input.split(" ", 2);
        Command cmd = commands.get(parts[0]);
        if (cmd != null) {
            cmd.execute(collection, parts.length > 1 ? parts[1].split(" ") : new String[0]);
        } else {
            System.out.println("Неизвестная команда. Введите 'help' для справки.");
        }
    }

    public void startInteractiveMode() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            if (input.equals("exit")) break;
            executeCommand(input);
        }
        scanner.close();
    }
}