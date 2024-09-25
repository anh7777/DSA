package Hw1.Exe6.EBookReader;

// P-2.33: Mô phỏng hệ thống eBook
//Đề bài:
//Viết chương trình Java mô phỏng hệ thống đọc sách điện tử. Hệ thống phải có các chức năng mua sách mới, xem danh sách sách đã mua và đọc sách đã mua.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EBookReader {
    List<Book> availableBooks = new ArrayList<>();
    List<Book> purchasedBooks = new ArrayList<>();

    public EBookReader() {
        availableBooks.add(new Book("Moby Dick"));
        availableBooks.add(new Book("Pride and Prejudice"));
        availableBooks.add(new Book("1984"));
    }

    public void displayAvailableBooks() {
        System.out.println("Available books:");
        for (int i = 0; i < availableBooks.size(); i++) {
            System.out.println((i + 1) + ". " + availableBooks.get(i).title);
        }
    }

    public void purchaseBook(int index) {
        Book book = availableBooks.get(index - 1);
        book.purchase();
        purchasedBooks.add(book);
        System.out.println("You have purchased " + book.title);
    }

    public void displayPurchasedBooks() {
        System.out.println("Purchased books:");
        for (Book book : purchasedBooks) {
            System.out.println(book.title);
        }
    }

    public void readBook(int index) {
        purchasedBooks.get(index - 1).read();
    }

    public static void main(String[] args) {
        EBookReader reader = new EBookReader();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Display available books");
            System.out.println("2. Purchase a book");
            System.out.println("3. Display purchased books");
            System.out.println("4. Read a book");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    reader.displayAvailableBooks();
                    break;
                case 2:
                    System.out.print("Enter book number to purchase: ");
                    int bookToPurchase = scanner.nextInt();
                    reader.purchaseBook(bookToPurchase);
                    break;
                case 3:
                    reader.displayPurchasedBooks();
                    break;
                case 4:
                    System.out.print("Enter book number to read: ");
                    int bookToRead = scanner.nextInt();
                    reader.readBook(bookToRead);
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }
}
