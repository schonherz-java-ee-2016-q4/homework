package hu.schonherz.szati.homework;

public class MyMain {

	public static void main(String[] args) {
		MyMultimap<Integer, String> mmp = new MyMultimap<Integer, String>();

		System.out.println("mmp put (1, try): " + mmp.put(1, "try"));
		System.out.println("mmp put (1, 23): " + mmp.put(1, "23"));
		System.out.println("mmp put (42, no): " + mmp.put(42, "no"));
		
		System.out.println("mmp is empty: " + mmp.isEmpty());
		System.out.println("mmp size: " + mmp.size());

		System.out.println();

		System.out.println("mmp contains key 1: " + mmp.containsKey(1));
		System.out.println("mmp get 1: " + mmp.get(1));
		System.out.println("mmp contains key 2: " + mmp.containsKey(2));
		System.out.println("mmp get 2: " + mmp.get(2));

		System.out.println();

		
		System.out.println("mmp cotains value try: " + mmp.containsValue("try"));
		System.out.println("mmp contains value 55: " + mmp.containsValue("55"));

		System.out.println("mmp remove key 42: " + mmp.remove(42));
		System.out.println("mmp remove (1, 23): " + mmp.remove(1, "23"));
		System.out.println("mmp remove (21321, 4743): " + mmp.remove(21321, "4743"));

		System.out.println();
		
		MyMultimap<Integer, String> mmp2 = new MyMultimap<Integer, String>();
		System.out.println("declare mmp2 as an empty multimap");
		System.out.println("mmp equals with mmp2: " + mmp.equals(mmp2));
		System.out.println("mmp has the same hashcode as mmp2: " + (mmp.hashCode() == mmp2.hashCode()));
		
		mmp.clear();
		System.out.println("mmp size after clear: " + mmp.size());
		
		System.out.println("mmp equals with mmp2: " + mmp.equals(mmp2));
		System.out.println("mmp has the same hashcode as mmp2: " + (mmp.hashCode() == mmp2.hashCode()));
		
	}

}
