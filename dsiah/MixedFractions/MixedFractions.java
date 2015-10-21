import java.util.Scanner;

public class MixedFractions {
	public static int[] divide (int i1, int i2) {
		int[] output = new int[2];
		output[0] = i1 / i2;
		output[1] = i1 % i2;
		return output;
	}

	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int i1 = 1;
		int i2 = 1;
		while (true) {
			int[] answer = new int[2];
			i1 = scan.nextInt();
			i2 = scan.nextInt();
			if (i1 == 0 && i2 == 0) break;
			answer = divide(i1, i2);
			System.out.println(answer[0] + " " + answer[1] + " / " + i2);
		}
		
	}
}