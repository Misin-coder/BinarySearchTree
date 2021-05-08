package binarySearchTree;

public class Tester {

	public static void main(String[] args) {
		Bst<Integer> tree = new Bst<>();
		tree.add(1);
		tree.add(3);
		tree.add(0);
		tree.remove(1);
		tree.inOrderTransversal();
		System.out.println();
		tree.postOrderTransversal();
		System.out.println();
		tree.preOrderTransversal();
//		System.out.println(tree.root.data);

	}

}
