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
        
        //Add-On Services
AddOnServiceManager serviceManager = new AddOnServiceManager();

// Example reservations (you can track IDs properly if needed)
Reservation r1 = new Reservation("Alice", "Single Room");
Reservation r2 = new Reservation("Bob", "Suite Room");

// Add services
serviceManager.addService(r1.getReservationId(), new AddOnService("Breakfast", 500));
serviceManager.addService(r1.getReservationId(), new AddOnService("WiFi", 200));

serviceManager.addService(r2.getReservationId(), new AddOnService("Airport Pickup", 1000));

// Display services
serviceManager.displayServices(r1.getReservationId());
serviceManager.displayServices(r2.getReservationId());

        // Final inventory
        inventory.displayInventory();
    }
}