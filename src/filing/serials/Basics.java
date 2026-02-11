package filing.serials;

import java.io.*;
import java.util.ArrayList;

public class Basics {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //priprav instanci, co chces exportnout
        Coordinates coords = new Coordinates(10,Integer.MAX_VALUE,95);
        System.out.println("Exportuju: " + coords);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("coords.ser"));
        oos.writeObject(coords);
        oos.close();


        //deserializace
        Coordinates toRead = null;
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("coords.ser"));
        toRead = (Coordinates) ois.readObject();

        System.out.println("Importovano: " + toRead);
    }
}
class Coordinates implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    int x,y,z;

    public Coordinates(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "[" + x + "," + y + "," +z +"]";
    }
}
