public class Member {
	//static value to hold the total of the house's purchases,
	//static value to hold number of members created
	//static value to calculate average
	static double total = 0;
	static int numInstances = 0;
	static double average = 0;

	double subtotal;
	String name;

	//instance of the member who holds the subtotal 
	public Member(String name) {
		this.name = name;
		subtotal = 0;
		numInstances++;
	}

	// add and subtract methods for the subtotals (and total)
	void add(double entry) {
		subtotal += entry;
		total += entry;
	}
	void subtract(double entry) {
		subtotal -= entry;
		subtotal -= entry;
	}

	String pSubtotal() {
		String output = "";
		output = this.name + ", your total is $" + this.subtotal;

		return output;
	}

	double percentage() {
		double perc = total / this.subtotal;
		return perc;
	}

	static double calcAve() {
		return average = total / numInstances;
	}

	// calculate how much a member owes or is owed
	// then return the string
	String howMuchOwed() {
		double owed = this.subtotal - calcAve();
		String output = "";

		if (owed > 0) {
			output += "You are owed $" + owed;
			return output;
		} else if (owed < 0) {
			output += "You owe $" + owed*(-1);
			return output;
		} else {
			return "You owe nothing!";
		}
	}

	// class implementation
	public static void main(String[] args) {
		Member[] house = new Member[4];

		/*
		house[0] john = new Member("John");
		house[1] dan = new Member("Dan");
		house[2] ted = new Member("Ted");
		house[3] david = new Member("David");
		*/

		Member john = new Member("John");
		Member dan = new Member("Dan");
		Member ted = new Member("Ted");
		Member david = new Member("David");

		house[0] = john;
		house[1] = dan;
		house[2] = ted;
		house[3] = david;

		david.add(12.33);
		john.add(11.00);
		dan.add(100.90);
		dan.subtract(30.99);

		calcAve();

		System.out.println("The average is " + calcAve() + 
			"\n----------------------------");

		System.out.println(david.pSubtotal());
		System.out.println(david.howMuchOwed());
		
	}
}