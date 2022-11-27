package com.epam.mjc.collections.combined;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LessonsGetter {
    public Set<String> getLessons(Map<String, List<String>> timetable) {
        Set<String> lessons = new HashSet<>();
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, List<String>> e : timetable.entrySet()) {
            for (int i = 0; i < e.getValue().size(); i++) {
                list.add(e.getValue().get(i));
            }
        }

        Iterator iterator = list.iterator();

        while (iterator.hasNext()) {
            lessons.add((String) iterator.next());
        }


        return lessons;
    }
}
