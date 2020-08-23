package EngineerInKorea;

/*
 * 이진트리의 노드들을 각 레벨 별로 LinkedList에 담는 알고리즘을 구현하시오.
 * 예를 들어, 5개의 깊이를 가지는 트리라면 5개의  LinkedList를 만들어야함
 * time : O(N), space O(N)
 */
public class Tree_BinaryTreeByLevelUnit {

	public static void main(String[] args) {
		BinaryTree t = new BinaryTree(10);
		t.printList(t.BSTtoList());
		t.printList(t.BSTtoList2());
	}
}
