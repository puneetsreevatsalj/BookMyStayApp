import java.util.*;

public class BookingHistory {

    private List<Reservation> history = new ArrayList<>();

    public void addReservation(Reservation r) {
        history.add(r);
    }

    public List<Reservation> getAllReservations() {
        return history;
    }

    // NEW: check existence
    public boolean exists(String id) {
        for (Reservation r : history) {
            if (r.getReservationId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public void displayHistory() {
        System.out.println("\n=== Booking History ===");
        for (Reservation r : history) {
            System.out.println(r);
        }
    }
}