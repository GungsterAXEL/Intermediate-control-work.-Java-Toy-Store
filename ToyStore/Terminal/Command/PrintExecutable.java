package ToyStore.Terminal.Command;

import ToyStore.Store.Store;
import ToyStore.Terminal.Interface.CommandExecutable;
import ToyStore.Toy.Toy;

import static ToyStore.Store.StoreUtils.notNull;

public class PrintExecutable<S extends Store<Toy>> implements CommandExecutable {
    private S toyStore;

    public PrintExecutable(S toyStore) {
        this.toyStore = toyStore;
    }

    @Override
    public void execute() {
        if (notNull(toyStore)) {
            char delimiter = '|';
            String[] mask = {"%5s", "%25s", "%10s", "%5s"};
            String[] head = {"ID", "Название", "Количество", "Цена"};
            int summ = 0;
            for (String i : mask) {
                summ += Integer.parseInt(i.replaceAll("[^0-9]+", ""));
            }
            String stick = "-".repeat(mask.length + summ);

            for (int i = 0; i < head.length; i++) {
                System.out.print(String.format(mask[i], head[i]) + delimiter);
            }
            System.out.println("\n" + stick);
            for (Toy toy : this.toyStore) {
                String[] values = toy.toString().split(";");
                for (int i = 0; i < values.length; i++) {
                    System.out.print(String.format(mask[i], values[i]) + delimiter);
                }
                System.out.println();
            }
            System.out.println(stick);
        }
    }
}