import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	
	public static void main(String[] args) {
		String s = "hellocarapple";
						
		Set<String> dict = new HashSet<String>();
		dict.add("hello");
		dict.add("car");
		dict.add("apple");
		
		boolean [] ss = new boolean[s.length() + 1];
		
		for (int i = 0; i < s.length(); i++) {
			String prefix = s.substring(0, i);
			if (dict.contains(prefix)) {
				ss[i] = true;				
			}
			
			for (int j = 0; j <= i; j++) {
				if (ss[j]) {
					String rest = s.substring(j, i + 1);
					if (dict.contains(rest)) {
						ss[i+1] = true;
					}
				}
			}
		}
		System.out.println(ss[s.length()]);
	}
}
