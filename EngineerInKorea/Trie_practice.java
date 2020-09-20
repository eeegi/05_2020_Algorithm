package EngineerInKorea;

public class Trie_practice {
	private static int NUMBER_OF_CHARACTERS = 26;
	static class Node {
		Node[] children = new Node[NUMBER_OF_CHARACTERS]; // number of the alphabet
		int size = 0;
		
		private int getCharIndex(char c) {
			return c - 'a'; // 'a' value of 97, b = 98
		}
		
		private void setNode(char c, Node node) {
			children[getCharIndex(c)] = node;
		}
		public void add(String s) {
			add(s, 0);
		}
		private void add(String s, int index) {
			size++;
			if (index == s.length()) return;
			char current = s.charAt(index);
			Node child = children[getCharIndex(current)];
			if (child == null) {
				setNode(current, child);
			}
			child.add(s, index + 1);
		}
		
		public int findCount(String s, int index) {
			if (index == s.length()) {
				return size;
			}
			Node child = children[getCharIndex(s.charAt(index))];
			if (child == null) {
				return 0;
			}
			return child.findCount(s, index + 1);
		}
	}
}
