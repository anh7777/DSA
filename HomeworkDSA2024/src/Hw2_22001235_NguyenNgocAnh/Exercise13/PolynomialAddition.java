package Hw2_22001235_NguyenNgocAnh.Exercise13;

public class PolynomialAddition {
    class Node {
        int coefficient;
        int power;
        Node next;

        Node(int coeff, int pow) {
            this.coefficient = coeff;
            this.power = pow;
            this.next = null;
        }
    }

    public Node addPolynomials(Node poly1, Node poly2) {
        Node result = null;
        Node tail = null;

        while (poly1 != null && poly2 != null) {
            Node newNode;
            if (poly1.power > poly2.power) {
                newNode = new Node(poly1.coefficient, poly1.power);
                poly1 = poly1.next;
            } else if (poly1.power < poly2.power) {
                newNode = new Node(poly2.coefficient, poly2.power);
                poly2 = poly2.next;
            } else {
                int coeffSum = poly1.coefficient + poly2.coefficient;
                if (coeffSum != 0) {
                    newNode = new Node(coeffSum, poly1.power);
                } else {
                    poly1 = poly1.next;
                    poly2 = poly2.next;
                    continue;
                }
                poly1 = poly1.next;
                poly2 = poly2.next;
            }

            if (result == null) {
                result = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        while (poly1 != null) {
            Node newNode = new Node(poly1.coefficient, poly1.power);
            tail.next = newNode;
            tail = newNode;
            poly1 = poly1.next;
        }

        while (poly2 != null) {
            Node newNode = new Node(poly2.coefficient, poly2.power);
            tail.next = newNode;
            tail = newNode;
            poly2 = poly2.next;
        }

        return result;
    }

    public void printPolynomial(Node head) {
        while (head != null) {
            System.out.print(head.coefficient + "x^" + head.power);
            if (head.next != null) System.out.print(" + ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        PolynomialAddition poly = new PolynomialAddition();

        Node poly1 = poly.new Node(5, 2);
        poly1.next = poly.new Node(4, 1);
        poly1.next.next = poly.new Node(2, 0);

        Node poly2 = poly.new Node(3, 2);
        poly2.next = poly.new Node(2, 1);
        poly2.next.next = poly.new Node(1, 0);

        Node result = poly.addPolynomials(poly1, poly2);
        System.out.println("Sum of Polynomials:");
        poly.printPolynomial(result);
    }
}
