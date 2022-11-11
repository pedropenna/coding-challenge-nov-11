import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Program {
    public List<Integer[]> findQuadruplets(int[] array, int targetSum) {
        Set<Set<Integer>> results = new HashSet<>();
//        foo(array, results, targetSum);
        return null;
    }

    public static void main(String[] args) {
        Program program = new Program();

        final List<Integer[]> quadruplets = program.findQuadruplets(new int[]{7, 6, 4, -1, 1, 2}, 16);

        System.out.println(quadruplets);
    }
}