import java.util.LinkedList;
import java.util.Queue;

public class BookingRequestQueue {
    private Queue<Reservation> queue;

    public BookingRequestQueue() {
        queue = new LinkedList<>();
    }

    public void addRequest(Reservation reservation) {
        queue.add(reservation);
        System.out.println("Added booking request: " + reservation);
    }

    public Reservation nextRequest() {
        return queue.peek();
    }

    public Reservation processNext() {
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void displayQueue() {
        System.out.println("\nCurrent Booking Requests in Queue:");
        for (Reservation r : queue) {
            System.out.println(r);
        }
    }
}