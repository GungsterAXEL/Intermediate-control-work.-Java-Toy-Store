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
    private static void mkDir(String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    private static void mkFile(String filePath, String logLine) {
        try {
            File logFile = new File(filePath);
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

    public static Toy getPrize(Store<Toy> toyStore) {
        int indexRange = toyStore.size();

        int minPrice = toyStore.get(0).getPrice();
        int maxPrice = toyStore.get(indexRange - 1).getPrice();

        Random random = new Random();
        int winValue = random.nextInt(minPrice, maxPrice);

        Toy prize = toyStore.get(random.nextInt(indexRange));
        while (prize.getPrice() > winValue) {
            prize = toyStore.get(random.nextInt(indexRange));
        }
        return prize;
    }

    static void decreaseAmount(Store<Toy> toyStore, Toy toy) {
        int amount = toy.getAmount();
        if (amount > 0) toy.setAmount(amount - 1);
        if (amount - 1 == 0) {
            for (int i = 0; i < toyStore.size(); i++) {
                if (toy.getId() == toyStore.get(i).getId()) toyStore.remove(i);
            }
        }
    }

    public static void prizeLog(Toy prize) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        String formattedDate = formatter.format(new Date());

        String filename = "LotteryLog.txt";
        String logLine = formattedDate + " " + prize.getName();

        String directoryPath = "ToyStore" + File.separator + "Lottery" + File.separator;
        mkDir(directoryPath);
        mkFile(directoryPath + filename, logLine);
    }
}
