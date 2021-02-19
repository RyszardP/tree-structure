package optional_task.task1;

import optional_task.util.ReadWriteUtils;

import java.io.*;


public class Task1 {
    public static void main(String[] args) throws IOException {
        final String PATH = "./src/main/resources/optional_task_resources/";
        final String FILE_NAME = "task1.txt";
        ReadWriteUtils.createFile(PATH, FILE_NAME);
       // WriteRead.writeToFile(PATH, FILE_NAME, "umba");
        ReadWriteUtils.writeRandomNumbers(PATH, FILE_NAME,70);

    }
}
