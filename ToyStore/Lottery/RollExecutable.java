package ToyStore.Lottery;

import ToyStore.Toy.Toy;
import ToyStore.Store.Store;
import ToyStore.Terminal.Interface.CommandExecutable;

import static ToyStore.Lottery.LotteryUtils.*;
import static ToyStore.Store.StoreUtils.sortByPrice;
import static ToyStore.Store.StoreUtils.notNull;

public class RollExecutable<S extends Store> implements CommandExecutable {
    private S toyStore;

    public RollExecutable(S toyStore) {
        this.toyStore = toyStore;
    }

    @Override
    public void execute() {
        if (notNull(this.toyStore)) {
            sortByPrice(this.toyStore);
            Toy prize = getPrize(this.toyStore);
            prizeLog(prize);
            decreaseAmount(this.toyStore, prize);
            System.out.println("Есть выигрыш!" + prize.getName());
        }
    }
}
