package com.hemebiotech.analytics;

import java.util.Map;

public interface ISymptomWriter {

    public void writeSymptoms(Map<String, Integer> symptoms);

    //writeSymptoms doit écrire les symptômes et leurs quantités
        // dans le fichier result.out au même format que précédemment.

}
