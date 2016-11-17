package hu.homework.davidp;

public class Main {

    public static void main(String[] args) {
        DefaultMultiMap<String, String> testMap = new DefaultMultiMap<>();

        testMap.put("Batman", "batknife");
        testMap.put("Batman", "batmobile");
        testMap.put("Robin", "65");
        testMap.put("Snoop Dogg", "420");

        System.out.println("testmap in its full glory: ");
        testMap.entrySet().forEach(System.out::println);

        testMap.remove("Robin");
        System.out.println("\nafter robin removed from the testmap: ");
        testMap.entrySet().forEach(System.out::println);

        System.out.println("\nlet's take the batknife from Batman: ");
        testMap.remove("Batman","batknife");
        testMap.entrySet().forEach(System.out::println);

        System.out.println("check if testmap contains the \"32\" value");
        System.out.println(testMap.containsValue("32"));

        System.out.println("check if testmap contains the batmobile value");
        System.out.println(testMap.containsValue("batmobile"));

    }
}
