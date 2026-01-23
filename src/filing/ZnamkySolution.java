package filing;

import java.io.*;
import java.nio.BufferOverflowException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ZnamkySolution {
    public static void main(String[] args) throws IOException {

        String dataPath = "data/znamky.txt";
        String outputPath = "data/znamky/";
        String fileFormat = ".txt";

        String line;

        File adresar = new File("data/znamky");

        if (!adresar.exists()) {
            adresar.mkdirs();
        }

        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(dataPath))) {
            while ((line = br.readLine()) != null) {
                String parts[] = line.split(";");
                String jmeno = parts[0];

                int pocetZnamek = parts.length - 1;
                double suma = 0;

                for (int i = 1; i <= pocetZnamek; i++) {
                    suma += Double.parseDouble(parts[i]);
                }
                double prumer = suma / pocetZnamek;
                students.add(new Student(jmeno, prumer));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // dočteno
        Collections.sort(students); // setříděno

        String prev = "1";
        BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath + prev + fileFormat, true));
        for(Student s : students){
            String fileName = Long.toString(Math.round(s.average));

            // zavrit stary, otevrit novy, pokud se znamka zmeni
            if(!fileName.equals(prev)){
                prev = fileName;
                bw.close();
                bw = new BufferedWriter(new FileWriter(outputPath + fileName + fileFormat, true));
            }

            // jinak zapiseme do souboru
            bw.write(s.toString());
            bw.newLine();
        }
        bw.close();

    }
}

class Student implements Comparable<Student> {
    String jmeno;
    double average;

    public Student(String jmeno, double average) {
        this.jmeno = jmeno;
        this.average = average;
    }

    @Override
    public String toString() {
        return jmeno + ";" + average;
    }

    @Override
    public int compareTo(Student o) {
        return Double.compare(this.average, o.average);
    }
}

