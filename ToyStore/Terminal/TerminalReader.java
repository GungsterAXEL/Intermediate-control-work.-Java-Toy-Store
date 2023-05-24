package ToyStore.Terminal;

import ToyStore.Store.Store;
import ToyStore.Terminal.Command.Command;
import ToyStore.Terminal.Interface.CommandExecutable;
import ToyStore.Terminal.Interface.CommandExecutableFactory;
import ToyStore.Terminal.Interface.CommandParser;

import java.util.Scanner;

public class TerminalReader {
    private static TerminalReader terminalReader;
    private CommandParser commandParser;
    private CommandExecutableFactory commandExecutableFactory;

    public TerminalReader(CommandParser commandParser, CommandExecutableFactory commandExecutableFactory) {
        this.commandParser = commandParser;
        this.commandExecutableFactory = commandExecutableFactory;
    }

    public static void setTerminalReader(TerminalReader terminalReader) {
        TerminalReader.terminalReader = terminalReader;
    }

    public void runReader(Store toyStore) {
        Scanner scan = new Scanner(System.in);

        boolean restart = true;
        while (restart) {
            System.out.println(Menu.getMENU());
            Command command = this.commandParser.parseCommand(scan.nextLine().toUpperCase());
            CommandExecutable commandExecutable = this.commandExecutableFactory.create(command, toyStore);
            commandExecutable.execute();
        }
    }
}
