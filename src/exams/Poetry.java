package exams;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Poetry {
    public static final int THRESHOLD = 2 * 1024 * 1024;

    public static void main(String[] args) throws IOException {
        String dataPath = "data/poetry";

        List<File> files = filterFiles(dataPath, "txt");

        Comparator<File> BY_SIZE = new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return Long.compare(o1.length(), o2.length());
            }
        };

        files.sort(BY_SIZE);

        for (File file : files){
            System.out.println(Files.readAllLines(file.toPath()));
        }

    }

    public static List<File> filterFiles(String directoryPath, String extension){
        List<File> filtered = new ArrayList<>();

        File dir = new File(directoryPath);
        if(!dir.isDirectory() || !dir.exists()){
            return null;
        }

        for(File file : dir.listFiles()){
            if(!file.toPath().endsWith(extension)){
                continue;
            }

            if(file.length() > THRESHOLD){
                continue;
            }

            filtered.add(file);
        }

        return filtered;
    }

    public static boolean endsWithThatWorks(String path, String ext){
        return path.split("\\.")[1].equals(ext);
    }
}
