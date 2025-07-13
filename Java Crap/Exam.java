import java.util.Scanner;

public class Exam {
    public static String constructLongestPalindrome(String S) {
        // Array to store the frequency of each letter
        int[] charCount = new int[26];
        
        // Count frequencies
        for (char c : S.toCharArray()) {
            charCount[c - 'A']++;
        }

        // Constructing the palindrome
        char middleChar = 0; // To hold a possible middle character
        String leftHalf = ""; // Left half of the palindrome
        String rightHalf = ""; // Right half of the palindrome
        
        for (int i = 0; i < 26; i++) {
            // How many pairs we can use
            int pairs = charCount[i] / 2;
            // Append pairs to the left half
            for (int j = 0; j < pairs; j++) {
                leftHalf += (char) (i + 'A');
            }
            // If there is an odd count, we can use one character as the middle
            if (charCount[i] % 2 == 1 && middleChar == 0) {
                middleChar = (char) (i + 'A');
            }
        }

        // Create the right half as a reverse of the left half
        for (int i = leftHalf.length() - 1; i >= 0; i--) {
            rightHalf += leftHalf.charAt(i);
        }

        // Combine the parts to form the palindrome
        return middleChar == 0 ? leftHalf + rightHalf : leftHalf + middleChar + rightHalf;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string (only capital letters): ");
        String S = scanner.nextLine();
        
        System.out.println("Longest Palindrome: " + constructLongestPalindrome(S));
        
        scanner.close();
    }
}