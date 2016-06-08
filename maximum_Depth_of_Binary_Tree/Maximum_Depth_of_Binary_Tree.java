package maximum_Depth_of_Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Maximum_Depth_of_Binary_Tree {

	// The recursive method, DFT
	public int maxDepth(TreeNode root) {
		
		if (root == null) {
			return 0;
		} else {
			return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
		}
        
    }
	
	// The iterative version of the above method using pre-order DFT
	public int maxDepth_iterative_DFT(TreeNode root) {
		
		int localMax = 0;
		TreeNode currentNode = root;
		Stack<TreeNode> nodeStack = new Stack<TreeNode>();
		Stack<Integer> depthStack = new Stack<Integer>();
		
/*		Weibo's intuitive DFT:
 *
 * 		1. 	start from root
 * 		2. 	currentNode = root
 * 		3.  While currentNode is not a leaf or the Stack is not empty {
 * 				push the right child of currentNode into Stack if there is one
 * 				if currentNode has a left child, go left
 * 				else if Stack is not empty
 * 						pop Stack and start from there
 * 				(if the node we are at right now is a leaf.
 * 				 record the depth to be compared.)
 * 			}
 * 
 * ===code below=====
 * 	
		if (root == null) {
			return 0;
		}
		
		int count = 1;
		
		while (currentNode.left != null || currentNode.right != null
				 || !nodeStack.empty()) {
			if (currentNode.right != null) {
				nodeStack.push(currentNode.right);
				depthStack.push(count + 1);
			}
			
			if (currentNode.left != null) {
				count++;
				currentNode = currentNode.left;
			} else {
				if (!nodeStack.empty()) {
					currentNode = nodeStack.pop();
					count = depthStack.pop();
				}
			}
			
			if (currentNode.left == null || currentNode.right == null) {
				localMax = Math.max(localMax, count);
			}
		}
*/		
		// more standard code:
		// https://en.wikipedia.org/wiki/Tree_traversal#Implementations
		int count = 0;
		while (currentNode != null || !nodeStack.empty()) {
			
			if (currentNode != null) {
				count++;
				if (currentNode.left == null && currentNode.right == null) {
					localMax = Math.max(localMax, count);
				}
				if (currentNode.right != null) {
					nodeStack.push(currentNode.right);
					depthStack.push(count);
				}
				currentNode = currentNode.left;
			} else {
				currentNode = nodeStack.pop();
				count = depthStack.pop();
			}
			
		}
		
		return localMax;
	
    }
	
	// The iterative BFT
	// There is no recursive version of BFT (Right?)
		/*	current node = root,
		 * 	offer current node in to the Queue;
		 * 	while the Queue is not empty:
		 * 		current node <--- poll the Queue;
		 * 		visit current node;
		 * 		if current node is not null
		 * 			offer it's left and right child into the Queue;
		*/
	
	public int maxDepth_iterative_BFT(TreeNode root) {
		
		int count = -1;
		Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
		TreeNode currentNode = root;
		nodeQueue.offer(root);
		
		while (!nodeQueue.isEmpty()) {
			int qSize = nodeQueue.size();
			while (qSize-- > 0) {
				currentNode = nodeQueue.poll();
				if (currentNode != null) {
					nodeQueue.offer(currentNode.left);
					nodeQueue.offer(currentNode.right);
				}
			}
			count ++;
		}
		
		return count;
		
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
		
		Maximum_Depth_of_Binary_Tree test = new Maximum_Depth_of_Binary_Tree();
		System.out.println(test.maxDepth(root));
		System.out.println(test.maxDepth_iterative_DFT(root));
		System.out.println(test.maxDepth_iterative_BFT(root));
		
	}
	
}
