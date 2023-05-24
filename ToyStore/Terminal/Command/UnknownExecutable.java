package ToyStore.Terminal.Command;

import ToyStore.Store.Store;
import ToyStore.Terminal.Interface.CommandExecutable;

public class UnknownExecutable<S extends Store> implements CommandExecutable {
    private S toyStore;

    public UnknownExecutable(S toyStore) {
        this.toyStore = toyStore;
    }

    @Override
    public void execute() {
        System.out.println("Команда не распознана.");
    }
}
