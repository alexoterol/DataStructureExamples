import java.util.HashMap;

class HashTableExample {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        System.out.println("Value for key 1: " + map.get(1));
    }
}