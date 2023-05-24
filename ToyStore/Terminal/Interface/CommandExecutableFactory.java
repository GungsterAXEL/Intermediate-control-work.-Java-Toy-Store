package ToyStore.Terminal.Interface;

import ToyStore.Store.Store;
import ToyStore.Terminal.Command.Command;

public interface CommandExecutableFactory<S extends Store>{
    <S> CommandExecutable create(Command command, S toyStore);
}
