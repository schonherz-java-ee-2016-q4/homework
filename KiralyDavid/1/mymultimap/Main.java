package mymultimap;

public class Main {

	public static void main(String[] args) {
		MultiMap<String, String> map = new MyMultiMap<>();
		map.put("1", "egy");
		map.put("1", "egy");
		map.put("2", "kettő");
		map.put("2", "kettő");
		map.put("2", "kettő");
		map.put("3", "nem");
		System.out.println(map.remove("1", "egy"));
		System.out.println(map.containsValue("marci"));
		System.out.println(map);

	}

}
