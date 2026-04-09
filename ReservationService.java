import java.util.*;

public class ReservationService {

    private RoomInventory inventory;
    private BookingRequestQueue queue;

    private Map<String, Set<String>> allocatedRooms = new HashMap<>();

    public ReservationService(RoomInventory inventory, BookingRequestQueue queue) {
        this.inventory = inventory;
        this.queue = queue;
    }

    public void processReservations() {

        while (!queue.isEmpty()) {

            Reservation request = queue.processNext();
            String roomType = request.getRoomType();

            System.out.println("\nProcessing: " + request);

            if (inventory.isAvailable(roomType)) {

                String roomId = generateRoomId(roomType);

                allocatedRooms.putIfAbsent(roomType, new HashSet<>());
                allocatedRooms.get(roomType).add(roomId);

                inventory.decrement(roomType);

                System.out.println("Booking Confirmed for " + request.getGuestName());
                System.out.println("Allocated Room ID: " + roomId);

            } else {
                System.out.println("Booking Failed - No rooms available for " + roomType);
            }
        }
    }

    private String generateRoomId(String roomType) {
        return roomType.substring(0, 2).toUpperCase() + "-" +
               UUID.randomUUID().toString().substring(0, 5);
    }
}