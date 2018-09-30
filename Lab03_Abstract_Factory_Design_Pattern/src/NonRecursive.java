
public class NonRecursive extends SortFactory {
	@Override
	public SortingAlgorithm getAlgorithm() {
		SortingAlgorithm algo = null;
		if(super.algorithm == "insertion")
			algo = new InsertionSort();
		else if(super.algorithm == "selection")
			algo = new SelectionSort();
		
		return algo;
	}

}
