package ToyStore.Store;

import ToyStore.Toy.Toy;
import ToyStore.Toy.ToyCountComparator;
import ToyStore.Toy.ToyIDComparator;
import ToyStore.Toy.ToyPriceComparator;

import java.util.Collections;

public class StoreUtils<S extends Store> {
    public static void sortByID(Store<Toy> toyStore) {
        Collections.sort(toyStore.getToys(), new ToyIDComparator());//Comparator.comparing(Toy::getId));
    }

    public static void sortByAmount(Store<Toy> toyStore) {
        Collections.sort(toyStore.getToys(), new ToyCountComparator());//Comparator.comparing(Toy::getAmount));
    }

    public static void sortByPrice(Store<Toy> toyStore) {
        Collections.sort(toyStore.getToys(), new ToyPriceComparator());
    }

    public static boolean notNull(Store<Toy> toyStore) {
        if (toyStore.size() == 0) {
            System.out.println("Список пуст.");
            return false;
        } else return true;
    }
}
