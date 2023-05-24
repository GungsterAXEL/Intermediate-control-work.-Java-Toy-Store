package ToyStore.Lottery;

import ToyStore.Store.Store;
import ToyStore.Toy.Toy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class LotteryUtils {
    private static int getTotalPrice(Store<Toy> toyStore) {
        int totalPrice = 0;
        for (Toy toy : toyStore) totalPrice += toy.getPrice();
        return totalPrice;
    }

    private static int winValue(int totalPrice) {
        Random random = new Random();
        int winValue = random.nextInt(totalPrice);
        return winValue;
    }

    public static Toy getPrize(Store<Toy> toyStore) {
        int matching = 0;
        Toy prize = null;
        int winValue = winValue(getTotalPrice(toyStore));
        for (int i = 0; i < toyStore.size(); i++) {
            matching += toyStore.get(i).getPrice();
            if (matching >= winValue) {
                prize = toyStore.get(i);
                int curentAmount = prize.getAmount();
                if (curentAmount > 0) prize.setAmount(curentAmount - 1);
                if (prize.getAmount() == 0) toyStore.remove(i);
            }
        }
        return prize;
    }

    public static void prizeLog(Toy prize) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        String formattedDate = formatter.format(new Date());

        String filename = "LotteryLog.txt";
        String logLine = formattedDate + " " + prize.getName();

        try {
            File logFile = new File(filename);
            FileWriter writer = new FileWriter(logFile, true);

            if (logFile.length() == 0) { writer.write("Выигрыши:\n"); }

            writer.write(logLine + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
