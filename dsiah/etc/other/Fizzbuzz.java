import java.util.Scanner;

public class Fizzbuzz {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] input = new int[3];

		for (int i = 0; i < 3; i++) {
			input[i] = scan.nextInt();
		}

		for (int j = 1; j <= input[2]; j++) {
			if (j % input[0] == 0 && j % input[1] == 0) {
				System.out.print("FB");
			} else if (j % input[0] == 0) {
				System.out.print("F");
			} else if (j % input[1] == 0) {
				System.out.print("B");
			} else {
				System.out.print(j);
			}

			if (j != input[2]) {
				System.out.print(" ");
			} else {
				System.out.print("\n");
			}
		}

	}
}