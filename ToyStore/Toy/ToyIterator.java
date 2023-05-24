package ToyStore.Toy;

import java.util.Iterator;
import java.util.List;

public class ToyIterator<T extends Toy> implements Iterator<T> {
    private List<T> toys;
    private int position;

    public ToyIterator(List<T> toys) {
        this.toys = toys;
    }

    @Override
    public boolean hasNext() {
        return position < this.toys.size();
    }

    @Override
    public T next() {
        return this.toys.get(position++);
    }
}
