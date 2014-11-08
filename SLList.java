package SLList;

public class SLList {
	
	private Node head;
	
	public void add(int x) {
		Node p = new Node(x);
		if (this.head==null) {
			this.head = p;
		}
		else {
			this.head.addNode(p);
		}
	}
	public boolean src(int x) {
		if (head!=null) {
			return this.head.searchNode(x);
		}
		else {
			return false;
		}
	}
	public void del(int x) {
		if (this.src(x)) {
			this.head.deleteNode(head, x);
		}
	}
	public void show() {
		if (this.head!=null) {
			this.head.showNode();
		}
	}
	
	// Inner class
	class Node {
		private int data;
		private Node next;
		public Node(int x) {
			this.data = x;
			this.next = null;
		}
		public int getData() {
			return this.data;
		}
		public void setNext(Node x) {
			this.next = x;
		}
		public void addNode(Node x) {
			Node p = this;
			while (p.next!=null) {
				p = p.next;
			}
			p.next = x;
		}
		public void showNode() {
			Node p = this;
			while (p!=null) {
				System.out.println(p.data);
				p = p.next;
			}
		}
		public boolean searchNode(int x) {
			Node p = this;
			if(p.data==x) {
				return true;
			}
			else {
				if (p.next!=null) {
					return p.next.searchNode(x);
				}
				else {
					return false;
				}
			}
		}
		public void deleteNode(Node f, int x) {
			Node p = this;
			if(p.data==x) {
				if(p.next!=null) {
					f.next = p.next;
				}
				else {
					f = null;
				}
			}
			else {
				if(p.next!=null) {
					p.next.deleteNode(p, x);
				}
			}
		}
	}
}
