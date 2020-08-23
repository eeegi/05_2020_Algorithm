package EngineerInKorea;

import java.util.LinkedList;

/*
 * Graph에서 두개의 노드가 서로 찾아 갈 수 있는 경로가 있는지
 * 확인하는 함수를 구현하시오.
 * => BFS로 구현해야함.
 */

public class Graph_FindThePathBetweenTwoNode {
	static public void main(String[] args) {
		Graph g = new Graph(9);
		g.addEdge(0, 1);;
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(3, 5);
		g.addEdge(5, 6);
		g.addEdge(5, 7);
		g.addEdge(6, 8);
		System.out.println(g.search(1, 8));
	}
}
