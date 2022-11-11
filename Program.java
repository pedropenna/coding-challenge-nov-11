import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Program {
    public List<Integer[]> findQuadruplets(int[] array, int targetSum) {
        Set<Set<Integer>> results = new HashSet<>();
        Set<Integer> selected = new HashSet<>();
        find(array, 0, selected, results, targetSum);

//System.out.println("Result set: " + results);
        return results.stream()
                .map(integers -> integers.toArray(new Integer[0]))
                .collect(Collectors.toList());
    }

    private void find(final int[] array, int startingIndex, final Set<Integer> selected, final Set<Set<Integer>> results, final int targetSum) {
        if (selected.size() == 4) {
            final Integer sum = selected.stream()
                    .reduce(0, (a, b) -> a + b);
            if (targetSum == sum) {
                results.add(selected);
            }
        }

        if (selected.size() < 4) {
            for (int i = startingIndex; i < array.length; i++) {
                Set<Integer> newSet = new HashSet<>(selected);
                newSet.add(array[i]);
                find(array, startingIndex + 1, newSet, results, targetSum);
            }
        }
    }

    public static void main(String[] args) {
        Program program = new Program();

//        final List<Integer[]> quadruplets = program.findQuadruplets(new int[]{7, 6, 4, -1, 1, 2}, 16);
//        final List<Integer[]> quadruplets = program.findQuadruplets(new int[]{1, 2, 3, 4, 5, 6, 7}, 10);
//        final List<Integer[]> quadruplets = program.findQuadruplets(new int[]{5, -5, -2, 2, 3, -3}, 0);
//        final List<Integer[]> quadruplets = program.findQuadruplets(new int[]{-2, -1, 1, 2, 3, 4, 5, 6, 7, 8, 9}, 4);
//        final List<Integer[]> quadruplets = program.findQuadruplets(new int[]{-1, 22, 18, 4, 7, 11, 2, -5, -3}, 30);
//        final List<Integer[]> quadruplets = program.findQuadruplets(new int[]{-10, -3, -5, 2, 15, -7, 28, -6, 12, 8, 11, 5}, 20);
//        final List<Integer[]> quadruplets = program.findQuadruplets(new int[]{1, 2, 3, 4, 5}, 100);
        final List<Integer[]> quadruplets = program.findQuadruplets(new int[]{1, 2, 3, 4, 5, -5, 6, -6}, 5);

        System.out.println("Solution");
        for (Integer[] solutionArray : quadruplets) {
            System.out.println(Arrays.asList(solutionArray));
        }
    }
}