package ToyStore.Terminal.Command;

import ToyStore.Store.Store;
import ToyStore.Terminal.Interface.CommandExecutable;

import java.util.Random;

import static ToyStore.Store.StoreUtils.notNull;

public class DelExecutable<S extends Store> implements CommandExecutable {
    private S toyStore;

    public DelExecutable(S toyStore) {
        this.toyStore = toyStore;
    }

    @Override
    public void execute() {
        if (notNull(toyStore)) {
            Random random = new Random();
            int index = random.nextInt(this.toyStore.size());
            this.toyStore.remove(index);
            System.out.println("Случайная игрушка удалена.");
        }
    }
}