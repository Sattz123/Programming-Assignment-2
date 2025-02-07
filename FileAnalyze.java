import java.io.*;
import java.util.*;

public class FileAnalyze {
    public static void main(String[] args) {
        int charCounter = 0;
        int palindromeCounter = 0;
        int tokenCounter = 0;
        int newLineCounter = 0;
        int longestToken = 0;
        int totalTokenLength = 0;
        int emoticonCounter = 0;

        List<String> emoticons = Arrays.asList(":)", ":(", ":D", ";)", ":P", "XD");

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Stewie\\Documents\\ADT Programming Assignment 2\\Java File\\Programming Assignment 2\\src\\input1.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                charCounter += line.length();
                newLineCounter++;

                String[] words = line.split("[^a-zA-Z0-9]+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        tokenCounter++;
                        totalTokenLength += word.length();
                        if (word.length() > longestToken) {
                            longestToken = word.length();
                        }
                        if (isPalindrome(word)) {
                            palindromeCounter++;
                        }
                        if (emoticons.contains(word)) {
                            emoticonCounter++;
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }

        double averageTokenSize = tokenCounter > 0 ? (double) totalTokenLength / tokenCounter : 0;

        System.out.println("Program start:");
        System.out.println("Total character count: " + charCounter);
        System.out.println("Total palindrome count: " + palindromeCounter);
        System.out.println("Total number of tokens: " + tokenCounter);
        System.out.println("Total number of emoticons: " + emoticonCounter);
        System.out.println("Total number of new lines: " + newLineCounter);
        System.out.println("Longest token size: " + longestToken);
        System.out.println("Average token size: " + averageTokenSize);
    }

    private static boolean isPalindrome(String word) {
        word = word.toLowerCase();
        int left = 0, right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left++) != word.charAt(right--)) {
                return false;
            }
        }
        return word.length() > 1;
    }
}
