package swap_Nodes_in_Pairs;

public class Swap_Nodes_in_Pairs {
	
	public static ListNode swapPairs(ListNode head) {
		
		if (head == null || head.next == null) return head;
		
		ListNode runner = head.next.next;
		ListNode pre = head.next;
		head.next = runner;
		pre.next = head;
		ListNode newHead = pre;
		pre = head;
		
		while (runner != null && runner.next != null) {
			pre.next = runner.next;
			runner.next = runner.next.next;
			pre.next.next = runner;
			pre = runner;
			runner = runner.next;
		}
		return newHead;
	}
	
	// recursive
	public static ListNode swapPairs_rec(ListNode head) {
		
		if (head == null || head.next == null) return head;
		
		ListNode newHead = head.next;
		head.next = swapPairs_rec(head.next.next);
		newHead.next = head;
		
		return newHead;
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
		
		printList(node1);
		printList(swapPairs_rec(node1));
		
	}

}
