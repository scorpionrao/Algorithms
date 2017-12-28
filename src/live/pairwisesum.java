package live;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class pairwisesum {

    /*
        [1, 10, 5, 4, 8, 2, 3]
        6
        [1, 5]

        Time - O(N^2)
        Space - O(1)
     */
    public static int[] getFirstPair(int[] array, int target) {

        for(int i = 0; i < array.length; i++) {
            if(array[i] < target) {
                for(int j = i+1; j < array.length; j++) {
                    if(array[i] + array[j] == target) {
                        return new int[]{array[i], array[j]};
                    }
                }
            }
        }
        return new int[0];
    }

    /*
        Faster solution
        Time - O(N)
        Space - O(N)
     */
    public static int[] getFirstPairFast(int[] array, int target) {

        Set<Integer> remainingRequired = new HashSet<>();
        for(int i = 0; i < array.length; i++) {
            if(array[i] < target) {
                if(!remainingRequired.contains(array[i])) {
                    remainingRequired.add(target - array[i]);
                } else {
                    return new int[]{target - array[i], array[i]};
                }
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 10, 6, 6, 8, 2, 3, 3};
        int target = 6;
        int[] firstPair = getFirstPairFast(array, target);
        assert firstPair[0] + firstPair[1] == target;
        System.out.println(firstPair[0] + " " + firstPair[1]);
    }
}
