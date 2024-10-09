package Hw5.Exercise2;

public class ExpressionTree<E> extends LinkedBinaryTree<E> {

    // Duyệt cây theo thứ tự trước (Pre-order traversal)
    public void preorderPrint(Node<E> p) {
        if (p == null) return;
        System.out.print(p.element + " ");  // In nút hiện tại
        preorderPrint(p.left);              // Duyệt cây con trái
        preorderPrint(p.right);             // Duyệt cây con phải
    }

    // Duyệt cây theo thứ tự sau (Post-order traversal)
    public void postorderPrint(Node<E> p) {
        if (p == null) return;
        postorderPrint(p.left);             // Duyệt cây con trái
        postorderPrint(p.right);            // Duyệt cây con phải
        System.out.print(p.element + " ");  // In nút hiện tại
    }

    // Duyệt cây theo thứ tự giữa (In-order traversal)
    public void inorderPrint(Node<E> p) {
        if (p == null) return;
        inorderPrint(p.left);               // Duyệt cây con trái
        System.out.print(p.element + " ");  // In nút hiện tại
        inorderPrint(p.right);              // Duyệt cây con phải
    }

    // Phương thức tính toán giá trị của biểu thức
    public int evaluate(Node<String> p) {
        if (p == null) return 0;

        // Nếu node là một toán hạng (số), trả về giá trị số nguyên của nó
        if (isOperand(p.element)) {
            return Integer.parseInt(p.element);
        }

        // Tính giá trị của con trái và con phải
        int leftVal = evaluate(p.left);
        int rightVal = evaluate(p.right);

        // Thực hiện phép toán giữa con trái và con phải
        switch (p.element) {
            case "+":
                return leftVal + rightVal;
            case "-":
                return leftVal - rightVal;
            case "*":
                return leftVal * rightVal;
            case "/":
                return leftVal / rightVal;
            default:
                throw new IllegalArgumentException("Toán tử không hợp lệ: " + p.element);
        }
    }

    // Kiểm tra xem một node có phải là toán hạng hay không
    private boolean isOperand(String element) {
        try {
            Integer.parseInt(element);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
