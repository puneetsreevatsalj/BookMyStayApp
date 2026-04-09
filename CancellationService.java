import java.util.*;

public class CancellationService {

    private RoomInventory inventory;
    private BookingHistory history;

    // Stack for rollback (LIFO)
    private Stack<String> releasedRooms = new Stack<>();

    public CancellationService(RoomInventory inventory, BookingHistory history) {
        this.inventory = inventory;
        this.history = history;
    }

    public void cancelReservation(String reservationId) {

        Reservation target = null;

        // Find reservation
        for (Reservation r : history.getAllReservations()) {
            if (r.getReservationId().equals(reservationId)) {
                target = r;
                break;
            }
        }

        if (target == null) {
            System.out.println("Cancellation Failed: Reservation not found.");
            return;
        }

        String roomType = target.getRoomType();

        // Simulate releasing room ID
        String releasedRoomId = "REL-" + UUID.randomUUID().toString().substring(0, 5);
        releasedRooms.push(releasedRoomId);

        // Restore inventory
        inventory.updateAvailability(roomType,
                inventory.getAvailability(roomType) + 1);

        // Remove from history
        history.getAllReservations().remove(target);

        System.out.println("Cancellation Successful!");
        System.out.println("Reservation ID: " + reservationId);
        System.out.println("Released Room ID: " + releasedRoomId);
    }
}