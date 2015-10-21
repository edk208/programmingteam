import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int temp = scan.nextInt();
		while (temp != 42) {
			System.out.println(temp);
			temp = scan.nextInt();
		}
	}
}