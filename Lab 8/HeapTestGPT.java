public class HeapTestGPT {
    public static void main(String[] args) {
        // Create a new heap
        Heap heap = new Heap();

        // Test case 1: Insert a large number of elements into the heap
        for (int i = 100; i >= 1; i--) {
            heap.insert(i * 2);
        }

        System.out.println("Heap after insertion:");
        heap.printHeapArray();

        // Test case 2: Delete the root element multiple times
        for (int i = 0; i < 20; i++) {
            int deletedRoot = heap.deleteRoot();
            System.out.println("Deleted root element: " + deletedRoot);
        }

        System.out.println("Heap after deletion:");
        heap.printHeapArray();

        // Test case 3: Insert more elements into the heap
        for (int i = 101; i <= 110; i++) {
            heap.insert(i * 3);
        }

        System.out.println("Heap after additional insertion:");
        heap.printHeapArray();

        // Test case 4: Perform heap sort
        System.out.println("Heap sort:");
        heap.makeHeapSort();
        // Expected output: Elements in sorted order

        // Test case 5: Find the level of a node
        int nodeIndex = 15; // Index of the node to find the level
        int nodeLevel = heap.findLevel(nodeIndex);
        System.out.println("Level of node at index " + nodeIndex + ": " + nodeLevel);
        // Expected output: Level of node at index 15: 2
    }
}
