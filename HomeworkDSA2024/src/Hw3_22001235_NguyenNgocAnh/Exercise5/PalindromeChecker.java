package Hw3_22001235_NguyenNgocAnh.Exercise5;
//Chuỗi đối xứng thông thường (palindrome) là khi các ký tự được viết xuôi hay ngược cũng là giống nhau
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class PalindromeChecker {
    public static boolean isPalindrome(String str) {
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        str = str.toLowerCase().replaceAll("[^a-z]", "");

        for (char c : str.toCharArray()) {
            stack.push(c);
            queue.add(c);
        }

        while (!stack.isEmpty()) {
            if (stack.pop() != queue.poll()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String testStr1 = sc.nextLine();
        String testStr2 = sc.nextLine();

        System.out.println(isPalindrome(testStr1));
        System.out.println(isPalindrome(testStr2));
    }
}
