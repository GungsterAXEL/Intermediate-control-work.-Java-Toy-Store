package ToyStore.Toy;

import java.util.Comparator;

public class ToyPriceComparator<T extends Toy> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getPrice(), o2.getPrice());
    }
}
