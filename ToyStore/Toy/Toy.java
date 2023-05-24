package ToyStore.Toy;

public class Toy implements Comparable<Toy> {
    private int id;
    private String name;
    private int amount;
    private int price;

    public Toy(int id, String name, int amount, int price) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {return amount;}

    public void setAmount(int amount) {
        this.amount = amount;
    }
    public int getPrice() {return price;}
    public void setPrice(int price) {this.price = price;}

    @Override
    public String toString() {
        return id + ";" +
                name + ";" +
                amount + ";" +
                price;
    }

    @Override
    public int compareTo(Toy o) {
        if (this.getAmount() > o.getAmount()) return 1;
        else if (this.getAmount() < o.getAmount()) return -1;
        return 0;
    }
}
