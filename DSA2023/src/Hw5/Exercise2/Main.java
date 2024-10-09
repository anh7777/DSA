package Hw5.Exercise2;

public class Main {
    public static void main(String[] args) {
        ExpressionTree<String> expTree = new ExpressionTree<>();

        // Xây dựng cây nhị phân cho biểu thức: ((6 / 3) + 2) * (7 - 4)
        LinkedBinaryTree.Node<String> root = expTree.addRoot("*");
        LinkedBinaryTree.Node<String> left = expTree.addLeft(root, "+");
        LinkedBinaryTree.Node<String> right = expTree.addRight(root, "-");
        expTree.addLeft(left, "/");
        expTree.addRight(left, "2");
        expTree.addLeft(expTree.left(left), "6");
        expTree.addRight(expTree.left(left), "3");
        expTree.addLeft(right, "7");
        expTree.addRight(right, "4");

        // In biểu thức dưới các dạng tiền tố, trung tố, hậu tố
        System.out.println("Prefix (Tiền tố): ");
        expTree.preorderPrint(root); // Kết quả: * + / 6 3 2 - 7 4
        System.out.println();

        System.out.println("Infix (Trung tố): ");
        expTree.inorderPrint(root); // Kết quả: 6 / 3 + 2 * 7 - 4
        System.out.println();

        System.out.println("Postfix (Hậu tố): ");
        expTree.postorderPrint(root); // Kết quả: 6 3 / 2 + 7 4 - *
        System.out.println();



        expTree.addLeft(left, "/");
        expTree.addRight(left, "2");
        expTree.addLeft(expTree.left(left), "6");
        expTree.addRight(expTree.left(left), "3");
        expTree.addLeft(right, "7");
        expTree.addRight(right, "4");

        // Tính toán giá trị của biểu thức
        int result = expTree.evaluate(root);
        System.out.println("Giá trị của biểu thức: " + result); // Kết quả: 12

    }
}
