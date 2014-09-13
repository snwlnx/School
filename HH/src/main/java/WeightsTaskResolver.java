import java.util.ArrayList;
import java.util.List;


public class WeightsTaskResolver {

    public List<List<Integer>> findEqualsSubLists(int[] array) {

        int weight = getTotalWeight(array), n = array.length;

        if (weight % 2 == 1) {
            return null;
        }

        weight /= 2;

        int[][] subSequenceWeights = calculateSubSequenceMatrix(array, weight);

        if (subSequenceWeights[n][weight] != weight) {
            return null;
        }

        List<Integer> firstEqualSubList = new ArrayList<>(),
                secondEqualSubList = new ArrayList<>();
        for (int i : array) {
            firstEqualSubList.add(i);
        }

        int s = weight, i = array.length;
        while (s > 0 && i > 0) {
            if (array[i - 1] <= s && subSequenceWeights[i][weight] == subSequenceWeights[i - 1][weight - array[i - 1]] + array[i - 1]) {
                firstEqualSubList.remove((Integer) array[i - 1]);
                secondEqualSubList.add(array[i - 1]);
                s -= array[i - 1];
            }
            i--;
        }

        List<List<Integer>> equalsSubLists = new ArrayList<>();
        equalsSubLists.add(firstEqualSubList);
        equalsSubLists.add(secondEqualSubList);
        return equalsSubLists;
    }


    private int getTotalWeight(int[] arr) {
        int weight = 0;
        for (int w : arr) {
            weight += w;
        }
        return weight;
    }


    private int[][] calculateSubSequenceMatrix(int[] array, int targetWeight) {
        int n = array.length;
        int totalWeights = getTotalWeight(array);

        if (totalWeights < targetWeight || targetWeight < 0) {
            return null;
        }

        int[][] subSequenceWeight = new int[n + 1][targetWeight + 1];

        for (int i = 1; i <= n; ++i) {
            for (int s = 1; s <= targetWeight; ++s) {
                subSequenceWeight[i][s] = (array[i - 1] > s || subSequenceWeight[i - 1][s - array[i - 1]] + array[i - 1] > s) ?
                        subSequenceWeight[i - 1][s] : subSequenceWeight[i - 1][s - array[i - 1]] + array[i - 1];
            }
        }
        return subSequenceWeight;
    }


    public boolean checkContainsWeight(int[] weights, int targetWeight) {
        boolean contains = false;
        int[][] subSequenceWeights = calculateSubSequenceMatrix(weights, targetWeight);

        if (subSequenceWeights != null) {
            for (int[] subSequence : subSequenceWeights) {
                if (subSequence[targetWeight] == targetWeight) {
                    contains = true;
                }
            }
        }
        return contains;
    }
}
