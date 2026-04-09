import java.util.HashMap;
import java.util.Map;

public class RoomInventory {
    private Map<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();
    }

    public void addRoomType(String roomType, int count) {
        inventory.put(roomType, count);
    }

    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    public void updateAvailability(String roomType, int newCount) {
        if (inventory.containsKey(roomType)) {
            inventory.put(roomType, newCount);
        }
    }

    public void displayInventory() {
        System.out.println("\nCurrent Room Inventory:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue() + " rooms available");
        }
    }


    public synchronized boolean isAvailable(String roomType) {
    return getAvailability(roomType) > 0;
}


    public synchronized void decrement(String roomType) throws InvalidBookingException {
    int current = getAvailability(roomType);

    if (current <= 0) {
        throw new InvalidBookingException("No rooms available for " + roomType);
    }

    updateAvailability(roomType, current - 1);
}
    }
}