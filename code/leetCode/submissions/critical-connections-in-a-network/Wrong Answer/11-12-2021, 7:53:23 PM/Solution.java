// https://leetcode.com/problems/critical-connections-in-a-network

class Solution {
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
}