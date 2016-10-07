
/**
 * @author Khyati
 * 
 *	Binary search tree implementation.
 *	Functions: add a node
 *			  find a node
 *	Traversals: inorder, preorder, postorder
 */
public class BST {
	 Node root;
	
	public  void addNode(int k,String v){
		Node newNode=new Node(k,v);
	
		
		if(root==null){
			root=newNode;
		}
		else{
			Node focusNode=root;
			Node parent;
			
			while(true){
				parent=focusNode;
				
				if(k<focusNode.key)
				{	
					focusNode=focusNode.left;
				
				if(focusNode==null)
					{parent.left=newNode;
					return;}
				}
				
				else{
					focusNode=focusNode.right;
					
					if(focusNode==null)
						{parent.right=newNode;
						return;}
				}
			}	
		}
	}
	
	/**
	 * left, parent, right
	 * @param focusNode
	 */
	public void inorder(Node focusNode){
		if(focusNode!= null){
			inorder(focusNode.left);
			System.out.println(focusNode);
			inorder(focusNode.right);
		}
	}
	
	/**
	 * parent, left, right
	 * @param focusNode
	 */
	public void preorder(Node focusNode){
		if(focusNode != null){
			System.out.println(focusNode);
			preorder(focusNode.left);
			preorder(focusNode.right);
		}
	}
	
	/**
	 * left, right, parent
	 * @param focusNode
	 */
	public void postorder(Node focusNode){
		if(focusNode != null){
			
			postorder(focusNode.left);
			postorder(focusNode.right);
			System.out.println(focusNode);
		}
	}
	
	
	public Node findNode(int number){
		
		Node focusNode=root;
		

		while(focusNode.key!=number)
		{
			if(number<focusNode.key)
				focusNode=focusNode.left;
			else
				focusNode=focusNode.right;
		
			if(focusNode==null)
				return null;
		}
		return focusNode;
	}
	
	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST tree=new BST();
		tree.addNode(30,"A");
		tree.addNode(35,"B");
		tree.addNode(10,"G");
		tree.addNode(15,"F");
		tree.addNode(50,"D");
		tree.addNode(65,"C");
		tree.addNode(6,"E");
		System.out.println("Inorder");
		tree.inorder(tree.root);
		System.out.println("Preorder");
		tree.preorder(tree.root);
		System.out.println("Postorder");
		tree.postorder(tree.root);
		System.out.println("Finding Node: ");
		System.out.println(tree.findNode(85));
	}

}

/**
 * Node class
 * @author Khyati
 *
 */

class Node{
	int key;
	String value;
	Node left,right;
	
	
	Node(int key,String value){
		this.key=key;
		this.value=value;
	}
	
	public String toString(){
		return value+" "+key;
	}
}
