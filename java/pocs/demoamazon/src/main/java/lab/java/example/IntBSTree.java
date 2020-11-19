package lab.java.example;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IntBSTree {

	class Node {
		int key;
		Node left;
		Node right;
		Node parent;

		Node(int key) {
			this.key = key;
		}
	}

	Node root;

	void insert(int key) {
		Node y = null;
		Node x = root;
		Node z = new Node(key);
		while (x != null) {
			y = x;
			if (z.key < x.key) {
				x = x.left;
			} else {
				x = x.right;
			}
		}
		z.parent = y;
		if (y == null) {
			root = z;
		} else if (z.key < y.key) {
			y.left = z;
		} else {
			y.right = z;
		}
	}

	Node search(int key) {
		return search(root, key);
	}

	Node search(Node x, int key) {
		if (x == null || key == x.key)
			return x;
		if (key < x.key) {
			return search(x.left, key);
		} else {
			return search(x.right, key);
		}
	}

	Node iterativeSearch(Node x, int key) {
		while (x != null && key != x.key) {
			if (key < x.key) {
				x = x.left;
			} else {
				x = x.right;
			}
		}
		return x;
	}

	Node minimum(Node x) {
		while (x.left != null) {
			x = x.left;
		}
		return x;
	}

	Node maximum(Node x) {
		while (x.right != null) {
			x = x.right;
		}
		return x;
	}

	void transplant(Node u, Node v) {
		if (u.parent == null) {
			root = v;
		} else if (u == u.parent.left) {
			u.parent.left = v;
		} else {
			u.parent.right = v;
		}
		if (v != null) {
			v.parent = u.parent;
		}
	}

	int[] lavelOrder() {
		Queue<Integer> keys = new LinkedList<Integer>();
		Queue<Node> nodes = new LinkedList<Node>();
		nodes.add(root);
		while (!nodes.isEmpty()) {
			Node x = nodes.poll();
			if (x == null)
				continue;
			keys.add(x.key);
			nodes.add(x.left);
			nodes.add(x.right);
		}
		return keys.stream().mapToInt(i -> i).toArray();
	}

}
