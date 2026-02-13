import java.util.*;

public class SubarraySumTest {

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num;

            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter numbers separated by spaces or commas:");
        String line = scanner.nextLine().trim();
        if (line.isEmpty()) {
            System.out.println("No numbers provided.");
            return;
        }

        String[] parts = line.split("[,\\s]+");

        int[] nums = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i].trim());
        }

        System.out.print("Enter k: ");
        int k = scanner.nextInt();

        int result = subarraySum(nums, k);
        System.out.println("Number of subarrays = " + result);
    }
}
