public class Tree {
    Object[] array;

    
    public Tree() {
        array = new Object[128];
    }

    
    public Tree(Object rootValue) {
        this();
        setRoot(rootValue);
    }

    
    public void setRoot(Object rootValue) {
        setCargo(1, rootValue);
    }

    
    public boolean empty() {
        return array[1] == null;
    }

    
    private int left(int i) {
        return 2 * i;
    }

    
    private int right(int i) {
        return 2 * i + 1;
    }

    private int parent(int i) {
        return i / 2;
    }

    
    private Object getCargo(int i) {
        if (i < 0 || i >= array.length) return null;
        return array[i];
    }

    
    private void setCargo(int i, Object obj) {
        if (i < 0 || i >= array.length) return;
        array[i] = obj;
    }

    
    private int searchPreorder(int index, Object value) {
        if (index >= array.length || array[index] == null) {
            return -1;
        }
        if (array[index].equals(value)) {
            return index;
        }
        int leftSearch = searchPreorder(left(index), value);
        if (leftSearch != -1) return leftSearch;
        int rightSearch = searchPreorder(right(index), value);
        return rightSearch;
    }

    
    public int searchPreorder(Object value) {
        return searchPreorder(1, value);
    }

    
    public boolean insertLeft(Object parentValue, Object newValue) {
        int parentIndex = searchPreorder(parentValue);
        if (parentIndex == -1) {
            System.out.println("Parent value not found!");
            return false;
        }
        int leftIndex = left(parentIndex);
        if (leftIndex < array.length && array[leftIndex] == null) {
            setCargo(leftIndex, newValue);
            return true;
        } else {
            System.out.println("Left child already occupied or index out of bounds.");
            return false;
        }
    }

    
    public boolean insertRight(Object parentValue, Object newValue) {
        int parentIndex = searchPreorder(parentValue);
        if (parentIndex == -1) {
            System.out.println("Parent value not found!");
            return false;
        }
        int rightIndex = right(parentIndex);
        if (rightIndex < array.length && array[rightIndex] == null) {
            setCargo(rightIndex, newValue);
            return true;
        } else {
            System.out.println("Right child already occupied or index out of bounds.");
            return false;
        }
    }

    
    public void printPreorder(int i) {
        if (getCargo(i) == null) return;
        System.out.println(getCargo(i));
        printPreorder(left(i));
        printPreorder(right(i));
    }


   public static void main(String[] args) {
        
        Tree tree = new Tree("A");

        
        tree.insertLeft("A", "B");    
        tree.insertRight("A", "C");  

        tree.insertLeft("B", "D");    
        tree.insertLeft("C", "E");    
        tree.insertRight("C", "F");   

        tree.insertRight("E", "G");   
        tree.insertLeft("F", "H");    
        tree.insertRight("F", "I");   

        
        System.out.println("Preorder traversal of the tree:");
        tree.printPreorder(1);
		
		
		
		

        String searchValue = "H";  
		int foundIndex = tree.searchPreorder(searchValue);
		if (foundIndex != -1) {
			System.out.println("'" + searchValue + "' found at index: " + foundIndex);
		} else {
			System.out.println("'" + searchValue + "' not found in the tree.");
		}

		searchValue = "Z";  
		foundIndex = tree.searchPreorder(searchValue);
		if (foundIndex != -1) {
			System.out.println("'" + searchValue + "' found at index: " + foundIndex);
		} else {
			System.out.println("'" + searchValue + "' not found in the tree.");
		}
    }
}