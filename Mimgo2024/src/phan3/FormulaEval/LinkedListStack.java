package phan3.FormulaEval;

import java.util.EmptyStackException;
import java.util.Iterator;

public class LinkedListStack<T> implements StackInterface<T> {

	class Node {
		T element;
		Node next;
		public Node(T element) {
			this.element = element;
			next = null;
		}
		public Node(T element, Node next) {
			this.element = element;
			this.next = next;
		}
	}

	Node stack = null;

	@Override
	public void push(T element) {
		// TODO Auto-generated method stub
		Node newNode = new Node(element);
		newNode.next = stack;
		stack = newNode;
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new EmptyStackException();
		}

		T temp = stack.element;
		stack = stack.next;
		return temp;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return  stack == null;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new StackIterator();
	}

	class StackIterator implements Iterator<T> {

		private Node currentNode = stack;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return currentNode != null;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			T data = currentNode.element;
			currentNode = currentNode.next;
			return data;
		}
	}

}
