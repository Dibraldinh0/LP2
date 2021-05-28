import java.util.LinkedList;

public class LinkedStack implements IStackable{
	private LinkedList<Integer> LinkedLista = new LinkedList<Integer>();
	
	@Override
	public int size() {
		return LinkedLista.size();
	}

	@Override
	public void push(int v) {
		LinkedLista.addFirst(v);
	}

	@Override
	public int pop() {
		return (int) LinkedLista.removeFirst();
	}

}
