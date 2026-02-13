import java.util.*;

public class TopKFrequentElementsTest {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> frequencyMap.get(b) - frequencyMap.get(a));

        heap.addAll(frequencyMap.keySet());

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter numbers separated by commas:");
            String input = scanner.nextLine().trim();
            String[] numStrs = input.split("\\s*,\\s*");
            int[] nums = Arrays.stream(numStrs).mapToInt(Integer::parseInt).toArray();

            System.out.println("Enter the value of k:");
            int k = scanner.nextInt();

            TopKFrequentElementsTest test = new TopKFrequentElementsTest();
            int[] result = test.topKFrequent(nums, k);
            System.out.println("Top " + k + " frequent elements: " + Arrays.toString(result));
        }
    }
}
