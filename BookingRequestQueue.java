import java.util.LinkedList;
import java.util.Queue;

public class BookingRequestQueue {
    private Queue<Reservation> queue;

    public BookingRequestQueue() {
        queue = new LinkedList<>();
    }

    // synchronized enqueue
public synchronized void addRequest(Reservation reservation) {
    queue.add(reservation);
    System.out.println(Thread.currentThread().getName() +
            " added: " + reservation);
}

    public Reservation nextRequest() {
        return queue.peek();
    }

    // synchronized dequeue
public synchronized Reservation processNext() {
    return queue.poll();
}

    // synchronized check
public synchronized boolean isEmpty() {
    return queue.isEmpty();
}

    public void displayQueue() {
        System.out.println("\nCurrent Booking Requests in Queue:");
        for (Reservation r : queue) {
            System.out.println(r);
        }
    }
}