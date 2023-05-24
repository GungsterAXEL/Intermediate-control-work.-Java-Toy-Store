package ToyStore.Toy;

import java.util.Comparator;

public class ToyCountComparator<T extends Toy> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getAmount(), o2.getAmount());
    }
}
