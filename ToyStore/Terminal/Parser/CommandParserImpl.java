package ToyStore.Terminal.Parser;

import ToyStore.Terminal.Command.Command;
import ToyStore.Terminal.Interface.CommandParser;

public class CommandParserImpl implements CommandParser {
    @Override
    public Command parseCommand(String inputCommand) {
        String[] newInputCommand = inputCommand.split("\\s+");
        Command command = new Command(newInputCommand[0]);
        return command;
    }
}