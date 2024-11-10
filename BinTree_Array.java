public class BinTree_Array {
    Object[] array;

   
    public BinTree_Array() {
        array = new Object[128];
    }

    
    public boolean empty() {
        return (array[1] == null);
    }

    
    public int left(int i) {
        return 2 * i;
    }

    
    public int right(int i) {
        return 2 * i + 1;
    }

    
    public int parent(int i) {
        return i / 2;
    }

    
    public Object getCargo(int i) {
        if (i < 0 || i >= array.length) return null;
        return array[i];
    }

   
    public void setCargo(int i, Object obj) {
        if (i < 0 || i >= array.length) return;
        array[i] = obj;
    }

    
    public void printPreorder(int i) {
        if (getCargo(i) == null) return;
        System.out.println(getCargo(i));
        printPreorder(left(i));
        printPreorder(right(i));
    }

    public static void main(String[] args) {
        
        BinTree_Array tree = new BinTree_Array();

        
        int root = 1;
        tree.setCargo(root, "cargo for root");
        tree.setCargo(tree.left(root), "cargo for left");
        tree.setCargo(tree.right(root), "cargo for right");

        tree.printPreorder(root);
    }
}