public class HistogramFactory {
	 private String method;
	 
	 /**
	  * The type of method we want to generate
	  */
	 public void setMethod(String method) {
		 this.method = method;
	 }
	 
	 public FrequencyHist getMethod() {
		 if(method == "parallel")
			 return new Threaded();
		 else if(method == "sequential")
			 return new NonThreaded();
		 
		 return null;
	 }
}
