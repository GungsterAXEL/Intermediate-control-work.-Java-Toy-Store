package ToyStore.ToyFactory;

public class Defaults {
    private static int titleCount = 15;
    private static int maxUnitCount = 100;
    private static int maxPrice = 10000;
    public static int getTitleCount() {
        return titleCount;
    }

    public static int getMaxUnitCount() {
        return maxUnitCount;
    }

    public static int getMaxPrice() {
        return maxPrice;
    }
}
