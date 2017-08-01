import java.util.*;

public class Node{
    public int data;
    public Node left;
    public Node right;
    
    Node(int val){
        this.data = val; 
        this.left = null;
        this.right = null;
    }
    
    @Override
    public String toString() {
        return "Node{" + this.data + '}';
    }
    
}



public class BSTDistance
{
	
	//Construct binary serach tree
	public static Node insert(Node root, int val){
	    
	    if(root == null){
	        Node node = new Node(val);
	        root = node;
	    }else{
	        if(val <= root.data)    root.left = insert(root.left, val);
	        else    root.right = insert(root.right, val);
	    }
	    return root;
	}
	
	//Check if a value exist in BST
	public static boolean check(Node root, int value){
	    if(root == null)    return false;
	    
	    if(root.data == value)    return true;
	    else if(root.data > value)    return check(root.left, value);
	    else return check(root.right, value);
	    
	}
	
	
	//Find lowest common ancestor
	public static Node LCA(Node root, int value1, int value2){
	    //check if both nodes exist in BST
	    if(!check(root, value1)||!check(root, value2))    return null;
	    
	    //if(root == null)    return root;
	    
	    if(root.data > value1 && root.data > value2)    return LCA(root.left, value1, value2);
	    else if(root.data < value1 && root.data < value2)    return LCA(root.right, value1, value2);
	    else    return root;
	    
	}
	
	public static int distance(Node root, int value1, int value2){
	    Node lca = LCA(root, value1, value2);
	    
	    //no route between two nodes
	    if(lca == null)    return -1;
	    
	    int dis1 = 0;
	    int dis2 = 0;
	    Node node1 = lca;
	    Node node2 = lca;
	    
	    while(node1.data != value1){
	        if(node1.data > value1)    node1 = node1.left;
	        else    node1 = node1.right;
	        dis1++;
	    }
	    
	    while(node2.data != value2){
	        if(node2.data > value2)    node2 = node2.left;
            else    node2 = node2.right;
	        dis2++;
	    }
	    return dis1 + dis2;
	}
	
	
	public static void main(String[] args) {
		//int[] values = {5, 6, 3, 1, 2, 4}; 
		int[] values = {9, 6, 15, 8, 4, 5, 1, 7, 13, 17, 11, 14, 19};
		
		Node root = null;
        for(int val : values){
            root = insert(root, val);
        }
        
		System.out.println(distance(root, 1, 19));
	}
	
}