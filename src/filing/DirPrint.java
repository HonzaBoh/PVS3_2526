package filing;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;

public class DirPrint {

    public static void printDirSorted(String dirPath, String fileType) {
        ArrayList<File> files = new ArrayList<>();
        File directory = new File(dirPath);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("You did not provide directory!");
            return;
        }

        for (File f : directory.listFiles()) {
            String[] tokens = f.getName().split("\\.");
            //neco.txt -> ["neco", "txt"]
            if (tokens[tokens.length - 1].equals(fileType)) {
                files.add(f);
            }
        }

        System.out.println(files);
        System.out.println(files.size());

        System.out.println("Example:");
        System.out.println(files.get(0).getName() + ": " + files.get(0).length());
        System.out.println("=================");
        Comparator<File> fileSizeComparator = new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return Long.compare(o1.length(), o2.length());
            }
        };

        files.sort(fileSizeComparator);
        for (File file : files){
            System.out.println(file.getName() + ": " + (file.length()/1024));
        }
    }


    public static void main(String[] args) {
        printDirSorted("data", "txt");
    }

}
