package balanced_Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Balanced_Binary_Tree {
	
	// BFT, iterative
	// This is the wrong answer. I thought Balanced Binary Tree is defined as:
	// "the depth of every leaf never differ by 1"
	public static boolean isBalanced(TreeNode root) {
		
		if (root == null) return true;
		
		int depth = 0;
		int minLeafDepth = 0;
		int maxLeafDepth = 0;
		TreeNode runner;
		Queue<TreeNode> nodeQueue = new LinkedList<>();
		nodeQueue.offer(root);
		int currentBreadth = 1;
		int nextBreadth = 0;
		
		while (!nodeQueue.isEmpty()) {
			runner = nodeQueue.poll();
			System.out.print(runner.val + "\t");
			currentBreadth --;
			
			if (runner.left != null) {
				nodeQueue.offer(runner.left);
				nextBreadth ++;
			}
			if (runner.right != null) {
				nodeQueue.offer(runner.right);
				nextBreadth ++;
			}
			if (runner.left == null && runner.right == null) {
				if (minLeafDepth == 0) minLeafDepth = depth;
				if (maxLeafDepth < depth) {
					maxLeafDepth = depth;
				}
			}
			if (currentBreadth == 0) {
				depth ++;
				currentBreadth = nextBreadth;
				nextBreadth = 0;
			}
		}
		System.out.println();
		System.out.println("minLeafDepth = " + minLeafDepth);
		System.out.println("maxLeafDepth = " + maxLeafDepth);
		return maxLeafDepth - minLeafDepth < 2;
	}
	
	
	// This one should work. But it doesn't pass the leetcode test cases.
	public static boolean isBalanced_right(TreeNode root) {
		if (root == null) return true;
		
		int maxNode = 1;
		int nodeCount = 0;
		TreeNode runner;
		Queue<TreeNode> nodeQueue = new LinkedList<>();
		nodeQueue.offer(root);
		int currentBreadth = 1;
		int nextBreadth = 0;
		
		while (!nodeQueue.isEmpty()) {
			runner = nodeQueue.poll();
			nodeCount ++;
			currentBreadth --;
			
			if (runner.left != null) {
				nodeQueue.offer(runner.left);
				nextBreadth ++;
			}
			if (runner.right != null) {
				nodeQueue.offer(runner.right);
				nextBreadth ++;
			}
			if (currentBreadth == 0) {
				maxNode *= 2;
				currentBreadth = nextBreadth;
				nextBreadth = 0;
				if (nodeCount < maxNode - 1 && !nodeQueue.isEmpty()) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(3);
		TreeNode e = new TreeNode(3);
		TreeNode f = new TreeNode(3);
		TreeNode g = new TreeNode(4);
		TreeNode h = new TreeNode(4);
		TreeNode i = new TreeNode(4);
		TreeNode j = new TreeNode(4);
		TreeNode k = new TreeNode(4);
		TreeNode l = new TreeNode(4);
		TreeNode m = new TreeNode(5);
		TreeNode n = new TreeNode(5);
		TreeNode test = new TreeNode(100);
		
		root.left = a;	root.right = b;
		a.left = c;	a.right = d; b.left = e; b.right = f;
		c.left = g; c.right = h; d.left = i.right = j;
		e.left = k; e.right = l; f.left = null; f.right = null;
		g.left = m; g.right = n;
		test.left = test.right = null;
		
		System.out.println(isBalanced_right(root));
	}
}
