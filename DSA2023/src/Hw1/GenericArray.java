package Hw1;

public class GenericArray<T> {
    private T[] array;

    public GenericArray(T[] array) {
        this.array = array;
    }

    public void printArray() {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
