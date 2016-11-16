package homework1;

public class main {

	public static void main(String[] args) {
		MyMultimap m = new MyMultimap();
		m.put(0, "elso");
		m.put(0, "masodik");
		m.put(2, "csak");
		m.put("pokelabda", "pikachu");

		System.out.println("A map tartalma:");
		m.printout();

		m.remove(0, "elso");
		System.out.println("Toroltem a '0' kulcs elso erteku bejegyzeset");
		m.printout();

		System.out.println("Toroltem a '2'-es erteku kulcsot");
		m.remove(2);
		m.printout();
	}
}
