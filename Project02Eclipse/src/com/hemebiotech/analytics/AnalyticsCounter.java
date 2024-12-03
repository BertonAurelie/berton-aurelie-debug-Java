package com.hemebiotech.analytics;

import java.util.*;

public class AnalyticsCounter {

    private ISymptomReader fileReader;
    private ISymptomWriter fileWriter;

    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer){
        this.fileReader = reader;
        this.fileWriter = writer;
    }

    public List<String> getSymptoms() {
        return this.fileReader.getSymptoms();
    }

    public Map<String, Integer> countSymptoms(List<String> symptoms) {

        Map<String, Integer> symptomsMap = new HashMap<>();

        for (String line : symptoms) {
            if(symptomsMap.containsKey(line)){
                int oldValue = symptomsMap.get(line);
                int newValue = oldValue + 1;
                symptomsMap.put(line,newValue);

            } else {
                symptomsMap.put(line,1);
            }
        }
        return symptomsMap;
    }

    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        SortedMap<String, Integer> map = new TreeMap<String, Integer>();
        map.putAll(symptoms);

        Set<String> keys = map.keySet();

        for (String key : keys) {
            System.out.println(key + " --> " + map.get(key));
        }

        System.out.println("--- entrySet ---");
        Set<Map.Entry<String,Integer>> entrySet = map.entrySet();

        for (Map.Entry<String,Integer> entry: entrySet) {
            System.out.println(entry.getKey() + " --> " + entry.getValue());
        }
        return map;

    }

    /**
     *
     * @param symptoms
     */
    public void writeSymptoms(Map<String, Integer> symptoms) {
        this.fileWriter.writeSymptoms(symptoms);
    }

}

