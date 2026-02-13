import java.util.*;

public class LengthOfLongestSubstringTest {
    public LengthOfLongestSubstringTest() {
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            // Debug output: show current window and internal state
            System.out.println("Processing index " + right + ": char='" + currentChar + "' (left=" + left + ")");

            if (map.containsKey(currentChar) && map.get(currentChar) >= left) {
                int prevIndex = map.get(currentChar);
                left = prevIndex + 1;
                System.out.println("  Found duplicate '" + currentChar + "' at index " + prevIndex + ", moving left to " + left);
            }

            map.put(currentChar, right);
            maxLength = Math.max(maxLength, right - left + 1);
            System.out.println("  After index " + right + ": left=" + left + ", maxLength=" + maxLength + ", map=" + map);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a string:");
            String input = scanner.nextLine();
            int result = lengthOfLongestSubstring(input);
            System.out.println("Length of the longest substring without repeating characters: " + result);
        }
    }
}
