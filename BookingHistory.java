import java.io.Serializable;
import java.util.*;

public class BookingHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Reservation> history = new ArrayList<>();

    public void addReservation(Reservation r) {
        history.add(r);
    }

    public List<Reservation> getAllReservations() {
        return history;
    }

    public void displayHistory() {
        System.out.println("\n=== Booking History ===");

        if (history.isEmpty()) {
            System.out.println("No bookings available.");
            return;
        }

        for (Reservation r : history) {
            System.out.println(r);
        }
    }
}