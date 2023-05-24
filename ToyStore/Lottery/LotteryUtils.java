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
    public static Toy getPrize(Store<Toy> toyStore) {
        int indexRange = toyStore.size();

        int minPrice = toyStore.get(0).getPrice();
        int maxPrice = toyStore.get(indexRange - 1).getPrice();

        Random random = new Random();
        int winValue = random.nextInt(minPrice, maxPrice);

        Toy prize = toyStore.get(random.nextInt(indexRange));
        while (prize.getPrice() > winValue) {
            prize = toyStore.get(random.nextInt(indexRange));
            System.out.println(prize.getPrice() + " " + winValue);
        }
        return prize;
    }

    public static void prizeLog(Toy prize) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        String formattedDate = formatter.format(new Date());

        String filename = "LotteryLog.txt";
        String logLine = formattedDate + " " + prize.getName();

        String directoryPath = "ToyStore" + File.separator + "Lottery" + File.separator;
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        try {
            File logFile = new File(directoryPath + filename);
            FileWriter writer = new FileWriter(logFile, true);

            if (logFile.length() == 0) {
                writer.write("Выигрыши:\n");
            }

            writer.write(logLine + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
