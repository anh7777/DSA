package Hw1.Exe6;
//Bài tập: P-2.30 – Biểu đồ cột tần suất ký tự
//Yêu cầu:
//Chương trình sẽ nhập một tài liệu (văn bản) và tính tần suất xuất hiện của từng ký tự chữ cái trong bảng chữ cái tiếng Anh.
//Sau đó, xuất biểu đồ cột thể hiện tần suất này.

//Giải pháp:
//Nhập tài liệu: Có thể nhập văn bản từ một file hoặc từ đầu vào tiêu chuẩn (standard input).
//Tính toán tần suất: Chương trình sẽ duyệt qua văn bản, tính tần suất xuất hiện của từng chữ cái (chỉ xét chữ cái trong bảng chữ cái tiếng Anh).
//Xuất biểu đồ cột: Biểu đồ cột sẽ hiển thị tần suất dưới dạng các dòng chứa ký tự và số lượng tương ứng, ví dụ:

//Giải thích mã:
//Mảng frequencies[26]: Đây là mảng chứa tần suất xuất hiện của từng ký tự từ A đến Z. Mỗi phần tử của mảng tương ứng với một chữ cái.
//Đọc văn bản từ đầu vào: Chúng ta sử dụng Scanner để nhận văn bản từ người dùng và chuyển tất cả các ký tự thành chữ hoa (để tránh phân biệt giữa chữ hoa và chữ thường).
//Tính tần suất: Đối với mỗi ký tự trong chuỗi văn bản, nếu ký tự đó là một chữ cái (A-Z), chương trình sẽ tăng tần suất tương ứng trong mảng.
//Xuất biểu đồ: Chương trình in ký tự và sử dụng dấu * để biểu diễn số lần xuất hiện của ký tự đó.

import java.util.Scanner;

public class CharacterFrequencyBarChart {
    public static void main(String[] args) {
        // Mảng để lưu tần suất các chữ cái từ A-Z (26 phần tử)
        int[] frequencies = new int[26];

        // Nhập tài liệu từ bàn phím
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập văn bản của bạn:");
        String input = scanner.nextLine().toUpperCase(); // Đổi tất cả chữ thường thành chữ hoa

        // Duyệt qua từng ký tự trong văn bản
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            // Kiểm tra nếu ký tự là chữ cái (A-Z)
            if (c >= 'A' && c <= 'Z') {
                frequencies[c - 'A']++; // Tăng tần suất cho ký tự tương ứng
            }
        }

        // Xuất biểu đồ cột
        System.out.println("Biểu đồ tần suất ký tự:");
        for (int i = 0; i < frequencies.length; i++) {
            char letter = (char) ('A' + i);
            System.out.print(letter + ": ");
            // In số lượng ký tự bằng cách sử dụng dấu '*'
            for (int j = 0; j < frequencies[i]; j++) {
                System.out.print("*");
            }
            System.out.println(); // Xuống dòng sau mỗi chữ cái
        }

        scanner.close();
    }
}

