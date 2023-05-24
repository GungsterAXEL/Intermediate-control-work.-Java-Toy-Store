package ToyStore.Store;

import ToyStore.Toy.Toy;
import ToyStore.Toy.ToyIterator;

import java.util.Iterator;
import java.util.List;

public class Store<T extends Toy> implements Iterable<T> {
    private List<T> toys;

    public Store(List<T> toys) {
        this.toys = toys;
    }

    public List<T> getToys() {
        return this.toys;
    }

    public void setToys(List<T> toys) {
        this.toys = toys;
    }

    public void addToy(T toy) {
        this.toys.add(toy);
    }

    @Override
    public Iterator<T> iterator() {
        return new ToyIterator<T>(this.toys);
    }

    public int size() {
        return this.toys.size();
    }

    public void remove(int index) {
        this.toys.remove(index);
    }

    public T get(int index) {
        return this.toys.get(index);
    }
}
