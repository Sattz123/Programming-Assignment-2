import java.io.*;
import java.util.*;

public class FileAnalyze {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int charCounter = 0;
        int palindromeCounter = 0;
        int tokenCounter = 0;
        int newLineCounter = 0;
        int longestToken = 0;
        int totalToken = 0;
        int emoticonCounter = 0;
        
        List<String> tokens = new ArrayList<>();
        List<String> emoticons = Arrays.asList(":)", ":(", ":D", ";)", ":P", "XD");
        
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Stewie\\Documents\\ADT Programming Assignment 2\\Java File\\Programming Assignment 2\\src\\input1.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                charCounter += line.length();
                newLineCounter++;
                
                String[] words = line.split("\\s+");
                for (String word : words) {
                    tokens.add(word);
                    tokenCounter++;
                    totalToken += word.length();
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        double averageTokenSize = (double) totalToken / tokenCounter;

        
        System.out.println("Program start:");
        System.out.println("Total character count: " + charCounter);
        System.out.println("Total palindrome count: " + palindromeCounter);
        System.out.println("Total number of tokens: " + tokenCounter);
        System.out.println("Total number of emoticons: " + emoticonCounter);
        System.out.println("Total number of new lines: " + newLineCounter);
        System.out.println("Longest token size: " + longestToken);
        System.out.println("Average token size: " + averageTokenSize);
        long end = System.currentTimeMillis();
        double totalTime = (end - start) / 1000.0;
        System.out.println("Execution time: " + totalTime + " seconds");
    }
    
    private static boolean isPalindrome(String word) {
        int left = 0;
        int right = word.length() - 1;
    
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
