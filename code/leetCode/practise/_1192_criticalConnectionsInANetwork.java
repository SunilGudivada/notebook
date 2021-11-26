package leetCode.practise;

import java.util.*;

public class _1192_criticalConnectionsInANetwork {
    public HashMap<Integer, List<Integer>> punInMap(Integer firstElement, Integer secondElement, HashMap<Integer, List<Integer>> map) {
        List<Integer> con = new ArrayList<>();
        if (map.containsKey(secondElement)) {
            con = map.get(secondElement);
        }
        con.add(firstElement);
        map.put(secondElement, con);
        return map;
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> res = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < connections.size(); i++) {
            Integer firstElement = connections.get(i).get(0);
            Integer secondElement = connections.get(i).get(1);
            map = punInMap(firstElement, secondElement, map);
            map = punInMap(secondElement, firstElement, map);
        }

        System.out.println(map);
        for (Map.Entry mapElement : map.entrySet()) {
            ArrayList<Integer> value = (ArrayList<Integer>) mapElement.getValue();

            Integer key = (Integer) mapElement.getKey();
            if (value.size() >1) {
//                map.remove(key);
            } else {
                int cValue = value.get(0);
                if (!s.toString().contains(String.valueOf(key)) || !s.toString().contains(String.valueOf(cValue))) {
                    s.append(key);
                    List<Integer> node = new ArrayList<>();
                    node.add(key);
                    node.add(cValue);
                    res.add(node);
                    s.append(cValue);
                }

            }
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 4;
        int[] fromArray = new int[]{0, 1, 2, 1};
        int[] toArray = new int[]{1, 2, 0, 3};

//        n=2;
//        fromArray = new int[]{0};
//        toArray = new int[]{1};

        n = 6;
        fromArray = new int[]{0,1,2,1,3,4,5};
        toArray = new int[]{1,2,0,3,4,5,3};
        List<List<Integer>> connections = new ArrayList<>();
        for (int i = 0; i < fromArray.length; i++) {
            LinkedList<Integer> node = new LinkedList<>();
            node.add(0, fromArray[i]);
            node.add(1, toArray[i]);
            connections.add(node);
        }

        System.out.println(new _1192_criticalConnectionsInANetwork().criticalConnections(n, connections));
    }
}
