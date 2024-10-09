package Hw5.Exercise1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BinaryTreePrinter {

    // Hàm in cây nhị phân theo chiều ngang (dùng để in cây mảng hoặc liên kết)
    public static <E> void printTree(BinaryTreeInterface<E> tree, E node, int level, BufferedWriter writer) throws IOException {
        if (node == null) return;

        printTree(tree, tree.right(node), level + 1, writer);

        String padding = " ".repeat(level * 4); // Tạo khoảng cách
        writer.write(padding + tree.root() + "\n");

        printTree(tree, tree.left(node), level + 1, writer);
    }

    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            // Tạo cây nhị phân (ví dụ dùng LinkedBinaryTree)
            LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();
            LinkedBinaryTree.Node<String> root = tree.addRoot("A");
            LinkedBinaryTree.Node<String> left = tree.addLeft(root, "B");
            LinkedBinaryTree.Node<String> right = tree.addRight(root, "C");

            // Gọi hàm in cây
            printTree(tree, root, 0, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
