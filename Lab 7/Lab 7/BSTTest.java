public class BSTTest {
    public static void main(String[] args) {
        // Create a BST with integers
        BST<Integer> bst = new BST<>();
        
        // Insert some elements
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        // Test size
        System.out.println("Size after insertion: " + bst.getSize()); // Should print 7

        // print tree
        bst.PrintBFT();
        System.out.println();

        // Test search
        System.out.println("Search 30: " + bst.search(30)); // Should print true
        System.out.println("Search 45: " + bst.search(45)); // Should print false

        // Test delete
        bst.delete(20);
        bst.delete(70);

        // Test size
        System.out.println("Size after deletion: " + bst.getSize()); // Should print 5

        // print tree
        bst.PrintBFT();
        System.out.println();

        // Test findSmallest and findLargest
        System.out.println("Smallest element: " + bst.findSmallest().element); // Should print 30
        System.out.println("Largest element: " + bst.findLargest().element);   // Should print 80

        // Test path
        int target = 40;
        System.out.println("Path to " + target + ": " + bst.path(target)); // Should print the path from the root to 40
    }
}
