package ToyStore.Terminal.Command;

import ToyStore.Lottery.RollExecutable;
import ToyStore.Store.Store;
import ToyStore.Terminal.Interface.CommandExecutable;
import ToyStore.Terminal.Interface.CommandExecutableFactory;

import static ToyStore.Store.StoreUtils.*;

public class CommandExecutableFactoryImpl<S extends Store> implements CommandExecutableFactory<S> {

    private S toyStore;

    public CommandExecutableFactoryImpl(S toyStore) {
        this.toyStore = toyStore;
    }

    public <S> CommandExecutable create(Command command, S toyStore) {

        if (command.getHelp()) return new HelpExecutable(this.toyStore);
        else if (command.getBreak()) return new BreakExecutable(this.toyStore);

        else if (command.addToy()) return new AddExecutable(this.toyStore);
        else if (command.delToy()) return new DelExecutable(this.toyStore);

        else if (command.printByPrice()) {
            sortByPrice(this.toyStore);
            return new PrintExecutable(this.toyStore);
        } else if (command.printByID()) {
            sortByID(this.toyStore);
            return new PrintExecutable(this.toyStore);
        } else if (command.printByAmount()) {
            sortByAmount(this.toyStore);
            return new PrintExecutable(this.toyStore);
        } else if (command.tryRoll()) return new RollExecutable(this.toyStore);
        return new UnknownExecutable(this.toyStore);
    }
}

