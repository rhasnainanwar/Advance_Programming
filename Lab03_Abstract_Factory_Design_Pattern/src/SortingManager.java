import java.util.Arrays;

public class SortingManager {

	public static void main(String[] args) {
		// The elements to be sorted
       String[] test1 = {"beta", "chi", "alpha", "zeta", "nu", "mu"};
       String[] test2 = {"beta", "chi", "alpha", "zeta", "nu", "mu"};
       
       /* TEST 1 */
        // The factory -- creates non-recursive sorting algorithms
        SortFactory factory = new NonRecursive();

        // set the factory to selection sorts
        factory.setFactory("selection");
        
        // Get the sorting algorithm from the factory
        SortingAlgorithm algorithm = factory.getAlgorithm();
        
        // apply the algorithm
        algorithm.sort(test1);
        
        /* TEST 2 */
        // set the factory to insertion sorts
        factory.setFactory("insertion");
        
        // Get the sorting algorithm from the factory
        algorithm = factory.getAlgorithm();
        
        // apply the algorithm
        algorithm.sort(test2);
        
        if(Arrays.equals(test1, test2))
        	System.out.println("Test Passed");
        else
        	System.out.println("Test Failed");
        
        /* apply the algorithm
        algorithm.sort(elements);
        
        for (int i = 0; i < elements.length; i++)
            System.out.println(elements[i]);
        */
        
	}

}
