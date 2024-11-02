package hackerrank;

import java.util.*;

public class MostBalancedPartition {

    public static int mostBalancedPartition(int[] parent, int[] files_size) {
        int n = parent.length;
        Map<Integer, List<Integer>> children = new HashMap<>();

        // Инициализируем Map для всех узлов
        for (int i = 0; i < n; i++) {
            children.put(i, new ArrayList<>());
        }

        // Заполняем Map детьми
        for (int i = 1; i < n; i++) {
            children.get(parent[i]).add(i);
        }

        int[] size_sums = new int[n];
        Arrays.fill(size_sums, 0);

        size_sums_rec(0, children, files_size, size_sums);

        int totalWeight = size_sums[0];
        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            int subtreeWeight = size_sums[i];
            int diff = Math.abs(totalWeight - 2 * subtreeWeight);
            if (diff < minDiff) {
                minDiff = diff;
            }
        }

        return minDiff;
    }

    private static int size_sums_rec(int i, Map<Integer, List<Integer>> children, int[] files_size, int[] size_sums) {
        if (size_sums[i] != 0) {
            return size_sums[i];
        }

        int sum = files_size[i];

        for (int c : children.get(i)) {
            sum += size_sums_rec(c, children, files_size, size_sums);
        }

        size_sums[i] = sum;
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int parentCount = scanner.nextInt();
        int[] parent = new int[parentCount];
        for (int i = 0; i < parentCount; i++) {
            parent[i] = scanner.nextInt();
        }

        int filesSizeCount = scanner.nextInt();
        int[] files_size = new int[filesSizeCount];
        for (int i = 0; i < filesSizeCount; i++) {
            files_size[i] = scanner.nextInt();
        }

        int result = mostBalancedPartition(parent, files_size);
        System.out.println(result);

        scanner.close();
    }
}

