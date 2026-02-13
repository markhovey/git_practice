import java.util.*;

public class LongestRepeatingCharacterReplacementTest {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;

        for(int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            count[c - 'A']++;
            maxFreq = Math.max(maxFreq, count[c - 'A']);

            int windowSize = right - left + 1;

            if (windowSize - maxFreq > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
            System.out.println("Processing index " + right + ": char='" + c + "' (left=" + left + ")");
            System.out.println("Right: " + right + ", Left: " + left + ", MaxFreq: " + maxFreq + ", WindowSize: " + windowSize + ", MaxLength: " + maxLength);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a string:");
            String input = scanner.nextLine();
            System.out.println("Enter the value of k:");
            int k = scanner.nextInt();

            LongestRepeatingCharacterReplacementTest test = new LongestRepeatingCharacterReplacementTest();
            int result = test.characterReplacement(input, k);
            System.out.println("Length of the longest substring after replacement: " + result);
        }
    }  
}
