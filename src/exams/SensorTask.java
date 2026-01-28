package exams;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SensorTask {
    static ArrayList<Reading> validReadings = new ArrayList<>();
    static ArrayList<InvalidReading> invalidReadings = new ArrayList<>();

    static void reportReadings(String dirPath) throws IOException {
        File directory = new File(dirPath);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Wrong directory");
            return;
        }
        File current;
        int lineCounter;
        String line;
        Reading reading;
        String[] tokens;
        for (int i = 1; i < 21; i++) {
            current = new File(directory + "\\sen" + i + ".txt");
            BufferedReader br = new BufferedReader(new FileReader(current));
            lineCounter = 1;
            while ((line = br.readLine()) != null) {
                tokens = line.split(" ");
//                System.out.println("0: " + tokens[0] + "_1:" + tokens[1]);
                reading = new Reading(tokens[0], Double.parseDouble(tokens[1]));
                if (reading.measuredValue > -200.0 && reading.measuredValue < 500.0) {
                    validReadings.add(reading);
                } else {
                    invalidReadings.add(new InvalidReading(current.getName(), lineCounter, reading));
                }
                System.out.println(reading);
                lineCounter++;
            }

            br.close();
        }
        System.out.println("Valids: " + validReadings.size());
        System.out.println("Invalids: " + invalidReadings.size());
        System.out.println(invalidReadings);
    }

    public static void main(String[] args) {
        try {
            reportReadings("dataSensors");
        } catch (IOException e) {
            System.out.println("Problem reading the directory:");
            System.out.println(e.getMessage());
        }
    }

}

class Reading {
    String sensorID;
    double measuredValue;

    public Reading(String sensorID, double measuredValue) {
        this.sensorID = sensorID;
        this.measuredValue = measuredValue;
    }

    @Override
    public String toString() {
        return sensorID + ": " + measuredValue;
    }
}

class InvalidReading {
    String fileName;
    int lineNumber;
    Reading reading;

    public InvalidReading(String fileName, int lineNumber, Reading reading) {
        this.fileName = fileName;
        this.lineNumber = lineNumber;
        this.reading = reading;
    }

    @Override
    public String toString() {
        return fileName + ": [" + lineNumber + "] " + reading;
    }
}
