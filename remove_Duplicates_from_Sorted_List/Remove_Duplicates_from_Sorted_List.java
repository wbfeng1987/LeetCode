package remove_Duplicates_from_Sorted_List;

public class Remove_Duplicates_from_Sorted_List {
	
	public static ListNode deleteDuplicates(ListNode head) {
		
		if (head == null) return head;
		
		ListNode runner = head;
		ListNode anchor = head;
		while (runner != null) {
			if (runner.val == anchor.val) {
				anchor.next = runner.next;
			} else {
				anchor = runner;
			}
			runner = runner.next;
		}
		return head;
	}
	
	// Recursive
	public static ListNode deleteDuplicates_rec(ListNode head) {
		if (head == null || head.next == null) return head;
		
		if (head.val == deleteDuplicates_rec(head.next).val) {
			head.next = head.next.next;
		}
		return head;
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
		
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(3);
		ListNode node5 = new ListNode(3);
		ListNode node6 = new ListNode(8);
		ListNode node7 = new ListNode(9);
		ListNode node8 = new ListNode(9);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		node8.next = null;
		
		printList(node1);
		printList(deleteDuplicates_rec(node1));
	}
}
