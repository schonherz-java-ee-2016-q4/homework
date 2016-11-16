package multimaphomework;

public class Test {

	public static void main(String[] args) {
		MyMultiMap<String, Integer> mymmap = new MyMultiMap<String, Integer>();
		mymmap.put("Monkey", 8);
		mymmap.put("Beaver", 3);
		mymmap.put("Monkey", 5);
		mymmap.put("Monkey", 8);
		mymmap.put("Cat", 7);
		mymmap.put("Monkey", 1);
		
		System.out.println("Size of mymmap: " + mymmap.size());
		System.out.println("Elements of mymmap:");
		for (Object i : mymmap.entrySet()) {
			System.out.println(i);
		}
		System.out.println();
		System.out.println("Is the mymmap contains the key (Beaver)? : " + (mymmap.containsKey("Beaver")?"Yes":"No"));
		System.out.println("Is the mymmap contains the key (Wolf)? : " + (mymmap.containsKey("Wolf")?"Yes":"No"));
		System.out.println();
		System.out.println("Is the mymmap contains the value (7)? : " + (mymmap.containsValue(7)?"Yes":"No"));
		System.out.println("Is the mymmap contains the value (99)? : " + (mymmap.containsValue(99)?"Yes":"No"));
		System.out.println();
		System.out.println("After removing key (Beaver):");
		mymmap.remove("Beaver");
		for (Object i : mymmap.entrySet()) {
			System.out.println(i);
		}
		System.out.println();
		System.out.println("After removing value (8) from key (Monkey):");
		mymmap.remove("Monkey", 8);
		for (Object i : mymmap.entrySet()) {
			System.out.println(i);
		}
		System.out.println();
		
		System.out.print("Values of Monkey: " + mymmap.get("Monkey"));
		System.out.println();
		
		mymmap.clear();
		System.out.println("After clear all entries: ");
		for (Object i : mymmap.entrySet()) {
			System.out.println(i);
		}
		System.out.println();
		System.out.println("Is mymmap empty? " + (mymmap.isEmpty()?"Yes.":"No."));
	}

}
