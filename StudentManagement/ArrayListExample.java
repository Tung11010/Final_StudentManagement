import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        // Create an ArrayList to store Strings
        ArrayList<String> fruits = new ArrayList<>();

        // Add elements to the ArrayList
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Date");

        System.out.println("Fruits: " + fruits);
        String firstFruit = fruits.get(0);
        System.out.println("First fruit: " + firstFruit);

        fruits.remove("Banana");
        System.out.println("After removing Banana: " + fruits);
        int size = fruits.size();
        System.out.println("Size of the ArrayList: " + size);

        System.out.println("Iterating through the ArrayList:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}
