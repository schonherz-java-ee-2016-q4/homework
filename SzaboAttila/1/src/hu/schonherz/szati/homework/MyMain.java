package hu.schonherz.szati.homework;

public class MyMain {

	public static void main(String[] args) {
		System.out.println("hello!");
		MyMultimap mmp = new MyMultimap();
		
		mmp.put("asd", "vcxcv");
		mmp.put(1, "asd");
		mmp.put(1, 1);
		mmp.put(2321, "asdasdas");
		
		System.out.println(mmp.values());
		System.out.println(mmp.entrySet());
		System.out.println(mmp.containsValue(2));
		System.out.println(mmp.containsKey(1));
		
		
	}

}
