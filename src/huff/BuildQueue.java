
package huff;

import java.util.*;

public class BuildQueue implements PQ {
	
	static PriorityQueue<Node> p = new PriorityQueue<>();

	@Override
	public Node extractMin() {
		
		
		// TODO Auto-generated method stub
		return p.poll();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return p.size();
	}

	@Override
	public Node peek() {
		// TODO Auto-generated method stub
		return p.peek();
	}

	@Override
	public void add(Node node) {
		// TODO Auto-generated method stub
		p.add(node);
		
	}




}
