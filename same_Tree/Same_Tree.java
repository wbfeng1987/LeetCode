package same_Tree;

public class Same_Tree {
	
	public static boolean isSameTree(TreeNode p, TreeNode q) {
		
		if (p != null && q != null) {
			if (p.val == q.val && isSameTree(p.left, q.left) && 
	        		isSameTree(p.right, q.right)){
				return true;
			}
			else {
				return false;
			}
		} else if (p == null && q == null) {
			return true;
		} else {
			return false;
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
		
		TreeNode root4 = new TreeNode(3);
		TreeNode a2 = new TreeNode(9);
		TreeNode b2 = new TreeNode(8);
		TreeNode c2 = new TreeNode(7);
		TreeNode d2 = new TreeNode(4);
		TreeNode e2 = new TreeNode(3);
		TreeNode f2 = new TreeNode(2);
		TreeNode g2 = new TreeNode(1);
		root4.left = a2;	root4.right = b2;
		a2.left = null;	a2.right = c2;
		b2.left = d2; b2.right = e2;
		c2.left = c2.right = d2.left = d2.right = null;
		e2.left = f2; e2.right = g2;
		f2.left = f2.right = g2.left = g2.right = null;

		System.out.println(isSameTree(root,root4));
	}

}
