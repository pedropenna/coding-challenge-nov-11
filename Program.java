import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Program {
    public List<Integer[]> findQuadruplets(int[] array, int targetSum) {
        Set<Set<Integer>> results = new HashSet<>();
        Set<Integer> selected = new HashSet<>();
        find(array, 0, selected, results, targetSum);

        System.out.println(results);
        return null;
    }

    private void find(final int[] array, int startingIndex, final Set<Integer> selected, final Set<Set<Integer>> results, final int targetSum) {
//System.out.println("find");
        final Integer sum = selected.stream()
                .reduce(0, (a, b) -> a + b);
//System.out.println("sum: " + sum);
        if (targetSum == sum) {
//System.out.println("target reached!");
            results.add(selected);
        }

        for (int i = startingIndex; i < array.length; i++) {
            Set<Integer> newSet = new HashSet<>(selected);
            newSet.add(array[i]);
            find(array, startingIndex + 1, newSet, results, targetSum);
        }
    }

    public static void main(String[] args) {
        Program program = new Program();

        final List<Integer[]> quadruplets = program.findQuadruplets(new int[]{7, 6, 4, -1, 1, 2}, 16);

        System.out.println(quadruplets);
    }
}