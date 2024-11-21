package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class AnalyticsCounter {

    public static void main(String args[]) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("Project02Eclipse/symptoms.txt"));
        String line = reader.readLine();

        int headacheCount = 0;
        int rashCount = 0;
        int pupilCount = 0;

        while (line != null) {

            System.out.println("symptom from file: " + line);
            if (line.equals("headache")) {
                headacheCount++;
                System.out.println("number of headaches: " + headacheCount);
            } else if (line.equals("rush")) {
                rashCount++;
            } else if (line.contains("pupils")) {
                pupilCount++;
            }

            line = reader.readLine();    // get another symptom
        }

        // next generate output
        FileWriter writer = new FileWriter("result.out");
        writer.write("headache: " + headacheCount + "\n");
        writer.write("rash: " + rashCount + "\n");
        writer.write("dialated pupils: " + pupilCount + "\n");
        writer.close();
    }
}
