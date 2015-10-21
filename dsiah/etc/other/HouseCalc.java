public class HouseCalc {
	//static value to hold the total of the house's purchases
	static float total = 0;

	//instance of the member who holds the subtotal 
	public class Member() {
		float subtotal = 0;
	}

	void add(float entry) {
		subtotal += entry;
		total += entry;
	}
	void subtract(float entry) {
		subtotal -= entry;
		subtotal -= entry;
	}
	// implementation 
	public static void main(String[] args) {
		
	}
}