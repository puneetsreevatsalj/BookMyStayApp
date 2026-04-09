import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class RoomInventory implements Serializable {

    private static final long serialVersionUID = 1L;

    private Map<String, Integer> inventory = new HashMap<>();

    public void addRoomType(String type, int count) {
        inventory.put(type, count);
    }

    public int getAvailability(String type) {
        return inventory.getOrDefault(type, 0);
    }

    public synchronized boolean isAvailable(String type) {
        return getAvailability(type) > 0;
    }

    public synchronized void decrement(String type) {
        inventory.put(type, getAvailability(type) - 1);
    }

    public void displayInventory() {
        System.out.println("\nInventory:");
        for (Map.Entry<String, Integer> e : inventory.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
    }
}