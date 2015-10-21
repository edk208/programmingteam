import java.util.Random;
import java.util.Arrays;

public class shuffle1 {
	public static int[] generate100 () {
		Random randomGen = new Random();
		int[] unsorted = new int[100];

		for (int i = 0; i < 100; i++)
			unsorted[i] = randomGen.nextInt(1000);
		
		//System.out.println(Arrays.toString(unsorted));

		return unsorted;
	}

	public static void main (String[] args) {
		int[] unsorted = generate100();
	}
}