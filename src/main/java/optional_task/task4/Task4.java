package optional_task.task4;

import optional_task.util.ReadWriteUtils;

public class Task4 {
    public static void main(String[] args) {

    final String PATH = "./src/main/java/optional_task/task4/";
    final String PATH_OUTPUT = "./src/main/resources/optional_task_resources/";
    final String FILE_NAME = "FileForUpperCase.class";
    final String FILE_NAME_OUTPUT = "lowToUpperCase.txt";

        ReadWriteUtils.lowCaseToUpperCase(FILE_NAME, PATH_OUTPUT + FILE_NAME_OUTPUT);

    }
}
