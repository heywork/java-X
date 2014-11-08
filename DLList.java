
package DLList;

public class DLList {
	
	private int s = 0;
	private DLNode head;
	private int len = 0;

	public DLList() {
	}
	public DLList(int x) {
		len = x;
	}
	public void init() {
		if (len!=0) {
			for (int i=0; i<len; i++) {
				addA(0);
			}
		}
	}
	public void addA(int x) {
		DLNode p = new DLNode(x);
		if (s<len) {
			if (head==null) {
				head = p;
				head.setInit();
			}
			else {
				p.setNext(head.getNext());
				p.setPrev(head);
				head.getNext().setPrev(p);
				head.setNext(p);
				head = p;
			}
			s++;
		}
		else {
			if (head==null) {
				head = p;
			}
			else {
				if (head.getNext().getInit()) {
					p.setInit();
				}
				p.setNext(head.getNext().getNext());
				p.setPrev(head);
				head.getNext().getNext().setPrev(p);
				head.setNext(p);
				head = p;
			}
		}
	}
	public void addB(int x) {
		DLNode p = new DLNode(x);
		if (s<len) {
			if (head==null) {
				head = p;
				head.setInit();
			}
			else {
				p.setNext(head);
				p.setPrev(head.getPrev());
				head.getPrev().setNext(p);
				head.setPrev(p);
				head = p;
			}
			s++;
		}
		else {
			if (head==null) {
				head = p;
			}
			else {
				if (head.getPrev().getInit()) {
					p.setInit();
				}
				p.setNext(head);
				p.setPrev(head.getPrev().getPrev());
				head.getPrev().getPrev().setNext(p);
				head.setPrev(p);
				head = p;
			}
		}
	}
	public int size() {
		return s;
	}
	public int srch(int x) {
		return head.search(x, s);
	}
	public void show() {
		if (head!=null) {
			head.showNode(s);
		}
	}

	//Inner class
	class DLNode {
		private int data;
		private DLNode prev;
		private DLNode next;
		private boolean init;
		public DLNode(int x) {
			data = x;
			prev = this;
			next = this;
			init = false;
		}
		public boolean getInit() {
			return init;
		}
		public void setInit() {
			init = true;
		}
		public int getData() {
			return data;
		}
		public void setData(int x) {
			data = x;
		}
		public DLNode getPrev() {
			return prev;
		}
		public DLNode getNext() {
			return next;
		}
		public void setPrev(DLNode x) {
			prev = x;
		}
		public void setNext(DLNode x) {
			next = x;
		}
		public void showNode(int x) {
			DLNode p = this;
			while (p.init==false) {
				p = p.next;
			}
			for (int i=0; i<x; i++) {
				System.out.println(p.data);
				p = p.next;
			}
		}
		public int search(int x, int s) {
			DLNode p = this;
			while (p.init==false) {
				p = p.next;
			}
			int i = 0;
			while (p.data!=x && i<s) {
				p = p.next;
				i++;
			}
			if (i==s) {
				return -1;
			}
			else {
				return i+1;
			}
		}
	}
}


