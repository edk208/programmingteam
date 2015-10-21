import java.util.ArrayList;

public class Graph2 {
	ArrayList<ArrayList<Integer>> g;
	public Graph2() {
		g = new ArrayList<ArrayList<Integer>>();
	}

	public void addNode(int val) {
		g[val][val].add(0);
	}

	public String toString() {
		String output = "";
		for (ArrayList row: g) {
			for (int unit: row) {
				output += unit + " ";
			}
			output += "\n";
		}
		return output;
	}

	public static void main(String[] args) {
		Graph2 g2 = new Graph2();
		System.out.println(g2);
	}
}