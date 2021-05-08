package binarySearchTree;

public class Bst<E> {

	// blueprint for our node
	class Node<E> {
		E data;
		Node<E> left;
		Node<E> right;
		
		public Node(E data) {
			this.data = data;
			left = right = null;
		}
	}
	
	private Node<E> root;
	int currentSize;
	
	public Bst() {
		root = null;
		currentSize = 0;
	}
	
	public void add(E data) {
		// if it is first element 
		if(root == null) {
			root = new Node<E>(data);
			return;
		}
		// if not first element
		add(root, data);
		currentSize++;
	}

	private void add(Node<E> node, E data) {
		if(((Comparable<E>)data).compareTo(node.data) < 0) {
			// go to left
			if(node.left == null) {
				node.left = new Node<E>(data);
				return;
			}
			add(node.left, data);
		}
		else {
			// go to right
			if(node.right == null) {
				node.right = new Node<E>(data);
				return;
			}
			add(node.right, data);
		}
	}
	
	public boolean contains(E data) {
		return contains(root, data);
	}

	private boolean contains(Node<E> node, E data) {
		if(node == null) {
			return false;
		}
		if(((Comparable<E>)data).compareTo(node.data) == 0) {
			return true;
		}
		if(((Comparable<E>)data).compareTo(node.data) < 0) {
			return contains(node.left, data);
		}
		if(((Comparable<E>)data).compareTo(node.data) > 0) {
			return contains(node.right, data);
		}
		return false;
	}
	
	public Node<E> remove(E data) {
		return remove(root, data);
	}

	private Node<E> remove(Node<E> node, E data) {
		if(node == null) {
			return null;
		}
		
		if(((Comparable<E>)data).compareTo(node.data) < 0) {
			node.left = remove(node.left, data);
		}
		else if(((Comparable<E>)data).compareTo(node.data) > 0) {
			node.right = remove(node.right, data);
		}
		else {
			// we found the node to be deleted
			// case: 1 -> no child
			if(node.left == null && node.right == null) {
				return null;
			}
			// case: 2 -> one child
			else if(node.left == null) {
				return node.right;
			}
			else if(node.right == null) {
				return node.left;
			}
			else {
				E value = minOfRightSubtree(node.right, data);
				node.data = value;
				node.right = remove(node.right, value);
				return node;
			}
		}
		return node;
	}

	private E minOfRightSubtree(Node<E> node, E data) {
		if(node.left == null) {
			return node.data;	
		}
	    return minOfRightSubtree(node.left, data);
	}
	
	public void preOrderTransversal() {
		preOrder(root);
	}
	
	private void preOrder(Node<E> node) {
		if(node == null) {
			return;
		}
		System.out.print(node.data + "	");
		preOrder(node.left);
		preOrder(node.right);
		
	}

	public void inOrderTransversal() {
		inOrder(root);
	}
	
    private void inOrder(Node<E> node) {
    	if(node == null) {
			return;
		}
		inOrder(node.left);
		System.out.print(node.data + "	");
		inOrder(node.right);
		
	}

	public void postOrderTransversal() {
		postOrder(root);
	}

	private void postOrder(Node<E> node) {
		if(node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data + "	");
	}
	
	
	
}
