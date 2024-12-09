import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class PhoneBook {
    private final Map<String, String> contacts;
    private final TreeMap<String, String> sortedNames;

    public PhoneBook() {
        this.contacts = new HashMap<>();
        this.sortedNames = new TreeMap<>();
    }
    public int add(String name, String number) {
        if (!contacts.containsKey(name)) {
            contacts.put(name, number);
            sortedNames.put(name, number);
            return contacts.size();
        }
        return contacts.size();
    }
    public String findByNumber(String number) {
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            if (entry.getValue().equals(number)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public String findByName(String name) {
        return contacts.get(name);
    }

    public void printAllNames() {
        for (String name : contacts.keySet()) {
            System.out.println(name);
        }
    }
}