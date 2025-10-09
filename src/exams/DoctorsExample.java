package exams;

import fileworks.DataExport;
import fileworks.DataImport;
import oop.inheritance.CardiacSurgeon;
import oop.inheritance.Doctor;
import oop.inheritance.Surgeon;

public class DoctorsExample {

    static void validateJob(Doctor d, String jobType) {
        if (jobType.equals("C") && d instanceof CardiacSurgeon) {
            ((CardiacSurgeon) d).cardiacSurgery();
            return;
        }
        if (jobType.equals("S") && d instanceof Surgeon) {
            ((Surgeon) d).surgery();
            return;
        }
        if (jobType.equals("D")) { // zde by mohla být kontrola d instanceof Doctor, ale byla by zbytečná
            d.diagnose();
            return;
        }

        // Pokud neplatí ani jedno, penalizujeme
        d.penalty();

    }

    public static void main(String[] args) {
        final int BASE_SALARY = 25_000;

        DataImport di = new DataImport("hospitalData.txt");
        DataExport de = new DataExport("salaries.txt");

        int minSalary = Integer.MAX_VALUE;
        int maxSalary = Integer.MIN_VALUE;

        String minName = "", maxName = "";

        while (di.hasNext()) {
            String line = di.readLine().trim();
            String[] parts = line.split(";");

            Doctor house;

            if (parts[1].equals("CardiacSurgeon")) {
                house = new CardiacSurgeon(parts[0], BASE_SALARY);
            } else if (parts[1].equals("Surgeon")) {
                house = new Surgeon(parts[0], BASE_SALARY);
            } else {
                house = new Doctor(parts[0], BASE_SALARY);
            }

            // proveď všechny zákroky
            for (int i = 2; i < parts.length; i++) {
                validateJob(house, parts[i]);
            }

            // nejbohatší doktor
            if (maxSalary < house.getSalary()) {
                maxSalary = house.getSalary();
                maxName = house.getName();
            }

            // nejchudší doktor (největší dlužník)
            if (minSalary > house.getSalary()) {
                minSalary = house.getSalary();
                minName = house.getName();
            }

            de.writeLine(house.toString());
        }

        System.out.printf("Nejbohatší doktor %s si vydělal %d\n", maxName, maxSalary);
        System.out.printf("Nejchudší doktor %s si \"vydělal\" %d\n", minName, minSalary);

        // nezapomenout na úklid
        di.finishImport();
        de.finishExport();
    }
}
