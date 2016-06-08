package invert_Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Invert_Binary_Tree {
	
	public TreeNode invertTree(TreeNode root) {
		
		TreeNode temp;
		if (root == null) {
			return root;
		} else {
			temp = invertTree(root.right);
			root.right = invertTree(root.left);
			root.left = temp;
			return root;
		}
			
	}
	
	public TreeNode invertTree_BFT(TreeNode root) {
		
		TreeNode temp;
		
		Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
		TreeNode currentNode = root;
		nodeQueue.offer(root);
		
		if (root == null) return root;
		while (!nodeQueue.isEmpty()) {
			
			currentNode = nodeQueue.poll();
			
			if (currentNode != null) {
				temp = currentNode.right;
				currentNode.right = currentNode.left;
				currentNode.left = temp;
				
				nodeQueue.offer(currentNode.left);
				nodeQueue.offer(currentNode.right);
			}
			
		}
		
		return root;
		
	}
	
	public void print_DFT(TreeNode root) {
		
		if (root != null) {
			System.out.print(root.val);
			print_DFT(root.left);
			print_DFT(root.right);
		}
		
	}
	
	public static void main(String[] args) {
			
			TreeNode root = new TreeNode(3);
			TreeNode a = new TreeNode(9);
			TreeNode b = new TreeNode(8);
			TreeNode c = new TreeNode(7);
			TreeNode d = new TreeNode(4);
			TreeNode e = new TreeNode(3);
			TreeNode f = new TreeNode(2);
			TreeNode g = new TreeNode(1);
			root.left = a;	root.right = b;
			a.left = null;	a.right = c;
			b.left = d; b.right = e;
			c.left = c.right = d.left = d.right = null;
			e.left = f; e.right = g;
			f.left = f.right = g.left = g.right = null;
			
			
			Invert_Binary_Tree test = new Invert_Binary_Tree();
			test.print_DFT(root);
			System.out.println("");
			test.print_DFT(test.invertTree(root));
			System.out.println("");
			test.print_DFT(test.invertTree_BFT(root)); 
			// should print out the original binary tree cause its
			// inverted twice.
	}

}
