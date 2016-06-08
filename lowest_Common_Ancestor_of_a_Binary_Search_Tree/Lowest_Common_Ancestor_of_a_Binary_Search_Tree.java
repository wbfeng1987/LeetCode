package lowest_Common_Ancestor_of_a_Binary_Search_Tree;

import java.util.*;

public class Lowest_Common_Ancestor_of_a_Binary_Search_Tree {
	
	// Still under construction...
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		
		boolean pVisited = false;
		boolean qVisited = false;
		TreeNode LCA = null;
		Deque<TreeNode> pFatherQueue = new LinkedList<>();
		Deque<TreeNode> qFatherQueue = new LinkedList<>();
		
		Stack<TreeNode> nodeStack = new Stack<>();
		TreeNode currentNode = root;
		while (currentNode != null || !nodeStack.empty()) {
			
			if (currentNode == null) {
				currentNode = nodeStack.pop();
			}
			
			if (currentNode == p) {
				System.out.println("p found");
				pVisited = true;
				pFatherQueue.offer(currentNode);
			}
			if (currentNode == q) {
				System.out.println("q found");
				qVisited = true;
				qFatherQueue.offer(currentNode);
			}
			System.out.println("Node visited: " + currentNode.val);
			if (currentNode.right != null) {
				nodeStack.push(currentNode.right);
				if (currentNode.left != null && !pVisited) {
					pFatherQueue.offer(currentNode);
				}
				if (currentNode.left != null && !qVisited) {
					qFatherQueue.offer(currentNode);
				}
				
			}
			currentNode = currentNode.left;
		}
		
		System.out.println();
		
		while (!pFatherQueue.isEmpty()) {
			System.out.println("Dumping pFatherQueue: " + pFatherQueue.poll().val);
		}
		
		while (!qFatherQueue.isEmpty()) {
			System.out.println("Dumping qFatherQueue: " + qFatherQueue.poll().val);
		}
		
		while (!pFatherQueue.isEmpty() && !qFatherQueue.isEmpty() 
				&& (LCA = pFatherQueue.poll()) == qFatherQueue.poll()) {}
		
        return LCA;
    }
	
	// Store the path of p & q relative to root into a hashmap, Then compare the path.
	// This one works.
	public static TreeNode lowestCommonAncestor_map(TreeNode root, TreeNode p, TreeNode q) {
		
		TreeNode lowestCommonAncestor = null;
		
		Map<TreeNode, TreeNode> childParentMap = new HashMap<>();
		childParentMap.put(root, null);
		
		Stack<TreeNode> nodeQueue = new Stack<>();
		TreeNode currentNode = root;
		while (currentNode != null || !nodeQueue.empty()) {
			if (currentNode == null) {
				currentNode = nodeQueue.pop();
			}
			if (currentNode.right != null) {
				nodeQueue.push(currentNode.right);
				childParentMap.put(currentNode.right, currentNode);
			}
			if (currentNode.left != null) {
				childParentMap.put(currentNode.left, currentNode);
			}
			currentNode = currentNode.left;
		}
		
		Stack<TreeNode> pPathStack = new Stack<>();
		Stack<TreeNode> qPathStack = new Stack<>();
		TreeNode temp = p;
		while (temp != null) {
			pPathStack.push(temp);
			temp = childParentMap.get(temp);
		}
		temp = q;
		while (temp != null) {
			qPathStack.push(temp);
			temp = childParentMap.get(temp);
		}
		
		while ((temp = pPathStack.pop()) == qPathStack.pop()) {
			lowestCommonAncestor = temp;
		}
		return lowestCommonAncestor;
	}
	
	// The recursive version. This one works!
	public static TreeNode lowestCommonAncestor_rec(TreeNode root, TreeNode p, TreeNode q) {
		
		if (root == null)	return null;
		if (root == p || root == q)	return root;
		
		if (lowestCommonAncestor_rec(root.left, p, p) != null) {
			if (lowestCommonAncestor_rec(root.right, q, q) != null) {
				return root;
			} else {
				return lowestCommonAncestor_rec(root.left, p, q);
			}
		} else if (lowestCommonAncestor_rec(root.left, q, q) != null) {
			return root;
		} else {
			return lowestCommonAncestor_rec(root.right, p, q);
		}
    }
	
	
	// Well it looks like it is a Binary Search Tree. Then it is much simpler.
	// The recursive version.
	public static TreeNode lowestCommonAncestor_BST_rec(TreeNode root, TreeNode p, TreeNode q) {
		
		int min = Math.min(p.val, q.val);
		int max = Math.max(p.val, q.val);
		
		if (root.val < min) {
			return lowestCommonAncestor_BST_rec(root.right, p, q);
		} else if (root.val > max) {
			return lowestCommonAncestor_BST_rec(root.left, p, q);
		} else {
			return root;
		}
	}
	
	// Well it looks like it is a Binary Search Tree. Then it is much simpler.
	// The iterative version.
	public static TreeNode lowestCommonAncestor_BST_itr(TreeNode root, TreeNode p, TreeNode q) {
		
		int min = Math.min(p.val, q.val);
		int max = Math.max(p.val, q.val);
		TreeNode commonAncestor = root;
		
		// (from leetcode discussion) one can instead use 
		// (commonAncestor.val - p.va) * (commonAncestor.val - q.val)
		// as the condition without defining the min and max of them
		while (commonAncestor.val < min || commonAncestor.val > max) {
			if (commonAncestor.val < min) {
				commonAncestor = commonAncestor.right;
			} else {
				commonAncestor = commonAncestor.left;
			}
		}
		return commonAncestor;
	}
	
	// A simple recursive method to check is one tree contains a certain node.
	public static boolean contains(TreeNode root, TreeNode node) {
		if (root == null)	return false;
		if (root == node)	return true;
		
		return contains(root.left, node) || contains(root.right, node);
	}
	
	// Pre-order recursive method to print out a tree.
	public static void print_DFT_rec(TreeNode root) {
		
		if (root != null) {
			System.out.print(root.val);
			print_DFT_rec(root.left);
			print_DFT_rec(root.right);
		}
		
	}
	
	// Pre-order iterative method to print out a tree.
	public static void print_DFT_itr(TreeNode root) {
		
		Stack<TreeNode> nodeQueue = new Stack<>();
		TreeNode currentNode = root;
		while (currentNode != null || !nodeQueue.empty()) {
			if (currentNode == null) {
				currentNode = nodeQueue.pop();
			}
			System.out.print(currentNode.val);
			if (currentNode.right != null) {
				nodeQueue.push(currentNode.right);
			}
			currentNode = currentNode.left;
		}
		
	}

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(6);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(8);
		TreeNode node4 = new TreeNode(0);
		TreeNode node5 = new TreeNode(4);
		TreeNode node6 = new TreeNode(7);
		TreeNode node7 = new TreeNode(9);
		TreeNode node8 = new TreeNode(3);
		TreeNode node9 = new TreeNode(5);
		
		node1.left = node2;	node1.right = node3;
		node2.left = node4;	node2.right = node5;
		node3.left = node6;	node3.right = node7;
		node4.left = null;	node4.right = null;
		node5.left = node8;	node5.right = node9;
		node6.left = null;	node6.right = null;
		node7.left = null;	node7.right = null;
		node8.left = null;	node8.right = null;
		node9.left = null;	node9.right = null;
		
		System.out.println(lowestCommonAncestor_rec(node1, node8, node9).val);
		System.out.println(lowestCommonAncestor_map(node1, node8, node9).val);
		System.out.println(lowestCommonAncestor_BST_rec(node1, node8, node9).val);
		System.out.println(lowestCommonAncestor_BST_itr(node1, node8, node9).val);
		
/*		TreeNode nodeTest = new TreeNode(11);
		System.out.println(contains(node1, nodeTest));
		System.out.println(contains(node1, node5));*/
	}

}
