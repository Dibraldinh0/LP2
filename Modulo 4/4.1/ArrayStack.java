import java.util.ArrayList;

public class ArrayStack implements IStackable{
	private ArrayList<Integer> ArrayLista = new ArrayList<Integer>();
	
	@Override
	public int size() {
		return ArrayLista.size();
	}

	@Override
	public void push(int v) {
		ArrayLista.add(v);
	}

	@Override
	public int pop() {
		return (int) ArrayLista.remove(ArrayLista.size()-1);
	}

}

