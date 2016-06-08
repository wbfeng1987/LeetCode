package linked_List_Cycle;

public class Linked_List_Cycle {
	
	// It fails to pass the leetcode test.
	public static boolean hasCycle(ListNode head) {
		
		if (head == null) return false;
		
		ListNode runner;
		ListNode anchor = head;
		int steps;
		int presteps = 0;
		while (anchor.next != null) {
			steps = 0;
			runner = head;
			while (runner != anchor) {
				runner = runner.next;
				steps ++;
			}
			if (steps < presteps) return true;
			presteps = steps;
			if (anchor == anchor.next) {
				return true;
			} else {
				anchor = anchor.next;
			}
		}
        return false;
    }
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		ListNode node8 = new ListNode(8);
		ListNode node9 = new ListNode(9);
		
		node1.next = node2;	node2.next = node3;
		node3.next = node4;	node4.next = node5;
		node5.next = node6;	node6.next = node7;
		node7.next = node8;	node8.next = node9;
		node9.next = node2;
		
		System.out.println(hasCycle(node1));
	}

}
