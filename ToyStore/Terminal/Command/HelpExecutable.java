package ToyStore.Terminal.Command;

import ToyStore.Store.Store;
import ToyStore.Terminal.Interface.CommandExecutable;

public class HelpExecutable<S extends Store> implements CommandExecutable {
    private S toyStore;

    public HelpExecutable(S toyStore) {
        this.toyStore = toyStore;
    }

    @Override
    public void execute() {
        System.out.println(Command.getCOMMANDLIST());
    }
}