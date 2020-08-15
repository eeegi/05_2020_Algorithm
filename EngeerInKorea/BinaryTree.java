package EngeerInKorea;

import java.util.ArrayList;
import java.util.LinkedList;

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
	
	public BinaryTree() {
		
	}
	
	public BinaryTree(int size) {
		root = makeBST(0, size -1);
	}
	
	Node makeBST (int start, int end) {
		if (start > end) return null;
		int mid = (start + end) / 2;
		Node node = new Node(mid);
		node.left = makeBST(start, mid -1);
		node.right = makeBST(mid +1, end);
		return node;
	}
	
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
	
	ArrayList<LinkedList<Node>> BSTtoList() {
		ArrayList<LinkedList<Node>> lists = new ArrayList<LinkedList<Node>>();
		BSTtoList(root, lists, 0);
		return lists;
	}
	
	void BSTtoList(Node root, ArrayList<LinkedList<Node>> lists, int level) {
		if (root == null) return;
		LinkedList<Node> list = null;
		if (lists.size() == level) { // ?
			list = new LinkedList<Node>();
			lists.add(list);
		} else {
			list = lists.get(level);
		}
		list.add(root);
		BSTtoList(root.left, lists, level + 1);
		BSTtoList(root.right, lists, level + 1);
	}
	
	ArrayList<LinkedList<Node>> BSTtoList2() {
		ArrayList<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();
		LinkedList<Node> current = new LinkedList<Node>();
		if (root != null) {
			current.add(root);
		}
		while (current.size() > 0) {
			result.add(current);
			LinkedList<Node> parents = current;
			current = new LinkedList<Node>();
			for (Node parent : parents) {
				if (parent.left != null) current.add(parent.left);
				if (parent.right != null) current.add(parent.right);
			}
		}
		return result;
	}
	
	void printList(ArrayList<LinkedList<Node>> arr) {
		for (LinkedList<Node> list : arr)  {
			for (Node node : list) {
				System.out.print(node.data + " ");
			}
			System.out.println();
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
