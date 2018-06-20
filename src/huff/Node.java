package huff;

public class Node implements Comparable<Node>{
	
		 int  key,frequency;
		 Node left, right;
		 Node ptr;
		 
		 public Node(int key, int frequency, Node left, Node right){
			 this.key = key;
			 this.frequency = frequency;
			 
			 this.left=left;
			 this.right=right;
			 
		 }

		@Override
		public int compareTo(Node arg0) {
			return this.frequency-arg0.frequency;
		}
		 
		
	 }


