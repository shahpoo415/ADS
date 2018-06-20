package huff;

import java.util.ArrayList;

public class BinaryHeaps implements PQ{
	ArrayList<Node> arr = new ArrayList<>();
	@Override
	public Node extractMin() {
		// TODO Auto-generated method stub
		
		Node temp = arr.get(0);
		arr.set(0, arr.get(size()-1));
		minHeapify(arr, 0);
		return temp;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		
		return arr.size();
	}

	@Override
	public Node peek() {
		// TODO Auto-generated method stub
		
		return arr.get(0);
	}

	@Override
	public void add(Node node) {
		// TODO Auto-generated method stub
		
		arr.add(node);
		
	}
	
	public void minHeapify(ArrayList arr, int i)
	{
		int left = 2*i+1;
		int right = 2*i+2;
		
		
	}
	
}
