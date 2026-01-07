package filing;

import java.io.File;
import java.util.Arrays;

public class Basics {
    static void tree(File root){
        if (!root.exists()){
            return;
        }
        if (!root.isDirectory()){
            System.out.println(root.getPath());
        } else {
            System.out.println(root.getPath());
            File[] content = root.listFiles();
            for(File file : content){
                tree(file);
            }
        }
    }

    public static void main(String[] args) {
        File f = new File("data\\tracks.txt");
        System.out.println(f.exists());
        System.out.println(f.isFile());
        System.out.println(f.isDirectory());
        System.out.println(f.length());

        new File("dirExample").mkdir();
        //neprobehne:
        new File("neco\\dirExample").mkdir();
        //probehne
        new File("neco\\dirExample").mkdirs();

        System.out.println(f.getName());
        System.out.println(f.getPath());
        System.out.println(f.getAbsolutePath());
        System.out.println(f.getParent());

        //overit adresar:
        File another = new File("data");
        if (another.isDirectory()){
//            System.out.println(Arrays.toString(another.list()));
            System.out.println(Arrays.toString(another.listFiles()));
        }

        System.out.println("----");
        tree(new File("src"));
    }
}
