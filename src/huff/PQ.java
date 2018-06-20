package huff;

public interface PQ {
		
	public Node extractMin();
	
	public int size();
	
	public Node peek();
	
	public void add(Node node);

	
}
