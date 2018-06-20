package huff;

 

public class huffmanTree {
	Node ptr;
	
	public void buildTree(PQ p)
	{
		while(p.size() > 1)
		{
			Node left = p.extractMin();
			Node right = p.extractMin();
			int newfrequency = left.frequency + right.frequency;
			Node leafnode = new Node(-1,newfrequency, left, right);
			p.add(leafnode);
			
		}
		ptr = p.peek();
	}

}
