package AlgoExpert.Medium;

import java.util.*;




public class SuffixTrieConstruction {

	static class TrieNode {
		Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
	}

	static class SuffixTrie {
		TrieNode root = new TrieNode();
		char endSymbol = '*';

		public SuffixTrie(String str) {
			populateSuffixTrieFrom(str);
		}

		public void populateSuffixTrieFrom(String str) {
			for (int i = 0; i < str.length(); i++) {
				populateSuffixTrieFrom(i, str);
			}
		}

		private void populateSuffixTrieFrom(int index, String str) {
			TrieNode currentPointer = root;
			for (int j = index; j < str.length(); j++) {
				char ch = str.charAt(j);
				if (!currentPointer.children.containsKey(ch)) {
					TrieNode newTrieNode = new TrieNode();
					currentPointer.children.put(ch, newTrieNode);
				}
				currentPointer = currentPointer.children.get(ch);
			}
			currentPointer.children.put(endSymbol, null);
		}

		public boolean contains(String str) {
			TrieNode currentPointer = root;
			for (Character ch : str.toCharArray()) {
				if (!currentPointer.children.containsKey(ch)) {
					return false;
				}
				currentPointer = currentPointer.children.get(ch);
			}
			return currentPointer.children.containsKey(endSymbol);
		}
	}
}
