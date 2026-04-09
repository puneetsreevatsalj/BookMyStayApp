import java.util.HashMap;
import java.util.Map;

public class BookMyStayApp {
    public static void main(String[] args) {
        System.out.println("Welcome to BookMyStay - Hotel Booking System v6.0");

        // Initialize rooms
        Room single = new SingleRoom(0);
        Room doubleR = new DoubleRoom(0);
        Room suite = new SuiteRoom(0);

        // Inventory
        RoomInventory inventory = new RoomInventory();
        inventory.addRoomType(single.roomType, 5);
        inventory.addRoomType(doubleR.roomType, 3);
        inventory.addRoomType(suite.roomType, 2);

        // Room map
        Map<String, Room> rooms = new HashMap<>();
        rooms.put(single.roomType, single);
        rooms.put(doubleR.roomType, doubleR);
        rooms.put(suite.roomType, suite);

        // Booking queue
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        bookingQueue.addRequest(new Reservation("Alice", "Single Room"));
        bookingQueue.addRequest(new Reservation("Bob", "Suite Room"));
        bookingQueue.addRequest(new Reservation("Charlie", "Double Room"));
        bookingQueue.addRequest(new Reservation("David", "Single Room"));
        bookingQueue.addRequest(new Reservation("Eve", "Single Room")); // may fail

        bookingQueue.displayQueue();


        ReservationService service = new ReservationService(inventory, bookingQueue);
        service.processReservations();

        // Final inventory
        inventory.displayInventory();
    }
}