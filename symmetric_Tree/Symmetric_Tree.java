package symmetric_Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Symmetric_Tree {

	public static boolean isSymmetric(TreeNode root) {
		
		if (root == null) 
			return true;
		if (root.left == null || root.right == null) {
			if (root.left == null && root.right == null) 
				return true;
			else 
				return false;
		}
		if (root.left.val != root.right.val) 
			return false;
		
		TreeNode temp1 = new TreeNode(0);
		TreeNode temp2 = new TreeNode(0);
		temp1.left = root.left.left;
		temp1.right = root.right.right;
		temp2.left = root.left.right;
		temp2.right = root.right.left;
		return isSymmetric(temp1) && isSymmetric(temp2);
	}
	
	// DFT
	// This seems to be over-complicated. The one in leetcode "Editorial Solution" is much cleaner.
	public static boolean isSymmetric_itr_DFT(TreeNode root) {
		
		if (root == null) return true;
		TreeNode leftRunner = root.left;
		TreeNode rightRunner = root.right;
		Stack<TreeNode> leftStack = new Stack<>();
		Stack<TreeNode> rightStack = new Stack<>();
		
		while (!leftStack.empty() && !rightStack.empty() || leftRunner != null || rightRunner != null) {
			if (leftRunner == null && rightRunner != null || leftRunner != null && rightRunner == null) {
				return false;
			} else if (leftRunner == null) {
				leftRunner = leftStack.pop();
				rightRunner = rightStack.pop();
			} else if (leftRunner.val == rightRunner.val) {
				if (leftRunner.right != null && rightRunner.left == null || 
						leftRunner.right == null && rightRunner.left != null) {
					return false;
				} else if (leftRunner.right != null && rightRunner.left != null) {
					leftStack.push(leftRunner.right);
					rightStack.push(rightRunner.left);
				}
				leftRunner = leftRunner.left;
				rightRunner = rightRunner.right;
			} else {
				return false;
			}
			
		}
		return leftStack.size() - rightStack.size() == 0;
	}
	
	// BFT
	public static boolean isSymmetric_itr_BFT(TreeNode root) {
		Queue<TreeNode> nodeQueue = new LinkedList<>();
		nodeQueue.offer(root);
		nodeQueue.offer(root);
		TreeNode leftRunner;
		TreeNode rightRunner;
		
		while (!nodeQueue.isEmpty()) {
			leftRunner = nodeQueue.poll();
			rightRunner = nodeQueue.poll();
			if (leftRunner == null && rightRunner != null || leftRunner != null && rightRunner == null) {
				return false;
			} else if (leftRunner != null && rightRunner != null) {
				if (leftRunner.val != rightRunner.val) return false;
				nodeQueue.offer(leftRunner.left);
				nodeQueue.offer(rightRunner.right);
				nodeQueue.offer(leftRunner.right);
				nodeQueue.offer(rightRunner.left);
			}
			
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 2, 3, 4, 4, 3, 0, 5};
		Tree tree = new Tree(nums);
		tree.print_BFT();
		System.out.println(isSymmetric_itr_BFT(tree.root));
	}
}
