

	import java.io.FileNotFoundException;

	public class Driver {

	public static void main(String[] args) throws FileNotFoundException {
	  
		 wordFrequencyCounter wp=new  wordFrequencyCounter("demo.txt");
	wp.countWords();

	}
}
