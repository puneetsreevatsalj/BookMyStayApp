import java.util.*;

public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Hotel Booking System - UC12 (Persistence)");

        PersistenceService persistence = new PersistenceService();

        BookingHistory history;
        RoomInventory inventory;

        // ---------------------------
        // LOAD PREVIOUS STATE
        // ---------------------------
        Object[] state = persistence.loadState();

        if (state != null) {
            history = (BookingHistory) state[0];
            inventory = (RoomInventory) state[1];
        } else {
            history = new BookingHistory();
            inventory = new RoomInventory();

            inventory.addRoomType("Single Room", 2);
            inventory.addRoomType("Double Room", 2);
        }

        // ---------------------------
        // NEW BOOKINGS
        // ---------------------------
        BookingRequestQueue queue = new BookingRequestQueue();

        queue.addRequest(new Reservation("Alice", "Single Room"));
        queue.addRequest(new Reservation("Bob", "Double Room"));

        // Validator
        Set<String> valid = new HashSet<>();
        valid.add("Single Room");
        valid.add("Double Room");

        BookingValidator validator = new BookingValidator(valid);

        ReservationService service =
                new ReservationService(inventory, queue, history, validator);

        service.processReservations();

        // ---------------------------
        // DISPLAY STATE
        // ---------------------------
        inventory.displayInventory();
        history.displayHistory();

        // ---------------------------
        // SAVE STATE BEFORE EXIT
        // ---------------------------
        persistence.saveState(history, inventory);

        System.out.println("\nSystem shutdown complete.");
    }
}