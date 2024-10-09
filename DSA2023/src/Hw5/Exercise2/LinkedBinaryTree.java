package Hw5.Exercise2;

import Hw5.Exercise1.BinaryTreeInterface;

public class LinkedBinaryTree<E> implements BinaryTreeInterface<LinkedBinaryTree.Node<E>> {

    protected static class Node<E> {
        E element;
        Node<E> parent;
        Node<E> left;
        Node<E> right;

        public Node(E e, Node<E> parent, Node<E> left, Node<E> right) {
            this.element = e;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }

    private Node<E> root;
    private int size = 0;

    public LinkedBinaryTree() {
        root = null;
    }

    @Override
    public Node<E> root() {
        return root;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public Node<E> addRoot(E element) {
        if (!isEmpty()) throw new IllegalStateException("Cây không rỗng");
        root = new Node<>(element, null, null, null);
        size++;
        return root;
    }

    public Node<E> addLeft(Node<E> p, E element) {
        if (p.left != null) throw new IllegalArgumentException("Node đã có con trái");
        Node<E> child = new Node<>(element, p, null, null);
        p.left = child;
        size++;
        return child;
    }

    public Node<E> addRight(Node<E> p, E element) {
        if (p.right != null) throw new IllegalArgumentException("Node đã có con phải");
        Node<E> child = new Node<>(element, p, null, null);
        p.right = child;
        size++;
        return child;
    }

    @Override
    public Node<E> parent(Node<E> p) {
        return p.parent;
    }

    @Override
    public Node<E> left(Node<E> p) {
        return p.left;
    }

    @Override
    public Node<E> right(Node<E> p) {
        return p.right;
    }

    @Override
    public int numChildren(Node<E> p) {
        int count = 0;
        if (p.left != null) count++;
        if (p.right != null) count++;
        return count;
    }

    @Override
    public Node<E> sibling(Node<E> p) {
        if (p.parent == null) return null;
        if (p == p.parent.left) return p.parent.right;
        else return p.parent.left;
    }
}
