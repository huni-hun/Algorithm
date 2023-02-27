package algo230227;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1991_트리순회 {
	static Node head = new Node('A', null, null);
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			char root = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			insertNode(head, root, left, right);
		}
		
		preOrder(head);
		System.out.println();
		inOrder(head);
		System.out.println();
		postOrder(head);
	}
	
	static void insertNode(Node node, char root, char left, char right) {
		
		if(node.root == root) {
			if(left != '.') {
				node.left = new Node(left, null, null);
			}else {
				node.left = null;
			}
			
			if(right != '.') {
				node.right = new Node(right, null, null);
			}else {
				node.right = null;
			}
		}else {
			if(node.left != null) {
				insertNode(node.left, root, left, right);
			}
			if(node.right != null) {
				insertNode(node.right, root, left, right);
			}
		}
	}
	
	static void preOrder(Node node) {
		if(node == null) return;
		System.out.print(node.root);
		preOrder(node.left);
		preOrder(node.right);
	}

	static void inOrder(Node node) {
		if(node == null) return;
		inOrder(node.left);
		System.out.print(node.root);
		inOrder(node.right);
	}
	
	static void postOrder(Node node) {
		if(node == null) return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.root);
	}
	
	static class Node {
		char root;
		Node left;
		Node right;
		
		public Node(char root, Node left, Node right) {
			this.root = root;
			this.left = left;
			this.right = right;
		}
	}
}
