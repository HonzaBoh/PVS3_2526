package filing;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CoordinatesExample {
    public static void main(String[] args) {
        String path = "data/coords.txt";
        File f = new File(path);

        if (f.isFile() && f.exists()) {
            try {
                String line;
                List<Coordinate> coords = new ArrayList<>();

                BufferedReader br = new BufferedReader(new FileReader(f));
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(",");
                    coords.add(new Coordinate(Integer.parseInt(parts[0]), Integer.parseInt(parts[1])));
                }

                for(Coordinate c : coords){
                    System.out.println(c);
                }

                br.close();

            } catch (FileNotFoundException e) {
                System.out.println("File not found!");
                System.out.println("Provided: " + path);
            } catch (IOException io) {
                System.out.println("Something went wrong");
            }

        }
    }
}


class Coordinate {
    private int x, y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}