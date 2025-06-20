
public class LinkedListLearning {

	Node head = null;
	int data;

	public void append(int data) {
		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
			return;
		}

		Node current = head;

		while (current.next != null) {
			current = current.next;
		}

		current.next = newNode;

	}

	public void prepend(int data) {
		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
			return;
		}

		newNode.next = head;
		head = newNode;
	}

	public void delete(int data) {

		if (head.data == data) {
			head = head.next;
			return;
		}

		Node current = head;

		while (current.next != null) {
			if (current.next.data == data) {
				current.next = current.next.next;
				return;
			}

			current = current.next;
		}
	}

	public void insertAfterANode(int prev, int data) {
		Node newNode = new Node(data);

		Node current = head;

		while (current != null) {
			if (current.data == prev) {
				newNode.next = current.next;
				current.next = newNode;
				return;
			}
			current = current.next;
		}

	}

	public void reverse() {
		if (head == null) {
			return;
		}

		Node current = head;
		Node prev = null;
		Node nextNode = null;

		while (current != null) {
			nextNode = current.next;
			current.next = prev;
			prev = current;
			current = nextNode;
		}
		head = prev;
	}

	public Node middle() {
		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	public String palindrome() {
		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		if (fast != null) {
			slow = slow.next;
		}

		Node newHead = reversePalindrome(slow);

		Node current = head;

		while (newHead != null) {

			if (current.data != newHead.data) {
				return "Not a paliondrome";
			}
			current = current.next;
			newHead = newHead.next;
		}

		return "Its a paliondrome";
	}

	public Node reversePalindrome(Node slow) {
		Node prev = null;
		Node nxtNode = null;

		while (slow != null) {
			nxtNode = slow.next;
			slow.next = prev;
			prev = slow;
			slow = nxtNode;

		}

		return prev;
	}

	public void removeDuplicates() {

		Node current = head;

		while (current != null && current.next != null) {
			if (current.data == current.next.data) {
				current.next = current.next.next;
			}
			current = current.next;
		}
	}

	public void removeLoop() {

		Node slow = head;
		Node fast = head;

		boolean islooped = false;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				islooped = true;
				break;
			}
		}
		if (islooped == false) {
			return;
		}
		slow = head;

		if (slow == fast) {
			while (fast.next != slow) {
				fast = fast.next;
			}

		} else {
			while (fast.next != slow.next) {
				fast = fast.next;
				slow = slow.next;
			}
		}

		fast.next = null;

	}

	// Find the start Node of the Loop

	public Node FindStart() {

		Node slow = head;
		Node fast = head;

		boolean islooped = false;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				islooped = true;
				break;
			}
		}

		slow = head;

		while (fast != slow) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow;
	}

	public void deleteNthNode(int n) {

		Node dummy = new Node(0);
		dummy.next = head;
		Node slow = dummy;
		Node fast = dummy;

		for (int i = 0; i <= n; i++) {
			if (fast == null) {
				return;
			}

			fast = fast.next;
		}

		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}

		slow.next = slow.next.next;
	}

	public void Intersection(Node a, Node b) {

		Node headA = a;
		Node headB = b;

		while (headA != headB) {

			headA = (headA == null) ? b : headA.next;
			headB = (headB == null) ? a : headB.next;
		}
	}

	public void swap() {
		Node current = head;
		Node evenStart = null;
		Node evenEnd = null;
		Node oddStart = null;
		Node oddEnd = null;

		while (current != null) {

			Node nxtNode = current.next;
			current.next = null;

			if (current.data % 2 == 0) {
				if (evenStart == null) {
					evenStart = current;
					evenEnd = evenStart;
				} else {
					evenEnd.next = current;
					evenEnd = evenEnd.next;
				}
			} else {
				if (oddStart == null) {
					oddStart = current;
					oddEnd = oddStart;
				} else {
					oddEnd.next = current;
					oddEnd = oddEnd.next;
				}
			}
			current = nxtNode;
		}

		if (evenStart == null || oddStart == null) {
			return;
		}

		evenEnd.next = oddStart;
		oddEnd.next = null;
		head = evenStart;
	}

	public void swaping() {
		Node dummy = new Node(0);
		dummy.next = head;

		Node current = dummy;

		while (current != null && current.next != null && current.next.next != null) {
			Node first = current.next;
			Node second = first.next;

			first.next = second.next;
			second.next = first;
			current.next = second;

			current = first;
		}
		head = dummy.next;
	}

	public void rotateK(int k) {

		Node current = head;
		Node check = head;
		Node slow = head;
		Node fast = head;

		while (current != null && current.next != null) {
			current = current.next;
		}

		current.next = head;

		for (int i = 1; i <= k; i++) {
			if (fast != null && fast.next != null) {
				fast = fast.next;
			}
		}

		while (fast.next != check) {
			fast = fast.next;
			slow = slow.next;
		}

		head = slow.next;
		slow.next = null;
	}

	public Node mergeSort(Node head) {

		Node current = head;

		Node mid = mid(current);
		Node nxtMid = mid.next;
		mid.next = null;

		Node left = mergeSort(current);
		Node right = mergeSort(nxtMid);

		return merge(left, right);

	}

	public Node merge(Node a, Node b) {

		if (a == null) {
			return a;
		}
		if (b == null) {
			return b;
		}
		Node k;

		if (a.data <= b.data) {
			k = a;
			k.next = merge(a.next, b);
		} else {
			k = b;
			k.next = merge(a, b.next);
		}

		return k;
	}

	public Node mid(Node a) {

		Node slow = a;
		Node fast = a;

		while (fast.next != null && fast.next.next != null) {

			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	public Node kThNode(Node current, int k) {

		for (int i = 1; i < k; i++) {
			if (current == null) {
				return null;
			}
			current = current.next;
		}
		return current;
	}

	public Node reverse(Node reverse) {
		Node prev = null;

		while (reverse != null) {
			Node nxtNode = reverse.next;
			reverse.next = prev;
			prev = reverse;
			reverse = nxtNode;
		}

		return prev;

	}

	public void reverseK(int k) {

		if (k <= 1 || head == null)
			return;

		Node current = head;

		Node prevNode = null;

		while (current != null) {

			Node kTh = kThNode(current, k);

			if (kTh == null) {
				if (prevNode != null) {
					prevNode.next = current;
				}
				break;
			} else {
				Node nxtNode = kTh.next;
				kTh.next = null;

				Node reverse = reverse(current);

				if (current == head) {
					head = reverse;
				} else {
					prevNode.next = reverse;
				}

				prevNode = current;
				current = nxtNode;

			}
		}
	}

	// Detect a loop in a Linked List

	public boolean detect() {

		if (head == null)
			return false;

		Node slow = head;

		Node fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				return true;
			}
		}

		return false;
	}

	public void removeLooop() {

		if (head == null)
			return;

		Node slow = head;
		Node fast = head;
		boolean islooped = false;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				islooped = true;
				break;
			}
		}
		if (islooped) {
			slow = head;

			if (slow == fast) {
				while (fast.next == slow) {
					fast = fast.next;
				}

				fast.next = null;
			} else {

				while (slow.next != fast.next) {
					slow = slow.next;
					fast = fast.next;
				}

				fast.next = null;
			}

		}

	}
}
