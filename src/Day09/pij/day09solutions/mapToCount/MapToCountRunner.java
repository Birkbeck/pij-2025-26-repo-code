package pij.day09solutions.mapToCount;

import java.util.List;
import java.util.Map;

public class MapToCountRunner {
    public static void main(String[] args) {
        List<String> list = List.of("Birkbeck", "London", "Birkbeck");
        Map<String, Integer> mapToCount = MapToCount.toMapToCount(list);
        System.out.println(mapToCount);
    }
}
