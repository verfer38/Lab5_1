package command;

import collection.CollectionManager;
import util.InputReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ExecuteScriptCommand implements Command {
    private static final Set<String> executingScripts = new HashSet<>();
    private final CommandExecutor commandExecutor;

    // тут конструктр с передачей CommandExecutor
    public ExecuteScriptCommand(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor; //  через аргумент
    }

    @Override
    public void execute(CollectionManager collection, String[] args) {
        if (args.length < 1) {
            System.out.println("Укажите имя файла.");
            return;
        }
        String filename = args[0];
        if (executingScripts.contains(filename)) {
            System.out.println("Рекурсивный вызов скрипта запрещён.");
            return;
        }
        executingScripts.add(filename);

        try (Scanner scanner = new Scanner(new File(filename))) {
            Scanner originalScanner = InputReader.getScanner();
            InputReader.setScanner(scanner);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;
                System.out.println("Выполнение команды: " + line);
                commandExecutor.executeCommand(line); // инициализаия чтоб без ошибок
            }

            InputReader.setScanner(originalScanner);
        } catch (FileNotFoundException e) {
            System.out.println("Файл скрипта не найден: " + filename);
        } finally {
            executingScripts.remove(filename);
        }
    }

    @Override
    public String getDescription() {
        return "выполнить скрипт из файла";
    }
}