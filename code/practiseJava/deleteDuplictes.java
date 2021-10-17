package practiseJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class deleteDuplictes {

    public List<Integer> solve(List<Integer> list) {
        if (list.isEmpty()) {
            return new ArrayList<>();
        }
        int writeIndex = 1;
        for (int i = 0; i < list.size(); ++i) {
            if (!list.get(writeIndex - 1).equals(list.get(i))) {
                list.set(writeIndex++, list.get(i));
            }
        }
        return list.subList(0, writeIndex);
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(2, 3, 5, 5, 7, 11, 11, 11, 13);
        deleteDuplictes obj = new deleteDuplictes();
        System.out.println(obj.solve(input));
    }
}
