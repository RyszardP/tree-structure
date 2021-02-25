package optional_task.util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class ReadWriteUtils {

    public static void createFile(String path, String fileName) throws IOException {
        try {
            File f = new File(path + fileName);
            if (f.createNewFile())
                System.out.println("File created");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void writeToFile(String path, String fileName, String text) throws IOException {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter((path + fileName)));
            bw.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeRandomNumbers(String filePath, String fileName, int quantity) {
        int x = 0;
        try {
            FileWriter filewriter = new FileWriter(filePath + fileName);
            BufferedWriter writer = new BufferedWriter(filewriter);

            for (int i = 0; i < quantity; i++) {
                x = (int) (Math.random() * 100);
                writer.write(" " + x);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static LinkedList<Integer> readFromFile(String path, String filename) throws IOException {
        File file = new File(filename);
        LinkedList<Integer> list = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path + filename))) {
            String s;
            while ((s = br.readLine()) != null) {
                list.add(Integer.parseInt(s));
            }
            list.sort(Comparator.<Integer>naturalOrder());

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static Map<String, String> sortByScore(Map<String, String> map, Integer score) {

        Map<String, String> sortedMap = new HashMap<>();
        Iterator<Map.Entry<String, String>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, String> entry = entries.next();
            if (Integer.parseInt(entry.getValue()) > score) {
                sortedMap.put(entry.getKey(), entry.getValue());
            }
        }
        return sortedMap;
    }


    public static void replaceModifications(String file, String fileOutput) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileOutput))) {
            ArrayList<String> lines = new ArrayList<>();
            bufferedReader.lines().forEach(lines::add);
            lines.forEach(str -> {
                try {
                    str = str.replaceAll("public", "private");
                    bufferedWriter.write(str + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void reverse(String file, String fileOutput) {
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            bufferedReader.lines().forEach(lines::add);
            for (int i = 0; i < lines.size(); i++) {
                char[] line = lines.get(i).toCharArray();
                char[] changedLine = new char[line.length];
                int j = line.length - 1;
                for (char element : line) {
                    changedLine[j] = element;
                    j--;
                }
                lines.set(i, new String(changedLine));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileOutput))) {
            lines.forEach(str -> {
                try {
                    bufferedWriter.write(str + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void lowCaseToUpperCase(String file, String fileOutput) {
        try (FileWriter writer = new FileWriter(fileOutput);
             FileReader reader = new FileReader(file);
             BufferedWriter bufferedWriter = new BufferedWriter(writer);
             BufferedReader bufferedReader = new BufferedReader(reader)) {

            String line = null;
            String word = null;
            StringBuffer buffer = new StringBuffer();
            Pattern pattern = Pattern.compile(".{2,}");

            while ((line = bufferedReader.readLine()) != null) {
                Scanner scan = new Scanner(line);
                while (scan.hasNext()) {
                    word = scan.next();
                    Matcher matcher = pattern.matcher(word);
                    if (matcher.matches()) {
                        buffer.append(matcher.group().toUpperCase() + " ");
                    } else {
                        buffer.append(word + " ");
                    }

                }
                bufferedWriter.write(buffer.toString(), 0, line.length());
                bufferedWriter.newLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
