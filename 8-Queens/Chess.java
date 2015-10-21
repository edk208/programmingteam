import java.util.Scanner;
import java.util.Arrays;

public class Chess {
	public static boolean checkRLDiagonal (int[] rows) {
		boolean valid = true;
		int[] rlSums = new int[8];
		for (int i = 0; i < 8; i++) {
			rlSums[i] = i + rows[i];
		}
		Arrays.sort(rlSums);
		for (int j = 0; j < 7; j++) {
			if (rlSums[j] == rlSums[j + 1]) {
				valid  = false;
				return valid;
			}
		}
		return valid;
		//System.out.println("passed checkRLDiagonal");
	}

	public static boolean checkLRDiagonal (int[] rows) {
		boolean valid = true;
		for (int i = 0; i < 7; i++) {
			for (int j = i + 1; j < 8; j++) {
				if (rows[i] == rows[j] + (i-j)) {
					valid = false;
					return valid;
				}
			}
		}
		return valid;
		//System.out.println("passed checkLRDiagonal");
	}

	public static boolean checkColumns (int[] rows) {
		int[] sorted = new int[8];
		boolean valid = true;
		System.arraycopy(rows, 0, sorted, 0, 8);
		Arrays.sort(sorted);
		for (int i = 0; i < 7; i++) {
			if (sorted[i] == sorted[i+1]) {
				valid = false;
				return valid;
			} 
		}
		return valid;
		//System.out.println("passed checkColumns");
	}


	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
		String line;
		boolean valid = true;
		int[] rows = new int[8];
		
		for (int i = 0; i < 8; i++) {
			line = scan.nextLine();
			if (line.indexOf('*') > -1 && line.indexOf('*') == line.lastIndexOf('*')) 
				rows[i] = line.indexOf('*');
			else {
				valid = false;
				break;
			}
		}
		
		if (valid == true && checkColumns(rows) && checkRLDiagonal(rows) 
			&& checkLRDiagonal(rows)) 
			System.out.println("valid");
		else 
			System.out.println("invalid");
	}
}