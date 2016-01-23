/**
 *
 *  @author Filipiuk Igor S7334
 *
 */

package zad1;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Anagrams {

	Map<String, List<String>> m = new HashMap<String, List<String>>();
	try {
		Scanner s = new Scanner(new File("unixdict.txt"));
		while (s.hasNext()) {
			String word = s.next();
			char[] ch = word.toCharArray();
			Arrays.sort(ch);
			String sorted = new String(ch);
			List<String> l = m.get(sorted);
			if (l == null)
				m.put(sorted, l = new ArrayList<String>());
			l.add(word);

		}

		List<List<String>> top = new ArrayList<List<String>>();
		for (List<String> l : m.values()) {
			if (l.size() > 1)
				top.add(l);
		}

		Collections.sort(top, new Comparator<List<String>>() {
			public int compare(List<String> l1, List<String> l2) {
				return l2.size() - l1.size();
			}
		});

		for (List<String> l : top) {
			System.out.println("Liczba anagramĂłw - " + l.size() + ": " + l);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
	public Anagrams(String allWords) {
		// TODO Auto-generated constructor stub
	}

	public Object getSortedByAnQty() {
		Collections.sort(top, new Comparator<List<String>>() {
			public int compare(List<String> l1, List<String> l2) {
				return l2.size() - l1.size();
			}
		});
		return null;
	}
}  
