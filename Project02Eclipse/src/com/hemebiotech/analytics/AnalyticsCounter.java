package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

    private ISymptomReader fileReader;
    private ISymptomWriter fileWriter;

    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.fileReader = reader;
        this.fileWriter = writer;
    }

    /**
     * returns list of symptoms
     * @return
     */
    public List<String> getSymptoms() {
        return this.fileReader.getSymptoms();
    }

    /**
     * counts the occurrences of symptoms
     * @param symptoms
     * @return
     */
    public Map<String, Integer> countSymptoms(List<String> symptoms) {

        Map<String, Integer> symptomsMap = new HashMap<>();

        for (String line : symptoms) {
            if (symptomsMap.containsKey(line)) {
                int oldValue = symptomsMap.get(line);
                int newValue = oldValue + 1;
                symptomsMap.put(line, newValue);

            } else {
                symptomsMap.put(line, 1);
            }
        }
        return symptomsMap;
    }

    /**
     * returns the sorted list of symptoms
     * @param symptoms
     * @return
     */
    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        Map<String, Integer> map = new TreeMap<String, Integer>();
        map.putAll(symptoms);

        return map;
    }

    /**
     * returns the list of symptoms in the file
     * @param symptoms
     */
    public void writeSymptoms(Map<String, Integer> symptoms) {
        this.fileWriter.writeSymptoms(symptoms);
    }

}

