class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    
    void insert(int key) {
        root = insertRec(root, key);
    }

    
    Node insertRec(Node root, int key) {
		
        
		
        return root;
    }

    
    boolean search(int key) {
        return searchRec(root, key);
    }

    
    boolean searchRec(Node root, int key) {
        
        if (root == null || root.key == key)
            return root != null;

        
        if (key > root.key)
            return searchRec(root.right, key);

        
        return searchRec(root.left, key);
    }

    
    void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    
    Node deleteRec(Node root, int key) {
        
		
				
        return root;
    }

    
    int minValue(Node node) {
        
		/
		
        return node.key; 
		
    }

    
    void inorder() {
        inorderRec(root);
    }

    
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }
}


public class BST_Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

       
        bst.insert(5);
        bst.insert(12);
        bst.insert(21);
        bst.insert(2);
        bst.insert(19);
        bst.insert(1);
        bst.insert(25);
		bst.insert(9);
        bst.insert(3);

        
        System.out.println("Inorder traversal of the BST:");
        bst.inorder();
        System.out.println();

        
        int searchKey = 21;
        if (bst.search(searchKey))
            System.out.println("Key " + searchKey + " found in the BST.");
        else
            System.out.println("Key " + searchKey + " not found in the BST.");

        
        bst.deleteKey(9);
        System.out.println("Inorder traversal after deleting 9:");
        bst.inorder();
        System.out.println();
		
		bst.deleteKey(12);
        System.out.println("Inorder traversal after deleting 12:");
        bst.inorder();
        System.out.println();
    }
}