package ToyStore.ToyFactory;

import ToyStore.Toy.Toy;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;

import static ToyStore.ToyFactory.Defaults.*;
import static ToyStore.ToyFactory.TitleList.getTitleList;

public class ToyFactory {
    public static List<Toy> createToys(int titleCount, int maxUnitCount, int maxPrice) {
        Random random = new Random();
        List<Toy> toys = new ArrayList<>();
        int randomCount = 0;
        for (int i = 1; i <= titleCount; i++) {
            int randomTitle = random.nextInt(getTitleList().length);
            randomCount = random.nextInt(maxUnitCount);
            if (randomCount == 0) randomCount++;
            int randomPrice = random.nextInt(maxPrice);
            toys.add(new Toy(i, getTitleList()[randomTitle], randomCount, randomPrice));
        }
        return toys;
    }

    public static List<Toy> createToys() {
        return ToyFactory.createToys(getTitleCount(), getMaxUnitCount(), getMaxPrice());
    }

    public static List<Toy> createToys(int titleCount) {
        return ToyFactory.createToys(titleCount, getMaxUnitCount(), getMaxPrice());
    }
}
