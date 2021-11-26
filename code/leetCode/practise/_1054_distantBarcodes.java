package leetCode.practise;

import java.util.*;

public class _1054_distantBarcodes {

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
            System.out.println(Arrays.toString(res));
        }
        return res;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 1, 2, 2, 3, 3};

        System.out.println(Arrays.toString(new _1054_distantBarcodes().rearrangeBarcodes(arr)));
    }
}
