package ToyStore.Terminal.Interface;

import ToyStore.Terminal.Command.Command;

public interface CommandParser {
    Command parseCommand(String inputCommand);

}