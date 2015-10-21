// SBANK 
import java.util.Scanner;
import java.util.HashMap;

public class Main {
	public static void main (String[] args) {
		HashMap<String, Integer> map;
		String line;
		int cases, 
			acCount;

		Scanner scan = new Scanner(System.in);
		cases = scan.nextInt();

		while (cases > 0) {
			acCount = scan.nextInt(); // get number of accounts
			map = new HashMap<String, Integer>(acCount);
			while (acCount > 0) {
				line = scan.nextLine();

				if (map.get(line) != null) {
					map.put(line, map.get(key) + 1);
				} else {
					map.put(line, 1);
				}

				System.out.println(map);

				acCount--;
			}

			cases--;
		}
	}
}