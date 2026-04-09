import java.util.HashMap;
import java.util.Map;

public class BookMyStayApp {
    public static void main(String[] args) {
        System.out.println("Welcome to BookMyStay - Hotel Booking System v4.0");

        // Initialize rooms
        Room single = new SingleRoom(0);
        Room doubleR = new DoubleRoom(0);
        Room suite = new SuiteRoom(0);

        // Initialize centralized inventory
        RoomInventory inventory = new RoomInventory();
        inventory.addRoomType(single.roomType, 5);
        inventory.addRoomType(doubleR.roomType, 0); // simulate unavailable
        inventory.addRoomType(suite.roomType, 2);

        // Map for easy access
        Map<String, Room> rooms = new HashMap<>();
        rooms.put(single.roomType, single);
        rooms.put(doubleR.roomType, doubleR);
        rooms.put(suite.roomType, suite);

        // Search service
        RoomSearchService searchService = new RoomSearchService(inventory);
        searchService.searchAvailableRooms(rooms);
    }
}