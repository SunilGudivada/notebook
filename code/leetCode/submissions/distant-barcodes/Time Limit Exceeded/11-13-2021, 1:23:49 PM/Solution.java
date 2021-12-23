// https://leetcode.com/problems/distant-barcodes

class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int n = barcodes.length;
        int[] result = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int c : barcodes) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        System.out.println(map);

        int index = 0;
        while (index != n) {
            int counter = 0;

            List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
            list.sort(Map.Entry.<Integer, Integer>comparingByValue().reversed());

            for (Map.Entry<Integer, Integer> mapElement : list) {
                int key = mapElement.getKey();
                int val = mapElement.getValue();

                if (val != 0) {
                    result[index++] = key;
                    counter++;
                    map.put(key, --val);
                }
                if (counter == 2) break;
            }
        }
        return result;
    }
}