package ToyStore;

import ToyStore.Store.Store;
import ToyStore.Terminal.Command.CommandExecutableFactoryImpl;
import ToyStore.Terminal.Parser.CommandParserImpl;
import ToyStore.Terminal.TerminalReader;
import ToyStore.Toy.Toy;
import ToyStore.ToyFactory.ToyFactory;


public class Program {
    public static void main(String[] args) {
        Store<Toy> toyStore = new Store(ToyFactory.createToys());
        TerminalReader terminalReader = new TerminalReader(new CommandParserImpl(), new CommandExecutableFactoryImpl(toyStore));
        terminalReader.runReader(toyStore);
    }
}