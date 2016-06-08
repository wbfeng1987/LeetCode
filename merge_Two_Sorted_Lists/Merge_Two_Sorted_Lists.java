package merge_Two_Sorted_Lists;

public class Merge_Two_Sorted_Lists {
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		
		ListNode runner1 = l1;
		ListNode runner2 = l2;
		ListNode mergedRunner;
		if (runner1.val < runner2.val) {
			mergedRunner = runner1;
			runner1 = runner1.next;
		} else {
			mergedRunner = runner2;
			runner2 = runner2.next;
		}
		ListNode merged = mergedRunner;
		while (runner1 != null && runner2 != null) {
			if (runner1.val < runner2.val) {
				mergedRunner.next = runner1;
				runner1 = runner1.next;
			} else {
				mergedRunner.next = runner2;
				runner2 = runner2.next;
			}
			mergedRunner = mergedRunner.next;
		}
		
		if (runner1 == null) mergedRunner.next = runner2;
		if (runner2 == null) mergedRunner.next = runner1;
		
		return merged;
	}
	
	// recursive
	public static ListNode mergeTwoLists_rec(ListNode l1, ListNode l2) {
		
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		if (l1.val < l2.val) {
			l1.next = mergeTwoLists_rec(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists_rec(l1, l2.next);
			return l2;
		}
	}
	
	public static void printList(ListNode head) {
		ListNode it = head;
		while (it != null) {
			System.out.print(it.val + "\t");
			it = it.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(5);
		ListNode node4 = new ListNode(7);
		ListNode node5 = new ListNode(9);
		ListNode node6 = new ListNode(11);
		ListNode node7 = new ListNode(15);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = null;
		
		ListNode nodea = new ListNode(1);
		ListNode nodeb = new ListNode(2);
		ListNode nodec = new ListNode(4);
		ListNode noded = new ListNode(5);
		ListNode nodee = new ListNode(8);
		ListNode nodef = new ListNode(11);
		ListNode nodeg = new ListNode(16);
		
		nodea.next = nodeb;
		nodeb.next = nodec;
		nodec.next = noded;
		noded.next = nodee;
		nodee.next = nodef;
		nodef.next = nodeg;
		nodeg.next = null;
		
		printList(mergeTwoLists_rec(node1, nodea));
	}

}
