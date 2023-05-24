package ToyStore.Terminal.Command;

import ToyStore.Store.Store;
import ToyStore.Terminal.Interface.CommandExecutable;

public class BreakExecutable<S extends Store> implements CommandExecutable {
    private S toyStore;

    public BreakExecutable(S toyStore) {
        this.toyStore = toyStore;
    }

    @Override
    public void execute() {
        System.out.println("Всего хорошего!");
        System.exit(0);
    }
}