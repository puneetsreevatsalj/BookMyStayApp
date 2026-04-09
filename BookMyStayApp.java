import java.util.HashMap;
import java.util.Map;

public class BookMyStayApp {
    public static void main(String[] args) {

        System.out.println("Welcome to BookMyStay - Hotel Booking System v8.0");

        // Rooms
        Room single = new SingleRoom(0);
        Room doubleR = new DoubleRoom(0);
        Room suite = new SuiteRoom(0);

        // Inventory
        RoomInventory inventory = new RoomInventory();
        inventory.addRoomType(single.roomType, 5);
        inventory.addRoomType(doubleR.roomType, 3);
        inventory.addRoomType(suite.roomType, 2);

        // Queue
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        bookingQueue.addRequest(new Reservation("Alice", "Single Room"));
        bookingQueue.addRequest(new Reservation("Bob", "Suite Room"));
        bookingQueue.addRequest(new Reservation("Charlie", "Double Room"));
        bookingQueue.addRequest(new Reservation("David", "Single Room"));
        bookingQueue.addRequest(new Reservation("Eve", "Single Room"));

        bookingQueue.displayQueue();

        // ✅ UC8 History
        BookingHistory history = new BookingHistory();

        // UC6 + UC8 Service
        ReservationService service = new ReservationService(inventory, bookingQueue, history);
        service.processReservations();

        // Display Inventory
        inventory.displayInventory();

        // Display History
        history.displayHistory();

        // Reports
        BookingReportService reportService = new BookingReportService(history);
        reportService.generateSummary();
        reportService.generateRoomTypeReport();
    }
}