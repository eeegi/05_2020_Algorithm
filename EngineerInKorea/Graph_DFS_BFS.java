package EngineerInKorea;

public class Graph_DFS_BFS {
	public static void main(String[] args) {
		Graph g = new Graph(9);
		g.initMarks();
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
		g.bfs(3);
	}
}
