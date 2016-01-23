/**
 *
 *  @author Filipiuk Igor S7334
 *
 */
package zad2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomersPurchaseSortFind {

	public void readFile(String fname) {
		try {
			BufferedReader br;

			br = new BufferedReader(new FileReader("klienci.txt"));
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}
	
		String line;
		HashMap<String, ArrayList<Purchase>> data = new HashMap<String, ArrayList<Purchase>>();
		while ((line = br.readLine()) != null) {
			Purchase p = new Purchase(line);
			ArrayList<Purchase> l = data.get(p.getId());
			if (l == null) {
				l = new ArrayList<Purchase>();
				data.put(p.getId(), l);
			}
			l.add(p);
		}
	
	List<Purchase> allData = new ArrayList<Purchase>();
	
	for(Map.Entry<String, ArrayList<Purchase>> e : data.entrySet()) {
		allData.addAll(e.getValue());
	}
	public void showSortedBy(String string) {
		
		if (string == "Nazwiska"){
			
			System.out.println("Nazwiska");
			Collections.sort(allData, new Comparator<Purchase>() {
				public int compare(Purchase l1, Purchase l2) {
					int c = l1.getName().compareTo(l2.getName());
					if(c == 0) {
						return l1.getId().compareTo(l2.getId());
					}
					return c;
				}
			});
			for (Purchase k : allData) {
				System.out.println(k);
			}
							
		}
		if (string == "Koszty"){
			System.out.println("\nKoszty");
			Collections.sort(allData, new Comparator<Purchase>() {
				public int compare(Purchase l1, Purchase l2) {
					double c = l2.getMul() - l1.getMul();
					if(c == 0) {
						return l1.getId().compareTo(l2.getId());
					}
					return (int) c;
				}
			});
			for (Purchase p : allData) {
				System.out.println(p.toString(true));
			}
			
			
		}
		
	}
	
}
