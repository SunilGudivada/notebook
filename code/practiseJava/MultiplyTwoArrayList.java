package practiseJava;

import java.util.*;

public class MultiplyTwoArrayList {

    public List<Integer> solve(List<Integer> l1, List<Integer> l2) {
        int sign = (l1.get(0) * l2.get(0) < 0) ? -1 : 1;
        List<Integer> res = new ArrayList<>(Collections.nCopies(l1.size() + l2.size(), 0));
        int l1_size = l1.size() - 1;
        int l2_size = l2.size() - 1;

        for (int i = l1_size; i >= 0; --i) {
            for (int j = l2_size; j >= 0; --j) {
                int ele = res.get(i + j + 1) + l1.get(i) * l2.get(j);
                res.set(i + j, res.get(i + j) + ele / 10);
                res.set(i + j + 1, ele % 10);
            }
        }

        int first_not_zero = 0;
        while (first_not_zero < res.size() && res.get(first_not_zero) == 0) {
            ++first_not_zero;
        }
        res = res.subList(first_not_zero, res.size());
        if (res.isEmpty()) {
            return Arrays.asList(0);
        }
        res.set(0, res.get(0) * sign);
        return res;

    }

    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>(Arrays.asList(1, 1, 9));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(9, 9, 9));
        MultiplyTwoArrayList obj = new MultiplyTwoArrayList();

        System.out.println(obj.solve(l1, l2));
    }
}
