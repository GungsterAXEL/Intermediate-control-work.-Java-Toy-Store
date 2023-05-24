package ToyStore.Terminal.Command;

import ToyStore.Store.Store;
import ToyStore.Terminal.Interface.CommandExecutable;

import static ToyStore.ToyFactory.ToyFactory.createToys;

public class AddExecutable<S extends Store> implements CommandExecutable {
    private S toyStore;

    public AddExecutable(S toyStore) {
        this.toyStore = toyStore;
    }

    @Override
    public void execute() {
        if (this.toyStore.size() > 0) {
            int lastID = this.toyStore.get(this.toyStore.size() - 1).getId();
            this.toyStore.addToy(createToys(1).get(0));
            this.toyStore.get(this.toyStore.size() - 1).setId(lastID + 1);
        } else this.toyStore.addToy(createToys(1).get(0));
        System.out.println("Игрушка добавлена.");
    }
}