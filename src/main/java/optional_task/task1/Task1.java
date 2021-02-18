package optional_task.task1;

import java.io.*;


public class Task1 {
    public static void main(String[] args) throws IOException {

        try {

            File f = new File("./src/main/resources/optional_task_resources/example.txt");
            if (f.createNewFile())
                System.out.println("File created");
        } catch (Exception e) {
            System.err.println(e);
        }

        try (FileWriter writer = new FileWriter("./optional_task_resources/Task1.txt", false)) {
            String text = "first task text";
            writer.write(text);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
