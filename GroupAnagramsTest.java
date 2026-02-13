import java.util.*;

public class GroupAnagramsTest {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            map.computeIfAbsent(sorted, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter strings separated by commas:");
            String input = scanner.nextLine().trim();
            String[] strs = input.split("\\s*,\\s*");

            List<List<String>> result = groupAnagrams(strs);
            System.out.println("Grouped anagrams: " + result);
        }
    }
}