package helpers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by tushar.naik on 08/01/15.
 */
public class Helper {

    public static ArrayList<Integer> range(int end) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int i = 1;
        while (i <= end) {
            arrayList.add(i++);
        }
        return arrayList;
    }

    public static ArrayList<Integer> range(int start, int end) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int i = start;
        while (i <= end) {
            arrayList.add(i++);
        }
        return arrayList;
    }

    private static Set<List<Integer>> generatePermutations(ArrayList<Integer> input, int startIndex, Set<List<Integer>> combinations) {
        int size = input.size();
        if (size == startIndex + 1) {
            combinations.add(new ArrayList<Integer>(input));
        } else {
            for (int i = startIndex; i < size; i++) {
                int temp = input.get(i);
                input.set(i, input.get(startIndex));
                input.set(startIndex, temp);
                generatePermutations(input, startIndex + 1, combinations);
            }
        }
        return combinations;
    }

    public static Set<List<Integer>> generatePermutations(ArrayList<Integer> input) {
        return generatePermutations(input, 0, new HashSet<List<Integer>>());
    }
}