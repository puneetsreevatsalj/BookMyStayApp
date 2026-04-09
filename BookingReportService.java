import java.util.*;

public class BookingReportService {

    private BookingHistory history;

    public BookingReportService(BookingHistory history) {
        this.history = history;
    }

    // Total bookings report
    public void generateSummary() {
        List<Reservation> reservations = history.getAllReservations();

        System.out.println("\n=== Booking Summary Report ===");
        System.out.println("Total Bookings: " + reservations.size());
    }

    // Room type report
    public void generateRoomTypeReport() {
        List<Reservation> reservations = history.getAllReservations();

        Map<String, Integer> countMap = new HashMap<>();

        for (Reservation r : reservations) {
            String type = r.getRoomType();
            countMap.put(type, countMap.getOrDefault(type, 0) + 1);
        }

        System.out.println("\n=== Room Type Report ===");

        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue() + " bookings");
        }
    }
}