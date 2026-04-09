import java.util.Map;

public class RoomSearchService {

    private RoomInventory inventory;

    public RoomSearchService(RoomInventory inventory) {
        this.inventory = inventory;
    }

    public void searchAvailableRooms(Map<String, Room> rooms) {
        System.out.println("\nAvailable Rooms for Guests:");

        for (Map.Entry<String, Room> entry : rooms.entrySet()) {
            String roomType = entry.getKey();
            Room room = entry.getValue();
            int available = inventory.getAvailability(roomType);

            if (available > 0) {
                System.out.println(roomType + " - INR " + room.price + " per night (" + available + " available)");
            }
        }
    }
}