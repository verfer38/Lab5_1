package command;

import collection.CollectionManager;

public interface Command {
    void execute(CollectionManager collection, String[] args);
    String getDescription();
}