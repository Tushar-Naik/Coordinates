package helpers;

import java.util.*;

public class Helper {

    public static ArrayList<Integer> range(int end) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int i = 0;
        while (i < end) {
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
        if (size > startIndex) {
            ArrayList<Integer> inputList = new ArrayList<Integer>(input);
            Collections.sort(inputList);
            combinations.add(inputList);
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
