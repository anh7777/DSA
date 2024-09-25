package phan3.FormulaEval;

public interface StackInterface<T> extends Iterable<T> {

	public void push(T element);

	public T pop();

	public boolean isEmpty();

}
