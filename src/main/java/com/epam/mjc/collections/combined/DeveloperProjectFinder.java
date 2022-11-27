package com.epam.mjc.collections.combined;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DeveloperProjectFinder {
    public List<String> findDeveloperProject(Map<String, Set<String>> projects, String developer) {
        List<String> result = new ArrayList<>();

        for(Map.Entry<String, Set<String>> e : projects.entrySet()) {
           if (e.getValue().contains(developer)) {
               result.add(e.getKey());
           }
        }
        if (!result.isEmpty()) {
            Collections.sort(result, new Comparator<String>() {
                @Override public int compare(final String o1, final String o2) {
                    if (o1.length() == o2.length()) {
                        return -o1.compareToIgnoreCase(o2);
                    }
                    return o2.length() - o1.length();
                }
            });
        }
        return result;
    }
}
