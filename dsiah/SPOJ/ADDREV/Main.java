// Addrev
import java.util.Scanner;
import java.lang.StringBuilder;

public class Main {
	//Integer.parseInt("1234");
	public static String[] scanReverse () {
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		String[] two = line.split(" ");
		two[0] = new StringBuilder(two[0]).reverse().toString();
		two[1] = new StringBuilder(two[1]).reverse().toString();
		return two;
	}

	public static void addReversePrint (String[] input) {
		int sum = Integer.parseInt(input[0]) + Integer.parseInt(input[1]);
		String out = new StringBuilder(Integer.toString(sum)).reverse().toString();
		System.out.println(Integer.parseInt(out));
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int runtime = scan.nextInt();
		int[] flipped = new int[2];

		for (int i = 0; i < runtime; i++) {
			String[] into = scanReverse();
			addReversePrint(into);
		}
	}
}