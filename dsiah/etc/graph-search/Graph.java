import java.util.ArrayList;

public class Graph {
	int vCount;
	ArrayList<Vert> nodes;

	public Graph() {
		vCount = 0;
		nodes = new ArrayList<Vert>();
	}

	public void addNode(Vert n) {
		nodes.add(n);
		vCount++;
	}

	public void addNode(String n) {
		Vert j = new Vert(n);
		nodes.add(j);
		vCount++;
	}

	public String toString() {
		String output = "[ ";
		for (Vert n: nodes) {
			output += n + " ";
		}
		return output + "] Size : " + vCount;
	}

	public static void main(String[] args) {
		System.out.println("Working!");

	}
}

class Edge {
	Vert v1;
	Vert v2;
	int weight = 0;

	public Edge(Vert v1, Vert v2) {
		this.v1 = v1;
		this.v2 = v2;
	}

	public void adjustWeight(int newWeight) {
		weight = newWeight;
	}

	public String toString() {
		String output = v1 + "--" + v2;
		return output;
	}
}

class Vert {
	String label;
	ArrayList<Edge> neighbors;
	int degrees;

	public Vert(String label) {
		neighbors = new ArrayList<Edge>();
		this.label = label;
	}

	public void addEdge(Vert v) {
		neighbors.add(v);
		degrees++;
	}

	public String toString() {
		return label;
	}
}