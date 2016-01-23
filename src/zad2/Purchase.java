/**
 *
 *  @author Filipiuk Igor S7334
 *
 */

package zad2;


public class Purchase {
	
	private String id;
	private String name;
	private String product;
	private double price;
	private int amount;
	
	public Purchase(String line) {
		String[] data = line.split(";");
		id = data[0];
		name = data[1];
		product = data[2];
		price = Double.parseDouble(data[3]);
		amount = Integer.parseInt(data[4]);
	}
	
	public String toString() {
		return toString(false);
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public double getMul() {
		return price*amount;
	}
	
	public String toString(boolean mul) {
		return id+";"+name+";"+product+";"+price+";"+amount+(mul?" (koszt:"+price*amount+")":"");
	}
}
