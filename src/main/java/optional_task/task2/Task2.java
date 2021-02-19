package optional_task.task2;

import optional_task.util.ReadWriteUtils;

import java.io.IOException;

public class Task2 {
    public static void main(String[] args) throws IOException {

        final String PATH = "./src/main/java/optional_task/task2/";
        final String PATH_OUTPUT = "./src/main/resources/optional_task_resources/";
        final String FILE_NAME = "FileForReplace.java";
        final String FILE_NAME_OUTPUT = "FileForReplace.txt";

        ReadWriteUtils.replaceModifications(PATH + FILE_NAME, PATH_OUTPUT + FILE_NAME_OUTPUT);
    }

}
