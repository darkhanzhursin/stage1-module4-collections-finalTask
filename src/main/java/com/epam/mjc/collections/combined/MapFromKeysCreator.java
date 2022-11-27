package com.epam.mjc.collections.combined;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class MapFromKeysCreator {

    private Set<String> setFromMap(List<String> list, int length) throws Exception {
        try {
            // creating object of Map<String, Boolean>
            Map<String, Boolean>
                map = new WeakHashMap<String, Boolean>();

            // creating object of LinkedList
            Set<String> set = Collections.newSetFromMap(map);

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).length() == length) {
                    set.add(list.get(i));
                }
            }

            return set;
        } catch (IllegalArgumentException e) {
            System.out.println("Exception thrown : " + e);
        }
        return null;
    }
    public Map<Integer, Set<String>> createMap(Map<String, Integer> sourceMap) {
        Map<Integer, Set<String>> result = new HashMap<>();
        List<Integer> listOflength = new ArrayList<>();
        List<String> listOfWords = new ArrayList<>();
        Set<Integer> integersSet = new HashSet<>();


        for(Map.Entry<String, Integer> e : sourceMap.entrySet()) {
            listOfWords.add(e.getKey());
            integersSet.add(e.getKey().length());
        }

        Iterator<Integer> iterator = integersSet.iterator();
        while (iterator.hasNext()) {
            listOflength.add(iterator.next());
        }

        for (int i = 0; i < listOflength.size(); i++) {
            try {
                result.put(listOflength.get(i),
                    setFromMap(listOfWords, listOflength.get(i)));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return result;
    }
}
