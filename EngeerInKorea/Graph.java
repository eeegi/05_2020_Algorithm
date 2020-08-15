package EngeerInKorea;

import java.util.LinkedList;

import EngeerInKorea.Graph.Node;

public class Graph {
	
	class Node {
		int data;
		boolean marked;
		LinkedList<Node> adjacent;
		Node (int data) {
			this.data = data;
			this.marked = false;
			this.adjacent = new LinkedList<Node>();
		}
	}
	Node[]  nodes;
	public Graph (int size) {
		nodes = new Node[size];
		for (int i = 0 ; i < size ; i++) {
			nodes[i] = new Node(i);
		}
	}
	void addEdge (int i1, int i2) {
		Node n1 = nodes[i1];
		Node n2 = nodes[i2];
		if(!n1.adjacent.contains(n2)) {
			n1.adjacent.add(n2);
		}
		if (!n2.adjacent.contains(n1)) {
			n2.adjacent.add(n1);
		}
	}
	
	boolean search(int i1, int i2) {
		return search(nodes[i1], nodes[i2]);
	}
	/*
	 * search는 BFS 방식으로 찾는다.
	 */
	boolean search(Node start, Node end) {
		initMarks();
		LinkedList<Node> q = new LinkedList<Node>();
		q.add(start);
		while (!q.isEmpty()) {
			Node root = q.removeFirst();
			if (root == end) {
				return true;
			}
			for (Node n : root.adjacent) {
				if (n.marked == false) {
					n.marked = true;
					q.add(n);
				}
			}
		}
		return false;
	}
	
	void initMarks() {
		for (Node n : nodes) {
			n.marked = false;
		}
	}
	
	void dfs() {
		dfs(0);
	}
	void dfs(int index) {
		Node root = nodes[index];
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		root.marked = true;
		while (!stack.isEmpty()) {
			Node r = stack.pop();
			for (Node n : r.adjacent) {
				if (n.marked == false) {
					n.marked = true;
					stack.push(n);;
				}
			}
			visit(r);
		}
	}
	
	void bfs() {
		bfs(0);
	}
	void bfs(int index) {
		Node root = nodes[index];
		Queue<Node> queue = new Queue<Node>();
		queue.add(root);
		root.marked = true;
		while (!queue.isEmpty()) {
			Node r = queue.dequeue();
			for (Node n : r.adjacent) {
				if (n.marked == false) {
					n.marked = true;
					queue.enqueue(n);
				}
			}
			visit(r);
		}
	}
	
	// 재귀 호출로 구현
	void dfsR(Node r) {
		if (r == null) return;
		r.marked = true;
		visit(r);
		for (Node n : r.adjacent) {
			if (n.marked == false) {
				dfsR(n);
			}
		}
	}
	
	void dfsR(int index) {
		Node r = nodes[index];
		dfsR(r);
	}
	void dfsR() {
		dfsR(0);
	}
	void visit(Node n) {
		System.out.print(n.data + " ");
	}
}
