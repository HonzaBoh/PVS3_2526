package filing;

import java.io.*;

public class ZnamkySolution {
    public static void main(String[] args) throws IOException {

        String dataPath = "data/znamky.txt";
        String outputPath = "data/znamky_prumer.txt";
        String line;

        BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath));
        try (BufferedReader br = new BufferedReader(new FileReader(dataPath))) {

            bw.write("Prijmeni;Prumer");
            bw.newLine();
            while ((line = br.readLine()) != null) {
                String parts[] = line.split(";");
                String jmeno = parts[0];

                int pocetZnamek = parts.length - 1;
                double suma = 0;

                for (int i = 1; i <= pocetZnamek; i++) {
                    suma += Double.parseDouble(parts[i]);
                }

                double prumer = suma / pocetZnamek;
                System.out.println(jmeno + " " + prumer);
                bw.write(jmeno + " " + prumer);

                bw.newLine();
            }
            bw.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
