package main_task;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Main {
    public Set<String> listFilesUsingDirectoryStream(String dir) throws IOException {
        Set<String> fileList = new HashSet<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(dir))) {
            for (Path path : stream) {
                if (!Files.isDirectory(path)) {
                    fileList.add(path.getFileName()
                            .toString());
                }
            }
        }
        return fileList;
    }

    public static void main(String[] args) throws IOException {
        File originalFile = new File("./src/main/resources/roots/");
        File folder = originalFile.getParentFile();

        for (File file : folder.listFiles()) {
            System.out.println(file.getName());
        }


        File fileAllDir = new File("./src/main/resources/roots/");

        for (String H : getFileTree("./src/main/resources/roots/")) {
            System.out.println(H);
        }

        System.out.println("find path");
        Files.find(Paths.get(String.valueOf(fileAllDir)),
                Integer.MAX_VALUE,
                (filePath, fileAttr) -> fileAttr.isRegularFile())
                .forEach(System.out::println);
    }

    public static List<String> getFileTree(String root) throws IOException {
        List<String> a = new ArrayList<>();

        Files.walkFileTree(Paths.get(root), new SimpleFileVisitor<Path>() {

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (attrs.isDirectory())
                    a.add(attrs.toString());

                return FileVisitResult.CONTINUE;
            }
        });

        return a;


    }



}
