package symmetric_Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * My attempt to write a binary tree class... Until I found someone else has already
 * done it, which I copied to "Maximum Depth of Binary Tree" package long time ago.
 * 
 * @author Weibo Feng
 * @version May 12, 2016
 */
public class Tree {
	
	TreeNode root;
	
	public Tree() {
		root = null;
	}
	
	// 0 denotes a null node in nums.
	public Tree(int[] nums) {
		Queue<TreeNode> nodeQueue = new LinkedList<>();
		TreeNode temp;
		root = new TreeNode(nums[0]);
		nodeQueue.offer(root);
		int i = 1;
		while (!nodeQueue.isEmpty() && i < nums.length) {
			temp = nodeQueue.poll();
			if (temp != null) {
				if (nums[i] != 0) {
					temp.left = new TreeNode(nums[i]);
					nodeQueue.offer(temp.left);
				} else {
					temp.left = null;
				}
				if (nums[i + 1] != 0) {
					temp.right = new TreeNode(nums[i + 1]);
					nodeQueue.offer(temp.right);
				} else {
					temp.right = null;
				}
				i += 2;
			}
		}
	}

	// Not working out properly. Maybe the one in BinaryTree class works.
	public void printSelf() {
		Queue<TreeNode> nodeQueue = new LinkedList<>();
		nodeQueue.offer(root);
		TreeNode temp;
		int depth = 0;
		int currentBreadth = 1;
		int nextBreadth = 0;
		int tabs = 5;
		
		for (int i = depth; i < tabs; i++) {
			System.out.print("\t");
		}
		
		while (!nodeQueue.isEmpty()) {
			temp = nodeQueue.poll();
			currentBreadth --;
			
			if (temp != null) {
				nodeQueue.offer(temp.left);
				nodeQueue.offer(temp.right);
				nextBreadth += 2;
				System.out.print(temp.val + "\t    ");
			} else {
				System.out.print("\t");
			}
			if (currentBreadth == 0) {
				depth ++;
				System.out.println();
				for (int i = depth; i < tabs; i++) {
					System.out.print("\t");
				}
				System.out.print("    ");
				currentBreadth = nextBreadth;
				nextBreadth = 0;
			}
		}
	}
	
	// So I wrote a much simpler one, print the tree in one line, BFT
	// I simply copied the "maxDepth_iterative_BFT" from the
	// "Maximum Depth of Binary Tree" package
	public void print_BFT() {
		
		Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
		TreeNode currentNode = root;
		nodeQueue.offer(root);
		
		while (!nodeQueue.isEmpty()) {
			currentNode = nodeQueue.poll();
			if (currentNode != null) {
				System.out.print(currentNode.val);
				nodeQueue.offer(currentNode.left);
				nodeQueue.offer(currentNode.right);
			}
		}
		System.out.println();
	}
}
