package optional_task.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumber {
    public static Random r = new Random();

    public static List<Integer> fillRandomNUmberList() {
        List<Integer> randomScoresList = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            randomScoresList.add(4 + r.nextInt(10 - 4 + 1));
        }
        return randomScoresList;
    }

    public static List<Integer> getListOfNumbers(List<Integer> randomScoresList) {
        for (int i = 0; i < 20; i++) {
            randomScoresList.add(4 + r.nextInt(10 - 4 + 1));
        }
        return randomScoresList;
    }

    public static void writeRandomNumbers(String filePath, int quantity) {
        int x = 0;
        try {
            File file = new File(filePath);
            FileWriter filewriter = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(filewriter);

            for (int i = 0; i < quantity; i++) {
                x = (int) (Math.random() * 10 + 10);
                writer.write(" " + x);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
