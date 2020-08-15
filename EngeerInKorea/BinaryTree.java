package EngeerInKorea;

public class BinaryTree {
	class Node {
		int data;
		Node left;
		Node right;
		Node (int data) {
			this.data = data;
		}
	}
	
	Node root;
	public void makeTree(int[] a) {
		root = makeTreeR(a, 0, a.length - 1);
	}
	
	public Node makeTreeR(int[] a, int start, int end) {
		if (start > end) return null;
		int mid = (start + end) / 2;
		Node node = new Node(a[mid]);
		node.left = makeTreeR(a, start, mid -1);
		node.right = makeTreeR(a, mid + 1, end);
		return node;
	}
	
	public void searchBTree(Node n, int find) {
		if (find < n.data) {
			System.out.println("Data is smaller than : " + n.data);
			searchBTree(n.left, find);
		} else if (find > n.data) {
			System.out.println("Data is bigger than : " + n.data);
			searchBTree(n.right, find);
		} else {
			System.out.println("Data found");
		}
	}
	
	
	public static void main(String[] args) {
		/*
		 * 배열을 이진 검색 트리로 만들기
		 * 정렬이 되어 있고, 고유한 정수로만 이루어진 배열이 있다. 이 배열로 이진 검색트리를 구현 하시오. 
		 */
		int[] a = new int[10];
		for (int i = 0 ; i < a.length ; i++) {
			a[i] = i;
		}
		BinaryTree tree = new BinaryTree();
		tree.makeTree(a);
		tree.searchBTree(tree.root, 2);
	}
}
