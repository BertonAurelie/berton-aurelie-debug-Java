package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class WriteSymptomDataToFile implements ISymptomWriter {
    private String filepath;


    public WriteSymptomDataToFile(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {

        Set<Map.Entry<String, Integer>> listSymptoms = symptoms.entrySet();

        try {
            FileWriter writer = new FileWriter(filepath);
            for (Map.Entry<String, Integer> listSymptom : listSymptoms) {
                String key = listSymptom.getKey();
                Integer value = listSymptom.getValue();
                writer.write(key + " : " + value + "\n");
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
};

