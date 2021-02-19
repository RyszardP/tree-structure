package optional_task.task3;

import optional_task.util.ReadWriteUtils;

public class Task3 {
    public static void main(String[] args) {
        final String PATH = "./src/main/java/optional_task/task3/";
        final String PATH_OUTPUT = "./src/main/resources/optional_task_resources/";
        final String FILE_NAME = "FileForReverse.java";
        final String FILE_NAME_OUTPUT = "FileForReverse.txt";

        ReadWriteUtils.reverse(PATH + FILE_NAME, PATH_OUTPUT + FILE_NAME_OUTPUT);
    }
}
