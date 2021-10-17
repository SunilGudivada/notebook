package practiseJava;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a program which takes as input an array of digits encoding a decimal number D
 * and updates the array to represent the number D + 1.
 */
public class PlusOne {
    public List<Integer> solve(List<Integer> list) {
        int n = list.size() - 1;

        list.set(n, list.get(n) + 1);

        for (int i = n; i > 0 && list.get(i) == 10; --i) {
            list.set(i, 0);
            list.set(i - 1, list.get(i - 1) + 1);
        }
        if (list.get(0) == 10) {
            list.set(0, 0);
            list.add(0, 1);
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> n = new ArrayList<>();

        n.add(9);
        n.add(9);

        PlusOne obj = new PlusOne();

        System.out.println(obj.solve(n));
    }
}
