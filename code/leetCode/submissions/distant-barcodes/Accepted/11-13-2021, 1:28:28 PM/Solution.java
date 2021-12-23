// https://leetcode.com/problems/distant-barcodes

class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
         Map<Integer, Integer> cnt = new HashMap<>();
        for (int i : barcodes) cnt.put(i, cnt.getOrDefault(i, 0) + 1);

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(cnt.entrySet());
        list.sort(Map.Entry.<Integer, Integer>comparingByValue().reversed());
        int l = barcodes.length, i = 0;
        int[] res = new int[l];
        for (Map.Entry<Integer, Integer> e : list) {
            int time = e.getValue();
            while (time-- > 0) {
                res[i] = e.getKey();
                i += 2;
                if (i >= barcodes.length) i = 1;
            }
        }
        return res;
    }
}