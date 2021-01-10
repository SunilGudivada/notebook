package leetCode.problems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1436_DestinationCity {
  public String destCity(List<List<String>> paths) {
    Map<String, Integer> map = new HashMap<>();
    for (List<String> pairs : paths) {
      String fromCity = pairs.get(0);
      String toCity = pairs.get(1);
      if (map.containsKey(fromCity)) map.put(fromCity, map.get(fromCity) + 1);
      else map.put(fromCity, 1);
      if (map.containsKey(toCity)) map.put(toCity, map.get(toCity) + 1);
      else map.put(toCity, 1);
    }
    for (List<String> pairs : paths) {
      String toCity = pairs.get(1);
      if (map.containsKey(toCity) && map.get(toCity) == 1) return toCity;
    }
    return "";
  }

  public String destCity2(List<List<String>> paths) {
    HashMap<String, String> map = new HashMap<>();
    for (List<String> path : paths) {
      map.put(path.get(0), path.get(1));
    }
    for (HashMap.Entry<String, String> entry : map.entrySet()) {
      String end = entry.getValue();
      if (!map.containsKey(end)) {
        return end;
      }
    }
    return "";
  }
}
