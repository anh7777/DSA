package Hw4.Exercise5;

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class PalindromeChecker {
    public static boolean isPalindrome(String str) {
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        // Chuyển đổi chuỗi thành chữ thường và loại bỏ khoảng trắng
        str = str.toLowerCase().replaceAll("[^a-z]", "");

        // Thêm các ký tự vào stack và queue
        for (char c : str.toCharArray()) {
            stack.push(c);
            queue.add(c);
        }

        // Kiểm tra xem các ký tự có khớp nhau không
        while (!stack.isEmpty()) {
            if (stack.pop() != queue.poll()) {
                return false; // Không phải Palindrome
            }
        }
        return true; // Là Palindrome
    }

    public static void main(String[] args) {
        String testStr1 = "A man a plan a canal Panama";
        String testStr2 = "Hello";

        System.out.println(isPalindrome(testStr1)); // In ra true
        System.out.println(isPalindrome(testStr2)); // In ra false
    }
}
