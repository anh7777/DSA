package phan3.WordCount;

import java.util.Iterator;
@SuppressWarnings({"unchecked", "deprecation"})
public class SimpleArrayList<T> implements ListInterface<T> {

	private T[] array;
	private int n = 0;
	private int defaultSize = 100;

	public SimpleArrayList() {
		array = (T[]) new Object[defaultSize];
	}

	public SimpleArrayList(int capacity) {
		// Hàm dựng với kích thước mảng là capacity
		array = (T[]) new Object[capacity];
	}

	public void add(T data) {
		if (n == array.length) {
			T[] newArray = (T[]) new Object[array.length * 2];
			System.arraycopy(array, 0, newArray, 0, array.length);
			array = newArray;
		}
		array[n] = data;
		n++;
	}

	public T get(int i) {
		if (i < 0 || i >= n) {
			throw new IndexOutOfBoundsException();
		}
	    return array[i];
	}

	public void set(int i, T data)
	{
	    if (i < 0 || i >= n) {
			throw new IndexOutOfBoundsException();
		}
		array[i] = data;
	}
	public void remove(int i) {
		if (i < 0 || i >= n) {
			throw new IndexOutOfBoundsException();
		}

		for (int j = i; j < n; j++) {
			array[j] = array[j + 1];
		}
		array[n-1] = null;
		n--;

		if (n > 0 && n < array.length/4) {
			T[] newArray = (T[]) new Object[array.length/2];
			System.arraycopy(array, 0, newArray, 0, array.length);
			array = newArray;
		}
	}

	public boolean isContain(T data) {

		return indexOf(data) != -1;
	}
	
	public int indexOf(T data) {
		for (int i = 0; i < n; i++) {
			if (array[i].equals(data)) {
				return i;
			}
		}
		return -1;
	}

	public int size() {
		return n;
	}

	public boolean isEmpty() {
		return n==0;
	}

	public Iterator<T> iterator() {
		return new ArrayListIterator();
	}
	
	class ArrayListIterator implements Iterator<T>
	{
		private int current = 0;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current  < n;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			T data = array[current];
			current++;
			return data;
		}
		
	}

}
