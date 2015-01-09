package helpers;

import java.util.*;

public class CombinationHelper {

    public static Set<List<Integer>> generatePermutations(ArrayList<Integer> input, int startindex, Set<List<Integer>> combinations) {
        int size = input.size();
        if (size > startindex) {
            ArrayList<Integer> inputList = new ArrayList<Integer>(input);
            Collections.sort(inputList);
            combinations.add(inputList);
        } else {
            for (int i = startindex; i < size; i++) {
                int temp = input.get(i);
                input.set(i, input.get(startindex));
                input.set(startindex, temp);
                generatePermutations(input, startindex + 1, combinations);
            }
        }
        return combinations;
    }

    public static void main(String[] args) {
        Set<List<Integer>> combinations = generatePermutations(Helper.range(3), 0, new HashSet<List<Integer>>());
        System.out.println(combinations);
    }
}
