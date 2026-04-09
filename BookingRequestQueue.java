import java.util.LinkedList;
import java.util.Queue;

public class BookingRequestQueue {
    private Queue<Reservation> queue;

    public BookingRequestQueue() {
        queue = new LinkedList<>();
    }

    // Add a booking request
    public void addRequest(Reservation reservation) {
        queue.add(reservation);
        System.out.println("Added booking request: " + reservation);
    }

    // Peek at the next request without removing
    public Reservation nextRequest() {
        return queue.peek();
    }

    // Process and remove next request
    public Reservation processNext() {
        return queue.poll();
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // Display all queued requests
    public void displayQueue() {
        System.out.println("\nCurrent Booking Requests in Queue:");
        for (Reservation r : queue) {
            System.out.println(r);
        }
    }
}