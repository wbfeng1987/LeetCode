package reverse_Linked_List;

public class Reverse_Linked_List {
	
	public static ListNode reverseList(ListNode head) {
		
		if (head == null) return head;
		
		ListNode it = head;
		ListNode precursor = null;
		ListNode successor = head.next;
		while (successor != null) {
			it.next = precursor;
			precursor = it;
			it = successor;
			successor = successor.next;
		}
		it.next = precursor;
		return it;
    }
	
	public static void printList(ListNode head) {
		ListNode it = head;
		while (it != null) {
			System.out.println(it.val);
			it = it.next;
		}
	}
	
	public static void main(String[] args) {
		
		ListNode node1 = new ListNode(4);
		ListNode node2 = new ListNode(5);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(7);
		ListNode node5 = new ListNode(9);
		ListNode node6 = new ListNode(11);
		ListNode node7 = new ListNode(8);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = null;
		
	//	printList(node1);
		printList(reverseList(node1));
	}

}
