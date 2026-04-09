import java.util.*;

public class BookingHistory {

    // List to store confirmed reservations (ordered)
    private List<Reservation> history;

    public BookingHistory() {
        history = new ArrayList<>();
    }

    // Add confirmed booking
    public void addReservation(Reservation reservation) {
        history.add(reservation);
    }

    // Get all reservations
    public List<Reservation> getAllReservations() {
        return history;
    }

    // Display history
    public void displayHistory() {
        System.out.println("\n=== Booking History ===");

        if (history.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }

        for (Reservation r : history) {
            System.out.println(r);
        }
    }
}